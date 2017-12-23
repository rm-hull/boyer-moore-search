(ns boyer-moore.core-test
  (:require
   [clojure.test :refer :all]
   [boyer-moore.core :refer [index-of]]))

(deftest boyer-moore->string
  (is (= (index-of "Hello world" "") 0))
  (is (= (index-of "Hello world" "" 3) 3))
  (is (= (index-of "Hello world" "Hello") 0))
  (is (= (index-of "Hello world" "world") 6))
  (is (= (index-of "Hello world" "world" 4) 6))
  (is (= (index-of "Hello world" "o wo") 4))
  (is (= (index-of "Hello world" "not") nil))
  (is (= (index-of "svertices vertices" "vertices") 1))
  (is (= (index-of "FFS :svertices :vertices" ":vertices") 15)))

;(deftest boyer-moore->dataview
;  (let [data (str
;               "Rent a flat above a shop!\n"
;               "Cut your hair and get a job!\n"
;               "Smoke some fags and play some pool.")
;        dataview (create-dataview (count data))]
;
;    (set-binary-data! dataview 0 (seq data))
;
;    (is= (index-of dataview "") 0 "Empty string")
;    (is= (index-of dataview "Cut your") 26 "Match at start of 2nd line")
;    (is= (index-of dataview "Common People") nil "No match")
;    (is= (index-of dataview "above a shop" 26) nil "No match with offset")))