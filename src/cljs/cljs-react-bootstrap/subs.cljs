(ns cljs-react-bootstrap.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))


;; -------------------------
;; Layout-level state subscriptions

(re-frame/register-sub
  :show-sidebar
  (fn [db]
    (reaction (:show-sidebar @db))))


(re-frame/register-sub
  :show-login
  (fn [db]
    (reaction (:show-login @db))))


;; -------------------------
;; Page-level state subscriptions


(re-frame/register-sub
  :home-page
  (fn [db]
    (reaction (:home-page @db))))


(re-frame/register-sub
  :about-page
  (fn [db]
    (reaction (:about-page @db))))


(re-frame/register-sub
  :bootstrap-page
  (fn [db]
    (reaction (:bootstrap-page @db))))


(re-frame/register-sub
  :example-page
  (fn [db]
    (reaction (:example-page @db))))


(re-frame/register-sub
  :test-page
  (fn [db]
    (reaction (:test-page @db))))
