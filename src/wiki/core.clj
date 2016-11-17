(ns wiki.core
  (:use compojure.core
        ring.middleware.json
        ring.util.response
  )
  (:require [compojure.route :as route]
            [wiki.mongo :as db]
  )
)

(defn sayHello [x]
  (println (str "Called say hello and find with " x))
  (db/save "testCollection" {:_id "myKey" :lastName "Adamatti" :name "Marcelo"})
  (db/find-one "testCollection" {:_id "myKey"})
)

(defroutes my_routes
  (GET "/" [] (str "Response from mongo: " (sayHello "Bessias")))
  (GET "/json" [] (response (sayHello "Bessias"))) ;as json
  (route/resources "/")
)

(def app (wrap-json-response my_routes))
