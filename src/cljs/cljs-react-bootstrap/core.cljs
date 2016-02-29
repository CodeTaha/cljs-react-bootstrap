(ns cljs-react-bootstrap.core
    (:require [reagent.core :as reagent]
              [reagent.session :as session]
              [re-frame.core :as re-frame]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [cljsjs.react-bootstrap]
              [cljs-react-bootstrap.handlers]
              [cljs-react-bootstrap.subs]
              [cljs-react-bootstrap.views :as views]
              [cljs-react-bootstrap.config :as config]
              [cljs-react-bootstrap.layout :as layout]))


(when config/debug?
  (println "dev mode"))


;; -------------------------
;; Session


(defn current-page []
  [(session/get :current-page) (session/get :params)])


;; (defn current-page []
;;   [:div [(session/get :current-page)]])


;; -------------------------
;; Routes


(secretary/defroute "/" []
  (session/put! :current-page #'views/home-page))


(secretary/defroute "/about" []
  (session/put! :current-page #'views/about-page))


(secretary/defroute "/bootstrap" []
  (session/put! :current-page #'views/bootstrap-page))


(secretary/defroute "/example" []
  (session/put! :current-page #'views/example-page))


(secretary/defroute "/test" []
  (session/put! :current-page #'views/test-page))


;; -------------------------
;; Bootstrap


(defn mount-root []
  (reagent/render
    [layout/main-layout [current-page]]
    (.getElementById js/document "app")))


(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (accountant/configure-navigation!)
  (accountant/dispatch-current!)
  (mount-root))
