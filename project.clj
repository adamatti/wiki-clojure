(defproject wiki "0.0.1"
  :description "wiki engine"
  :plugins [
    [lein-ring "0.8.7"]
    [lein-bower "0.5.2"]
  ]
  :ring {
    :handler wiki.core/app
    :auto-reload? true
    :auto-refresh? false
  }
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [ring/ring "1.2.0"]
    [ring/ring-json "0.2.0"]
    [compojure "1.2.0-SNAPSHOT"],
    [com.novemberain/monger "3.1.0"]
    [com.taoensso/carmine "2.15.0"] ;redis
    [selmer "1.10.0"]

  ]
  :bower-dependencies [
    bootstrap "~3.3.6"
  ]
  :bower {:directory "resources/bower"}
  :main ^:skip-aot wiki.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
