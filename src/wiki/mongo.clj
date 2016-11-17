(ns wiki.mongo
  (:require [monger.core :as mg]
            ;[wiki.config :as cfg]
            [monger.collection :as mc]
  )
  (:import [com.mongodb MongoOptions ServerAddress])
)

(def uri "mongodb://localhost/clojure-test")
(def dbMap (mg/connect-via-uri uri))
(def db (:db dbMap))
;(def conn {dbMap :conn})

;(mc/insert db "collectionName" {:name "adamatti"})

(defn save [collectionName map]
  (mc/save db collectionName map)
  (println (str "Record saved " map))
)

(defn find-one[collectionName query]
  (mc/find-one-as-map db collectionName query)
)
