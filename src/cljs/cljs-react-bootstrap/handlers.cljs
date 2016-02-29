(ns cljs-react-bootstrap.handlers
  (:require [re-frame.core :as re-frame]
            [cljs-react-bootstrap.db :as db]))


(re-frame/register-handler
  :initialize-db
  (fn [_ _]
    db/default-db))


(re-frame/register-handler
  :toggle-sidebar
  (fn [db]
    (update-in db [:show-sidebar] not)))


(re-frame/register-handler
  :toggle-login
  (fn [db]
    (update-in db [:show-login] not)))


(re-frame/register-handler
  :toggle-bootstrap-basic-modal
  (fn [db]
    (update-in db [:bootstrap-page :basic-modal-visible] not)))


(re-frame/register-handler
  :set-bootstrap-nav-basic
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :nav-basic-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-nav-dropdown
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :nav-dropdown-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-nav-stacked
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :nav-stacked-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-nav-justified
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :nav-justified-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-navbar-basic
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :navbar-basic-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-navbar-responsive
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :navbar-responsive-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-tabs-controlled
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :tabs-controlled-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-tabs-no-animation
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :tabs-no-animation-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-tabs-left-tabs
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :tabs-left-tabs-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-tabs-pills
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :tabs-pills-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-tabs-left-pills
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :tabs-left-pills-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-pagination-basic
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :pagination-basic-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-pagination-smart
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :pagination-smart-key] (fn [] val))))


(re-frame/register-handler
  :set-bootstrap-pager-wired
  (fn [db [_ val]]
    (update-in db [:bootstrap-page :pager-wired-key] (fn [] val))))


;(re-frame/register-handler
;  :reset-counter
;  (fn [db]
;    (update-in db [:counter-page :counter] (fn [_] 0))))
;
;(re-frame/register-handler
;  :increment-counter
;  (fn [db]
;    (update-in db [:counter-page :counter] inc)))
;
;(re-frame/register-handler
;  :decrement-counter
;  (fn [db]
;    (update-in db [:counter-page :counter] dec)))
