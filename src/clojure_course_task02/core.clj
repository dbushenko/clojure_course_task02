(ns clojure-course-task02.core
  (:gen-class))

(defn get-directories [path]
  (filter #(.isDirectory %) (file-seq (clojure.java.io/file path))))

(defn get-files [path]
  (filter #(.isFile %) (.listFiles path)))

(defn find-files [file-name path]
  (->> path
       get-directories
       (map get-files)
       flatten
       (map #(.getName %))
       (filter #(not (nil? (re-find (re-pattern file-name) %))))))

(defn usage []
  (println "Usage: $ run.sh file_name path"))
(defn -main [file-name path]
  (if (or (nil? file-name)
          (nil? path))
    (usage)
    (do
      (println "Searching for " file-name " in " path "...")
      (dorun (map println (find-files file-name path))))))
