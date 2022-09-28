(ns backend-day.core
  (:gen-class))
(require '[clojure.string :as str])

(defn read-input []
  "Reads the csv input for the exercise. Using slurp to read the whole file into a string
then removing any trailing new lines before spliting the string on , to create a sequence
then we trim any trailing whitespace from each element via map command"
  (map str/trim (str/split (str/trim-newline (slurp "input.csv")) #",")))



(def vector-map {:N [0 1] :E [1 0] :S [0 -1] :W [-1 0]})
(defn next-heading [heading direction]
  "Get the next heading based on the turn direction, headings are based on a simple
compass North East South West which help define our movement direction. Heading should
be the current heading and direction from the current direction step"
  (cond
    (and (= heading :N) (= direction "R")) :E
    (and (= heading :N) (= direction "L")) :W
    (and (= heading :E) (= direction "R")) :S
    (and (= heading :E) (= direction "L")) :N
    (and (= heading :S) (= direction "R")) :W
    (and (= heading :S) (= direction "L")) :E
    (and (= heading :W) (= direction "R")) :N
    (and (= heading :W) (= direction "L")) :S))

(defn gen-vector [heading distance]
  "Generate a movement vector from our vector map which defines directions for
N E S W"
  (map (fn [x] (* x distance)) (heading vector-map)))



(defn distance [direction] (Integer/parseInt (last (.split direction "R|L"))))

(defn turn
  "Extract the turn from the direction step which is an L or R"
  [direction] (str (nth direction 0)))

(defn translate [location move]
  "Apply a movement vector to the location such that the x y of the location 
is moved up or down on a cartesian coordinate grid according to the move variable
 e.g [1 -1] moves it one down and one to the right "
  (let [[x y] location [mx my] move]
    (vector (+ x mx) (+ y my))))

(defn final-distance [sx sy location]
  "Compute the taxi cab distance between two points 0 0 [x y]"
  (let [[x y] location] (+ (abs (- sx x)) (abs (- sy y)))))

(defn gen-visited [location destination heading grid-map]
  "Generate a map of visited blocks in this transformations such that each block vistited
is represented in a map by its coord and a value for the times visited {[0 1] 1} we need to
walk through each block one by one and record a visit"
  (let [[sx sy] location distance-t (final-distance sx sy destination)]
    ;; recursive loop
    (loop [steps (range 0 distance-t) current-location location visited grid-map]
      (let [block-location (translate current-location (heading vector-map))]
        (cond (= (count steps) 0) visited
              :else (recur (rest steps) block-location (assoc visited block-location (inc (get visited block-location 0)))))))))

;; location is 0,0 track cordinate changes based on processing each direction
;; such that each direction is a vector translation then when we have the final
;; vector compute the distance between them 
(defn solution-part-2 [directions heading location grid-map]
  (cond
    (> (count (filter (fn [[k v]] (> v 1)) grid-map)) 0) (final-distance 0 0 (first (keys (filter (fn [[k v]] (> v 1)) grid-map))))
    (= (count directions) 0) (final-distance 0 0 location)

    :else (let [head (first directions)
                move-vec (gen-vector (next-heading heading (turn head)) (distance head))
                updated-map (gen-visited location (translate location move-vec) (next-heading heading (turn head)) grid-map)]
            (solution-part-2 (rest directions) (next-heading heading (turn head)) (translate location move-vec) updated-map))))

(defn solution [directions heading location]
  "Directions [ 'R4','L3','R2']
   heading initial heading :N for north
   location, starting location x y[0 0]"
  (cond (= (count directions) 0) (final-distance 0 0 location)
        :else (let [head (first directions)
                    move-vec (gen-vector (next-heading heading (turn head)) (distance head))]
                ;; tail call
                (solution (rest directions) (next-heading heading (turn head)) (translate location move-vec)))))


(defn -main
  "Main method"
  [& args]

  (println (solution (read-input) :N [0 0]))
  (println (solution-part-2 (read-input) :N [0 0] {})))
