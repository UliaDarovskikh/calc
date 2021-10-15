(ns myproject.calc-test
  (:require [clojure.test :refer [deftest is testing]]
            [myproject.calc :as sut]))


(deftest ^:unit calc-test
  (testing "сложение проходит правильно"
    (let [op "+"
          x 1
          y 1
          result (sut/calc op x y)]
      (is (= result 2)))
    )
  )
