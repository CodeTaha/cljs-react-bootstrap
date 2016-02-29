(ns cljs-react-bootstrap.react-bootstrap.split-button
  (:require [cljsjs.react-bootstrap]
            [reagent.core :as reagent]))

(def toggle (reagent/adapt-react-class (aget js/ReactBootstrap.SplitButton "Toggle")))