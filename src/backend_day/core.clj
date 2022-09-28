(ns backend-day.core
  (:gen-class))
(require '[clojure.string :as str])

(defn read-input []
  "Reads the csv input for the exercise. Using slurp to read the whole file into a string
then removing any trailing new lines before spliting the string on , to create a sequence
then we trim any trailing whitespace from each element via map command"
  (map str/trim (str/split (str/trim-newline (slurp "input.csv")) #",")))


(defn solution [directions heading location]
  "Directions [ 'R4','L3','R2']
   heading initial heading :N for north
   location, starting location x y[0 0]"
  ())

(defn -main
  "Main method"
  [& args]

  (println (solution (read-input) :N [0 0])))
