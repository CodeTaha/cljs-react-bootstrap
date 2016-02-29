(ns cljs-react-bootstrap.components.example
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]))

;; -------------------------
;; Counter component examples


;;; an example of a full React counter component using
;;; normal life-cycle methods
(defn counter-class [count]
  (reagent/create-class
    {:display-name "counter-class"
     :component-will-mount #(do
                             (print "counter-class: will mount")
                             #_(re-frame/dispatch [:reset-counter]))
     :component-did-mount #(print "counter-class: did mount")
     :reagent-render
     (fn [count]
       [:div.counter
        [:div count]
        [:button.btn.btn-default
         {:type "button"
          :on-click #(re-frame/dispatch [:reset-counter])}
         "Reset"]
        [:button.btn.btn-default
         {:type "button"
          :on-click #(re-frame/dispatch [:increment-counter])}
         "Increment"]
        [:button.btn.btn-default
         {:type "button"
          :on-click #(re-frame/dispatch [:decrement-counter])}
         "Decrement"]])}))



;;; a presentation example of a counter component
(defn base-counter [count]
  [:div.counter
   [:div count]
   [:button.btn.btn-default
    {:type "button"
     :on-click #(re-frame/dispatch [:reset-counter])}
    "Reset"]
   [:button.btn.btn-default
    {:type "button"
     :on-click #(re-frame/dispatch [:increment-counter])}
    "Increment"]
   [:button.btn.btn-default
    {:type "button"
     :on-click #(re-frame/dispatch [:decrement-counter])}
    "Decrement"]])


;;; extending presentation example with life cycle methods
(def resetting-counter
  (with-meta base-counter
             {:component-will-mount #(do
                                      (print "counter-class: will mount")
                                      #_(re-frame/dispatch [:reset-counter]))
              :component-did-mount #(print "resetting-counter: did mount")}))


;; -------------------------
;; Timer component

;; (defn timer-component []
;;   (let [seconds-elapsed 0]
;;     (fn []
;;       (js/setTimeout #(swap! seconds-elapsed inc) 1000)
;;       [:div "Seconds Elapsed: " @seconds-elapsed])))