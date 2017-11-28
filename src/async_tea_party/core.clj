(ns async-tea-party.core
  (:gen-class)
  (:require [clojure.core.async :as async]))

(def google-tea-service-chan (async/chan 10))
(def bing-tea-service-chan (async/chan 10))

(defn random-add []
  (reduce + (conj [] (repeat (rand-int 100000) 1))))

; Todo: clean this up into a generic function
(defn request-google-tea-service []
  (async/go
            (random-add)
            (async/>! google-tea-service-chan
                      "Tea compliments of Google!")))
(defn request-bing-tea-service []
  (async/go
            (random-add)
            (async/>! bing-tea-service-chan
                      "Tea compliments of Microsoft!")))
(defn request-tea []
  (request-google-tea-service)
  (request-bing-tea-service)
  (async/go (let [[v] (async/alts!
                                  [google-tea-service-chan
                                   bing-tea-service-chan])]
              (async/>! result-chan v))))

(defn -main [& args]
  (println "Requesting tea...")
  (request-tea)
  (println (async/<!! result-chan)))
