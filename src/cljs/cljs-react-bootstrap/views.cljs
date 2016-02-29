(ns cljs-react-bootstrap.views
  (:require [re-frame.core :as re-frame]
            [cljs-react-bootstrap.react-bootstrap.core :as rbs]
            [cljs-react-bootstrap.components.bootstrap-page :as bootstrap-page]))


(defn home-page []
  (let [state (re-frame/subscribe [:home-page])]
    [:div
     [rbs/jumbotron
      [:h1 "Hello, CLJS!"]
      [:p "A ClojureScript example single-page application."]]
     [:p "This is an example single-page application made with Clojure/ClojureScript using the reagent React wrapper and re-frame architecture, leveraging native React-Bootstrap components."]]))


(defn about-page []
  (let [state (re-frame/subscribe [:about-page])]
    [:div
     [rbs/page-header
      "About "
      [:small "this app"]]
     [rbs/page-item "Item One"]]))


(defn bootstrap-page
  "The bootstrap component example page"
  []
  (let [state (re-frame/subscribe [:bootstrap-page])]
    [:div
     [rbs/jumbotron
      [:h1 "React-Bootstrap"]
      [:p "A collection of React-Bootstrap component examples"]]
     [bootstrap-page/button-examples]
     [bootstrap-page/button-groups-examples]
     [bootstrap-page/dropdown-examples]
     [bootstrap-page/menu-items-examples]
     [bootstrap-page/modal-examples (@state :basic-modal-visible)]
     [bootstrap-page/tooltip-examples]
     [bootstrap-page/popover-examples]
     [bootstrap-page/nav-examples
      (@state :nav-basic-key)
      (@state :nav-dropdown-key)
      (@state :nav-stacked-key)
      (@state :nav-justified-key)]
     [bootstrap-page/navbar-examples
      (@state :navbar-basic-key)
      (@state :navbar-responsive-key)]
     [bootstrap-page/breadcrumb-examples]
     [bootstrap-page/tabs-examples
      (@state :tabs-controlled-key)
      (@state :tabs-no-animation-key)
      (@state :tabs-left-tabs-key)
      (@state :tabs-pills-key)
      (@state :tabs-left-pills-key)]
     [bootstrap-page/pagination-examples
      (@state :pagination-basic-key)
      (@state :pagination-smart-key)]
     [bootstrap-page/pager-examples
      (@state :pager-wired-key)]
     [bootstrap-page/grid-examples]
     [bootstrap-page/jumbotron-examples]
     [bootstrap-page/page-header-examples]
     [bootstrap-page/list-group-examples]
     [bootstrap-page/tables-examples]
     [bootstrap-page/panels-examples]
     [bootstrap-page/wells-examples]]))


(defn example-page []
  (let [state (re-frame/subscribe [:example-page])]
    ))


(defn test-page []
  (let [state (re-frame/subscribe [:test-page])]
    [:div#for-loop [:h1 "for-loop"]
     (for [x (range 1 10)]
       [:span x])]))