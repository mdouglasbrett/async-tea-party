(defproject async-tea-party "0.1.0-SNAPSHOT"
  :description "Living Clojure example of core.async"
  :url "https://github.com/mdouglasbrett/async-tea-party"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.3.465"]]
  :main async-tea-party.core
  :aot [async-tea-party.core])
