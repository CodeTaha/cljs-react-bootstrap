(ns cljs-react-bootstrap.components.site
  (:require [cljs-react-bootstrap.react-bootstrap.core :as rbs]
            [cljs-react-bootstrap.react-bootstrap.navbar :as rbs-navbar]
            [cljs-react-bootstrap.react-bootstrap.modal :as rbs-modal]
            [re-frame.core :as re-frame]))


(defn navbar
  "Site navigation component"
  [brand links]
  [rbs/navbar {:static-top true
               :fluid true}
   [rbs-navbar/toggle]
   [rbs-navbar/brand [:a {:href "/"} brand]]
   [rbs-navbar/collapse
    [rbs/nav {:className "navbar-nav"}
     (for [link links]
       [rbs/nav-item {:href (link :url)} (link :name)])]
    [rbs/nav {:className "navbar-nav" :pull-right true}
     [rbs/nav-item {:href     "#"
                    :on-click #(re-frame/dispatch [:toggle-login])}
      [rbs/glyphicon {:glyph "user"}]]
     [rbs/nav-item {:href     "#"
                    :on-click #(re-frame/dispatch [:toggle-sidebar])}
      [rbs/glyphicon {:glyph "align-justify"}]]]]])


(defn header
  "Site header component"
  []
  (let [brand "CLJS"
        links [{:name "About" :url "/about"}
               {:name "Bootstrap" :url "/bootstrap"}
               {:name "Example" :url "/example"}
               {:name "Test" :url "/test"}]]
    [navbar brand links]))


;; TODO: possibly turn into page-specific sidebar instead
(defn sidebar
  "Site sidebar component"
  []
  [:div.sidebar
   [:div.sidebar-section
    [:h4 "Section"]
    [:ul
     [:li "One"]
     [:li "Two"]
     [:li "Three"]]]])


(defn sign-in
  "Site sign-in modal component"
  []
  [rbs-modal/dialog {:bs-size "small"}
   [rbs-modal/header
    [rbs/glyphicon {:glyph "user"}]
    [:span " Sign In"]]
   [rbs-modal/body
    [:form
     [rbs/input
      {:type "email"
       :label "Email Address"
       :placeholder "Enter email"}]
     [rbs/input
      {:type "password"
       :label "Password"}]]]
   [rbs-modal/footer
    [rbs/button {:type     "button"
                 :bs-style "default"
                 :on-click #(re-frame/dispatch [:toggle-login])} "Cancel"]
    [rbs/button {:type     "button"
                 :bs-style "primary"
                 :on-click #(re-frame/dispatch [:toggle-login])} "Sign In"]]])


(defn footer
  "Site footer component"
  []
  [:footer
   [:div.text-center "Copyright © 2016, Software Engineer."]])