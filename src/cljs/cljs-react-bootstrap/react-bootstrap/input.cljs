(ns cljs-react-bootstrap.react-bootstrap.input
  (:require [cljsjs.react-bootstrap]
            [reagent.core :as reagent]))

(def get-checked (reagent/adapt-react-class (aget js/ReactBootstrap.Input "getChecked")))
(def get-input-dom-node (reagent/adapt-react-class (aget js/ReactBootstrap.Input "getInputDOMNode")))
(def get-value (reagent/adapt-react-class (aget js/ReactBootstrap.Input "getValue")))