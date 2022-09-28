(ns backend-day.core-test
  (:require [clojure.test :refer :all]
            [backend-day.core :refer :all]))



(deftest translate-test
  (testing "translate vector [2 , 3] by 2 left 3 up [-2, 3]"
    (is (= [0, 6] (translate [2,3] [-2, 3])))))

(deftest genVector-test
  (testing "genvector test east movement vector")
  (is (= [3 0] (gen-vector :E 3))))

(deftest gen-visited-test
  (testing "Generate a map of the path taken e.g {[0 1] 1 [0 2] 1}"
    (is (= {[1 0] 1 [2 0] 1 [3 0] 1} (gen-visited [0 0] [3 0] :E {})))))

(deftest gen-visited-test-1
  (testing "Generate a map of the path taken going west"
    (is (= {[-1 0] 1 [-2 0] 1 [-3 0] 1} (gen-visited [0 0] [-3 0] :W {})))))

(deftest gen-visited-test-2
  (testing "Generate a map of the path taken that intersects with an existing path"
    (is (= {[1 0] 1 [2 0] 2 [3 0] 1 [2 1] 1 [2 2] 1 [2 3] 1} (gen-visited [2 -1] [2 3] :N {[1 0] 1 [2 0] 1 [3 0] 1})))))

(deftest turn-test
  (testing "turn should be R from R3"
    (is (= "R" (turn "R3")))))

(deftest test-solution-day-1-basic
  (testing "R2 L3 5 blocks away"
    (is (= 5 (solution ["R2","L3"] :N [0,0])))))

(deftest test-solution-day-1-basic-2
  (testing "R2 R2 R2 2 blocks south"
    (is (= 2 (solution ["R2","R2","R2"] :N [0,0])))))

(deftest test-solution-day-1-basic-3
  (testing "R5 L5 R5 R3 12 blocks away"
    (is (= 12 (solution ["R5","L5","R5","R3"] :N [0,0])))))

(deftest test-adevent-day-1-part-2
  (testing "R8, R4, R4, R8 first location visit twice 4 blocks away"
    (is (= 4 (solution-part-2 ["R8","R4","R4","R8"] :N [0,0] {})))))

(deftest test-advent-day-1-part-2
  (testing "R4 L4 L2 L2 L5 first visit 5 block away"
    (is (= 6 (solution-part-2 ["R4", "L4","L2","L2","L5"] :N [0,0] {})))))
