(ns wiki.view
  (:use selmer.parser)
)

(cache-off!)
(set-resource-path! (clojure.java.io/resource "html"))

(defn serve [fileName properties]
  (render-file (str fileName ".html") properties)
)
