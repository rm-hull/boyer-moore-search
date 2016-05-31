(ns boyer-moore.core)

; ported directly from the Java version at wikipedia:
; http://en.wikipedia.org/wiki/Boyer_moore#Implementations

(defn- char-code-at [s i]
  (int (get s i)))

(defn- char=
  ([s i j]
    (char= s s i j))

  ([s1 s2 i j]
    (= (get s1 i) (get s2 j))))

(defn- prefix?
  "Is needle[p:end] a prefix of needle?"
  [needle p]
  (let [len (count needle)]
    (loop [i p
           j 0]
      (cond
        (= i len)
        true

        (not (char= needle (inc i) (inc j)))
        false

        :else
        (recur (inc i) (inc j))))))

(defn- suffix-length
  "Returns the maximum length of the substring ends at p and is a suffix"
  [needle p]
  (loop [i p
         j (dec (count needle))
         len 0]
    (if (and (> i 0) (char= needle i j))
      (recur (dec i) (dec j) (inc len))
      len)))

(defn- make-char-table
  "Makes the jump table based on the mismatched character information"
  [needle]
  (let [len (count needle)]
    (loop [i 0
           table (transient (vec (repeat 256 len)))]
      (if-not (< i (dec len))
        (persistent! table)
        (recur
          (inc i)
          (assoc!
            table
            (char-code-at needle i)
            (- len 1 i)))))))

(defn- calc-prefixes [needle]
  (let [len (count needle)]
    (loop [i (dec len)
           last-posn len
           table (transient (vec (repeat len 0)))]
      (if-not (>= i 0)
        (persistent! table)
        (let [last-posn (if (prefix? needle i) i last-posn)]
          (recur
            (dec i)
            last-posn
            (assoc!
              table
              (- len 1 i)
              (+ last-posn (- i) len -1))))))))

(defn- make-offset-table
  "Makes the jump table based on the scan offset which mismatch occurs"
  [needle]
  (let [len (count needle)]
    (loop [i 0
           table (transient (calc-prefixes needle))]
      (if-not (<  i (dec len))
        (persistent! table)
        (let [slen (suffix-length needle i)]
          (recur
            (inc i)
            (assoc! table slen (+ len -1 (- i) slen))))))))

(defn index-of
  "Returns the index with the string of the first occurrence of the
  specified substring. If it is not a substring, return nil.

  haystack - the string to be scanned
  needle   - the target string to search"
  ([haystack needle]
    (index-of haystack needle 0))

  ([haystack needle offset]
    (let [len (count needle)
          m1 (dec len)]
      (if (zero? len)
        offset
        (let [char-table (make-char-table needle)
              offset-table (make-offset-table needle)
              calc-offset (fn [i j] (+ i
                                       (Math/max
                                         (char-code-at offset-table (- m1 j))
                                         (char-code-at char-table (char-code-at haystack i)))))]
          (loop [i (+ offset m1)
                 j m1]
            (cond
              (>= i (count haystack))
              nil

              (neg? j)
              (inc i)

              (char= haystack needle i j)
              (recur (dec i) (dec j))

              :else
              (recur (calc-offset i j) m1))))))))