(ns backend-day.core-test
  (:require [clojure.test :refer :all]
            [backend-day.core :refer :all]))


(deftest test-solution-day-1-basic
  (testing "R2 L3 5 blocks away"
    (is (= 5 (solution ["R2","L3"] :N [0,0])))))

(deftest test-solution-day-1-basic-2
  (testing "R2 R2 R2 2 blocks south"
    (is (= 2 (solution ["R2","R2","R2"] :N [0,0])))))

(deftest test-solution-day-1-basic-3
  (testing "R5 L5 R5 R3 12 blocks away"
    (is (= 12 (solution ["R5","L5","R5","R3"] :N [0,0])))))

;;(deftest test-solution-day-1-part-2
;;  (testing "R8, R4, R4, R8 first location visit twice 4 blocks away"
;;    (is (= 4 (solution ["R8","R4","R4","R8"] :N [0,0] {})))))

;;(deftest test-solution-day-1-part-2
;;  (testing "R4 L4 L2 L2 L5 first visit 5 block away"
;;    (is (= 6 (solution ["R4", "L4","L2","L2","L5"] :N [0,0] {})))))
