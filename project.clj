(defproject testing-startup "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :repositories [["releases"  {:url "s3p://relay-maven-repo/releases/"  :creds :gpg}]
                 ["snapshots" {:url "s3p://relay-maven-repo/snapshots/" :creds :gpg}]]
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
;                 [com.relaynetwork/slipcover "0.3.14" :exclusions [["com.amazonaws/aws-java-sdk"]]]]
  :main ^:skip-aot testing-startup.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
