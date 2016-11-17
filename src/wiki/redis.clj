(ns wiki.redis
  (:require [taoensso.carmine :as car :refer (wcar)])
)

(def conn {}) ;FIXME pass conn url here
(defmacro wcar* [& body] `(car/wcar conn ~@body))

(defn set [key value]
  (wcar* (car/set key value))
  (println (str "Added[" key "]: " value))
  value
)

(defn get [key]
  (let [result (wcar* (car/get key))]
    (println (str "Got value from cache " result))
    result
  )
)
