
(ns app.util (:require ["dayjs" :as dayjs]))

(defn find-first [f xs] (reduce (fn [_ x] (when (f x) (reduced x))) nil xs))

(defn format-date [unix-time] (.format (dayjs unix-time) "YYYY-MM-DD"))

(defn try-verbosely! [x] (try x (catch js/Error e (.error js/console e))))
