(ns clojure-course-task02.core
  (:gen-class))

(defn get-directories [path]
  (filter (memfn isDirectory) (file-seq (clojure.java.io/file path))))

(defn get-files [path]
  (filter #(.isFile %) (.listFiles path))) ;; memfn


(defn find-files [file-name path]
  (let [regex (re-pattern file-name)]
        (->> path
             get-directories
             (pmap get-files)
             flatten
             (pmap #(.getName %)) ;; memfn
             (filter #(not (nil? (re-find regex %)))))))  ;; comp + partial

(defn usage []
  (println "Usage: $ run.sh file_name path"))
(defn -main [file-name path]
  (if (or (nil? file-name)
          (nil? path))
    (usage)
    (do
      (println "Searching for " file-name " in " path "...")
      (dorun (map println (find-files file-name path)))
      (shutdown-agents))))
