(ns cljs-react-bootstrap.react-bootstrap.navbar
  (:require [cljsjs.react-bootstrap]
            [reagent.core :as reagent]))

(def header (reagent/adapt-react-class (aget js/ReactBootstrap.Navbar "Header")))
(def toggle (reagent/adapt-react-class (aget js/ReactBootstrap.Navbar "Toggle")))
(def collapse (reagent/adapt-react-class (aget js/ReactBootstrap.Navbar "Collapse")))
(def brand (reagent/adapt-react-class (aget js/ReactBootstrap.Navbar "Brand")))
(def link (reagent/adapt-react-class (aget js/ReactBootstrap.Navbar "Link")))
(def text (reagent/adapt-react-class (aget js/ReactBootstrap.Navbar "Text")))