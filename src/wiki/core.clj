(ns wiki.core
  (:use compojure.core
        ring.middleware.json
        ring.util.response
  )
  (:require [compojure.route :as route])
)

(defn sayHello [x] (str "hello " x))

(defroutes my_routes
  (GET "/" [] (sayHello "Bessias"))
  (route/resources "/")
)

(def app (wrap-json-response my_routes))
