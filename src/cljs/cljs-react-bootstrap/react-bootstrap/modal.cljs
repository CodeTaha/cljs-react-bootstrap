(ns cljs-react-bootstrap.react-bootstrap.modal
  (:require [cljsjs.react-bootstrap]
            [reagent.core :as reagent]))

(def body (reagent/adapt-react-class (aget js/ReactBootstrap.Modal "Body")))
(def dialog (reagent/adapt-react-class (aget js/ReactBootstrap.Modal "Dialog")))
(def footer (reagent/adapt-react-class (aget js/ReactBootstrap.Modal"Footer")))
(def header (reagent/adapt-react-class (aget js/ReactBootstrap.Modal "Header")))
(def title (reagent/adapt-react-class (aget js/ReactBootstrap.Modal "Title")))