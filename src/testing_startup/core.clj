(ns testing-startup.core
  (:require [slipcover.core :as cb])
  (:gen-class))

(defn -main
  [& args]
  (let [start# (. System (nanoTime))]
     (cb/connect! {:bucket-name "relay_data" :username "admin" :password "password" :hosts ["localhost"]})
     (print (str "Elapsed time: " (/ (double (- (. System (nanoTime)) start#)) 1000000.0) " msecs"))
    ))
  ;(time (dosync
         ;(cb/connect! {:bucket-name "relay_data" :username "admin" :password "password" :hosts ["localhost"]})
         ;(cb/insert "key" {:data "value"})
         ;(print (cb/get "key")))))
         ;)))
