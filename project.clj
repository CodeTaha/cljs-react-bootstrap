(defproject cljs-react-bootstrap "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [reagent "0.5.1"]
                 [reagent-utils "0.1.7"]
                 [cljsjs/react-bootstrap "0.28.1-1"]
                 [re-frame "0.6.0"]
                 [secretary "1.2.3"]
                 [venantius/accountant "0.1.6"
                  :exclusions [org.clojure/tools.reader]]
                 [figwheel-sidecar "0.5.0-6"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj", "script"]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-1"]]

  :profiles {:dev {:dependencies [[com.cemerick/piggieback "0.2.1"]
                                  [org.clojure/tools.nrepl "0.2.10"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]
             :server-port 3450}

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]
                        :figwheel {:on-jsload "cljs-react-bootstrap.core/mount-root"}
                        :compiler {:main cljs-react-bootstrap.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :asset-path "js/compiled/out"
                                   :source-map-timestamp true}}

                       {:id "min"
                        :source-paths ["src/cljs"]
                        :compiler {:main cljs-react-bootstrap.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :optimizations :whitespace
                                   :closure-defines {goog.DEBUG false}
                                   :pretty-print false}}]})
