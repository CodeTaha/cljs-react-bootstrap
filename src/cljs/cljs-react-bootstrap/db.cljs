(ns cljs-react-bootstrap.db)


(def default-db
  ;; https://github.com/Day8/re-frame
  ;; The Big Ratom
  {:show-sidebar false
   :show-login false

   ;; home page state
   :home-page {}

   ;; about page state
   :about-page {}

   ;; bootstrap page state
   :bootstrap-page
   {:show-basic-modal false
    :nav-basic-key 1
    :nav-dropdown-key 1
    :nav-stacked-key 1
    :nav-justified-key 1
    :navbar-basic-key 1
    :navbar-responsive-key 1
    :tabs-controlled-key 1
    :tabs-no-animation-key 1
    :tabs-left-tabs-key 1
    :tabs-pills-key 1
    :tabs-left-pills-key 1
    :pagination-basic-key 1
    :pagination-smart-key 1
    :pager-wired-key 1}

   ;; example page state
   :example-page {}

   ;; test page state
   :test-page
   {:timer {:seconds-elapsed 0}
    :input ""}})
