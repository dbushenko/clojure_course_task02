(ns clojure-course-task02.core-test
  (:use clojure.test
        clojure-course-task02.core))

(deftest find-files-test
  (testing "find-files count testing..."
    (is (<= 2 (count (find-files "^core.+" "./"))))))


(deftest find-files-test2
  (testing "find-files contents testing..."
    (let [res (apply hash-set (find-files "^core.+" "./"))]
      (is (contains? res "core.clj"))
      (is (contains? res "core_test.clj")))))
