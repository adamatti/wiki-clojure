(ns wiki.core
  (:use compojure.core
        ring.middleware.json
        ring.util.response
  )
  (:require [compojure.route :as route]
            [wiki.mongo :as db]
            [wiki.redis :as cache]
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

(defroutes my_routes
  (GET "/" [] (str "Response: " (sayHelloCache "Bessias")))
  (GET "/json" [] (response (sayHello "Bessias"))) ;as json
  (route/resources "/")
)

(def app (wrap-json-response my_routes))
