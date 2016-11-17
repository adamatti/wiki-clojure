(defproject wiki "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :plugins [
    [lein-ring "0.8.7"]
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
    [hiccup "1.0.4"]
    [compojure "1.2.0-SNAPSHOT"],
    [com.novemberain/monger "3.1.0"]
    [com.taoensso/carmine "2.15.0"] ;redis
  ]
  :main ^:skip-aot wiki.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
