(ns cljs-react-bootstrap.layout
  (:require [re-frame.core :as re-frame]
            [cljs-react-bootstrap.react-bootstrap.core :as rbs]
            [cljs-react-bootstrap.components.site :as site]))


(defn full-layout [view]
  [rbs/row
   [rbs/col {:xs 12} view]])


(defn sidebar-layout [view sidebar]
  [rbs/row
   [rbs/col {:xs 8} view]
   [rbs/col {:xs 3 :xs-offset 1} [sidebar]]])


(defn main-layout [view]
  (let [show-sidebar (re-frame/subscribe [:show-sidebar])
        show-login (re-frame/subscribe [:show-login])]
    (fn []
      [:div
       [site/header]
       (if (= @show-login true)
         [site/sign-in])
       [rbs/grid
        (if (= @show-sidebar false)
          [full-layout view]
          [sidebar-layout view site/sidebar])]
       [site/footer]])))