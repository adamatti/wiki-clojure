(ns wiki.core
  (:use ring.middleware.resource
        ring.middleware.content-type
        ring.middleware.not-modified
        ring.middleware.file
        ring.middleware.file-info
        compojure.core
        ring.middleware.json
        ring.util.response
  )
  (:require [compojure.route :as route]
            [wiki.mongo :as db]
            [wiki.redis :as cache]
            [wiki.view :as view]
  )
)

(defn sayHello [x]
  (println (str "Called say hello and find with " x))
  (db/save "testCollection" {:_id "myKey" :lastName "Adamatti" :name "Marcelo"})
  (db/find-one "testCollection" {:_id "myKey"})
)

(defn sayHelloCache [x]
  (println (str "Called say hello with " x))
  (cache/set "key" {:lastName "Adamatti"})
  (cache/get "key")
)

(defn sayHelloTemplate [x]
  (view/serve "home" {:title "test"})
)

(defroutes my_routes
  (GET "/" [] (str "Response: " (sayHelloCache "Bessias")))
  (GET "/json" [] (response (sayHello "Bessias"))) ;as json
  (GET "/home" [] (sayHelloTemplate "Bessias"))
  (route/resources "/")
)

(def app
  (->
    (wrap-json-response my_routes)
    (wrap-resource "bower")
    (wrap-file-info)
    ;(wrap-request-logging)
    (wrap-content-type)
    (wrap-not-modified)
    ;(wrap-stacktrace)
  )
)
