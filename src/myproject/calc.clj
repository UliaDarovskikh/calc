(ns myproject.calc
  (:require
    [clojure.edn :as edn])
  (:gen-class))

(def banner
  "
========================================================
                             __
 .--------.--.--.----.---.-.|  |.----.
 |        |  |  |  __|  _  ||  ||  __|
 |__|__|__|___  |____|___._||__||____|
          |_____|
")
(def operator {"+" +
               "-" -
               "*" *
               "/" (fn [x y]
                     (if (= y 0) "Бесконечность" /))
               "q" "q"})
;;функции
(defn exit [] (System/exit 0))

;(defn read-op [t]
;  (println [t])
;  (read-line)
;  ;нужна проверка принадлежит ли мапе contains?
;  )
;
;(defn read-xy [t]
;  (println [t])
;  ;добавить проверку значения number?
;  (let [xy (edn/read-string (read-line))]
;    xy))

(defn read-op [t]
  (loop [op (do (println [t]) (read-line))]
    (if (contains? operator op) op (recur (do (println [t]) (read-line))))
    ))

(defn read-xy
  "считать число"
  [message]
  (let [read-fn (fn [message] (println [message]) (edn/read-string (read-line)))]
    (loop [xy (read-fn message)]
      (if (number? xy)
        xy
        (recur (read-fn message))))))

(defn calc [op x y]
  (let [operator (operator op)]
    (println x op y "=" (operator x y))))

(defn -main
  [& args]
  (println banner)

  (loop [x 1
         y 1
         op "+"
         ]
    (if (= op "q") (exit) (calc op x y))
    (recur (read-xy "Первое число")
           (read-xy "Второе число")
           (read-op "Выберите операцию из списка: +, -, *, /. Для выхода нажмите q")
           )
    )
  (exit))




