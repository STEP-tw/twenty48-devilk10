(ns twenty48.core
  (:gen-class))

(def partition (comp (partial mapcat (partial partition-all 2 2)) (partial partition-by identity) (partial remove zero?)))

(def pad-zeros (comp (partial take 4) (partial flatten) (partial conj (repeat 4 0))))

(def move (comp (partial pad-zeros) (partial map (partial apply +)) (partial partition)))

(def move-up (comp (partial apply map list) (partial map move) (partial apply map list)))

(defn move-down
  "Moves grid downwards"
  [grid] (map reverse (move-up (map reverse (apply map list (map reverse (apply map list grid)))))))

(defn move-grid-right
  "Moves an entire grid to the right"
  [grid]
  (map reverse (map move (map reverse grid))))

(defn move-grid-left
  "Moves an entire grid to the left"
  [grid]
  (map move grid))

(defn move-grid-down
  "Moves an entire grid down"
  [grid]
 (reverse (move-down grid)))

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  (move-up grid))
