(ns cljs-react-bootstrap.react-bootstrap.dropdown
  (:require [cljsjs.react-bootstrap]
            [reagent.core :as reagent]))

(def menu (reagent/adapt-react-class (aget js/ReactBootstrap.Dropdown "Menu")))
(def toggle (reagent/adapt-react-class (aget js/ReactBootstrap.Dropdown "Toggle")))