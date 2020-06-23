(ns testing-startup.core
  (:require [slipcover.core :as cb])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
;  (time (cb/connect! {:bucket-name "relay_data" :username "admin" :password "password" :hosts ["localhost"]}))
  (time (dosync
          (cb/connect! {:bucket-name "relay_data" :username "admin" :password "password" :hosts ["localhost"]})
          (cb/insert "key" {:data "value"})
          (print (cb/get "key"))
          ))
  (println "Hello, World!"))
