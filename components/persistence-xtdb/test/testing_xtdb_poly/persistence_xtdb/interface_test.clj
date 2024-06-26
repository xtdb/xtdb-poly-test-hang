(ns testing-xtdb-poly.persistence-xtdb.interface-test
  (:require [clojure.test :refer :all]
            [xtdb.api :as xt]
            [xtdb.node :as xtn]))

(deftest dummy-test
  (testing "this hangs indefinitely"
    (println "Starting node")
    (let [node (xtn/start-node {})
          {:keys [xt/id] :as person} {:xt/id (random-uuid) :name "John Doe"}]
      (println "Transacting person")
      (xt/execute-tx node [[:put-docs :person person]])
      (println "Person transacted")
      (is (= 1 1)))))