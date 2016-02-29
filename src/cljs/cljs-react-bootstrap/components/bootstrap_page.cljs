(ns cljs-react-bootstrap.components.bootstrap-page
  (:require [cljs-react-bootstrap.react-bootstrap.core :as rbs]
            [cljs-react-bootstrap.react-bootstrap.dropdown :as rbs-dropdown]
            [cljs-react-bootstrap.react-bootstrap.modal :as rbs-modal]
            [cljs-react-bootstrap.react-bootstrap.navbar :as rbs-navbar]
            [re-frame.core :as re-frame]))

(defn button-examples
  "Bootstrap button component examples"
  []
  [:div
   [rbs/page-header
    "Buttons "
    [:small
     [:code "button"]]]
   [:h3 "Options"]
   [rbs/button-toolbar
    [rbs/button "Default"]
    [rbs/button {:bs-style "primary"} "Primary"]
    [rbs/button {:bs-style "success"} "Success"]
    [rbs/button {:bs-style "info"} "Info"]
    [rbs/button {:bs-style "warning"} "Warning"]
    [rbs/button {:bs-style "danger"} "Danger"]
    [rbs/button {:bs-style "link"} "Link"]]
   [:h3 "Sizes"]
   [rbs/button-toolbar
    [rbs/button {:bs-style "primary"
                 :bs-size  "large"} "Large button"]
    [rbs/button {:bs-size "large"} "Large button"]]
   [rbs/button-toolbar
    [rbs/button {:bs-style "primary"} "Default button"]
    [rbs/button "Default button"]]
   [rbs/button-toolbar
    [rbs/button {:bs-style "primary"
                 :bs-size  "small"} "Small button"]
    [rbs/button {:bs-size "small"} "Small button"]]
   [rbs/button-toolbar
    [rbs/button {:bs-style "primary"
                 :bs-size  "xsmall"} "Extra small button"]
    [rbs/button {:bs-size "xsmall"} "Extra small button"]]
   [:h3 "Block-level"]
   [rbs/well
    [rbs/button {:bs-style "primary"
                 :bs-size  "large"
                 :block    true} "Block level button"]
    [rbs/button {:bs-size "large"
                 :block   true} "Block level button"]]
   [:h3 "Active state"]
   [rbs/button-toolbar
    [rbs/button {:bs-style "primary"
                 :bs-size  "large"
                 :active   true} "Primary button"]
    [rbs/button {:bs-size "large"
                 :active  true} "button"]]
   [:h3 "Disabled state"]
   [rbs/button-toolbar
    [rbs/button {:bs-style "primary"
                 :bs-size  "large"
                 :disabled true} "Primary button"]
    [rbs/button {:bs-size  "large"
                 :disabled true} "button"]]
   [:h3 "Button tags"]
   [rbs/button-toolbar
    [rbs/button {:href "#"} "Link"]
    [rbs/button "Button"]]])


(defn button-groups-examples
  "Boostrap button group component examples"
  []
  [:div
   [rbs/page-header "Button Groups " [:small [:code "button-group"] " " [:code "button-toolbar"]]]
   [:h3 "Basic example"]
   [rbs/button-group
    [rbs/button "Left"]
    [rbs/button "Middle"]
    [rbs/button "Right"]]
   [:h3 "Basic toolbar"]
   [rbs/button-toolbar
    [rbs/button-group [rbs/button "1"] [rbs/button "2"] [rbs/button "3"] [rbs/button "4"]]
    [rbs/button-group [rbs/button "5"] [rbs/button "6"] [rbs/button "7"]]
    [rbs/button-group [rbs/button "8"]]]
   [:h3 "Sizing"]
   [rbs/button-toolbar
    [rbs/button-group {:bs-size "large"}
     [rbs/button "Left"] [rbs/button "Middle"] [rbs/button "Right"]]]
   [rbs/button-toolbar
    [rbs/button-group
     [rbs/button "Left"] [rbs/button "Middle"] [rbs/button "Right"]]]
   [rbs/button-toolbar
    [rbs/button-group {:bs-size "small"}
     [rbs/button "Left"] [rbs/button "Middle"] [rbs/button "Right"]]]
   [rbs/button-toolbar
    [rbs/button-group {:bs-size "xsmall"}
     [rbs/button "Left"] [rbs/button "Middle"] [rbs/button "Right"]]]
   [:h3 "Nesting"]
   [rbs/button-group
    [rbs/button "1"]
    [rbs/button "2"]
    [rbs/dropdown-button {:title "Dropdown"}
     [rbs/menu-item {:event-key "1"} "Dropdown link 1"]
     [rbs/menu-item {:event-key "2"} "Dropdown link 2"]]]
   [:h3 "Vertical variation"]
   [rbs/button-group {:vertical true}
    [rbs/button "Button"]
    [rbs/button "Button"]
    [rbs/dropdown-button {:title "Dropdown"}
     [rbs/menu-item {:event-key "1"} "Dropdown link 1"]
     [rbs/menu-item {:event-key "2"} "Dropdown link 2"]]
    [rbs/button "Button"]
    [rbs/button "Button"]
    [rbs/dropdown-button {:title "Dropdown"}
     [rbs/menu-item {:event-key "1"} "Dropdown link 1"]
     [rbs/menu-item {:event-key "2"} "Dropdown link 2"]]
    [rbs/dropdown-button {:title "Dropdown"}
     [rbs/menu-item {:event-key "1"} "Dropdown link 1"]
     [rbs/menu-item {:event-key "2"} "Dropdown link 2"]]]
   [rbs/button-group {:vertical true
                      :block    true}
    [rbs/button "Full width button"]
    [rbs/button "Full width button"]]
   [:h3 "Justified"]
   [rbs/button-group
    [rbs/button {:href "#"} "Left"]
    [rbs/button {:href "#"} "Middle"]
    [rbs/dropdown-button {:title "Dropdown"}
     [rbs/menu-item {:event-key "1"} "Dropdown link 1"]
     [rbs/menu-item {:event-key "2"} "Dropdown link 2"]]]])


(defn dropdown-examples
  "Bootstrap dropdown component examples"
  []
  [:div
   [rbs/page-header "Dropdowns " [:small [:code "dropdown"]]]
   [:h3 "Single button dropdowns"]
   (for [val (map-indexed vector ["Default" "Primary" "Success" "Info" "Warning" "Danger" "Link"])]
     (let [index (first val)
           title (last val)
           style (clojure.string/lower-case (last val))]
       [rbs/dropdown-button {:bs-style style
                             :title    title
                             :key      index
                             :id       (clojure.string/join ["dropdown-basic-$" (str index)])}
        [rbs/menu-item {:event-key 1} "Action 1"]
        [rbs/menu-item {:event-key 2
                        :active    true} "Action 2 (active)"]
        [rbs/menu-item {:dvider true}]
        [rbs/menu-item {:event-key 3} "Seperated Action 3"]]))
   [:h3 "Split button dropdowns"]
   [rbs/button-toolbar
    (for [val (map-indexed vector ["Default" "Primary" "Success" "Info" "Warning" "Danger" "Link"])]
      (let [index (first val)
            title (last val)
            style (clojure.string/lower-case (last val))]
        [rbs/split-button {:bs-style style
                           :title    title
                           :key      index
                           :id       (clojure.string/join ["split-button-basic-$" (str index)])}
         [rbs/menu-item {:event-key 1} "Action 1"]
         [rbs/menu-item {:event-key 2
                         :active    true} "Action 2 (active)"]
         [rbs/menu-item {:dvider true}]
         [rbs/menu-item {:event-key 3} "Seperated Action 3"]]))]
   [:h3 "Sizing"]
   [rbs/button-toolbar
    [rbs/dropdown-button {:bs-size "large"
                          :title   "Large button"}
     [rbs/menu-item {:event-key 1} "Action 1"]
     [rbs/menu-item {:event-key 2
                     :active    true} "Action 2 (active)"]
     [rbs/menu-item {:dvider true}]
     [rbs/menu-item {:event-key 3} "Seperated Action 3"]]]
   [rbs/button-toolbar
    [rbs/dropdown-button {:title "Default button"}
     [rbs/menu-item {:event-key 1} "Action 1"]
     [rbs/menu-item {:event-key 2
                     :active    true} "Action 2 (active)"]
     [rbs/menu-item {:dvider true}]
     [rbs/menu-item {:event-key 3} "Seperated Action 3"]]]
   [rbs/button-toolbar
    [rbs/dropdown-button {:bs-size "small"
                          :title   "Small button"}
     [rbs/menu-item {:event-key 1} "Action 1"]
     [rbs/menu-item {:event-key 2
                     :active    true} "Action 2 (active)"]
     [rbs/menu-item {:dvider true}]
     [rbs/menu-item {:event-key 3} "Seperated Action 3"]]]
   [rbs/button-toolbar
    [rbs/dropdown-button {:bs-size "xsmall"
                          :title   "Extra small button"}
     [rbs/menu-item {:event-key 1} "Action 1"]
     [rbs/menu-item {:event-key 2
                     :active    true} "Action 2 (active)"]
     [rbs/menu-item {:dvider true}]
     [rbs/menu-item {:event-key 3} "Seperated Action 3"]]]
   [:h3 "No caret variation"]
   [rbs/button-toolbar
    [rbs/dropdown-button {:title    "No caret"
                          :no-caret true}
     [rbs/menu-item {:event-key 1} "Action 1"]
     [rbs/menu-item {:event-key 2
                     :active    true} "Action 2 (active)"]
     [rbs/menu-item {:dvider true}]
     [rbs/menu-item {:event-key 3} "Seperated Action 3"]]]
   [:h3 "Dropup variation"]
   [rbs/button-toolbar
    [rbs/split-button {:title  "Dropup"
                       :dropup true}
     [rbs/menu-item {:event-key 1} "Action 1"]
     [rbs/menu-item {:event-key 2
                     :active    true} "Action 2 (active)"]
     [rbs/menu-item {:dvider true}]
     [rbs/menu-item {:event-key 3} "Seperated Action 3"]]]
   [rbs/button-toolbar
    [rbs/split-button {:bs-style   "primary"
                       :title      "Right dropup"
                       :dropup     true
                       :pull-right true}
     [rbs/menu-item {:event-key 1} "Action 1"]
     [rbs/menu-item {:event-key 2
                     :active    true} "Action 2 (active)"]
     [rbs/menu-item {:dvider true}]
     [rbs/menu-item {:event-key 3} "Seperated Action 3"]]]
   [:h3 "Dropdown right variation"]
   [rbs/button-toolbar
    [rbs/split-button {:title      "Dropdown right"
                       :pull-right true}
     [rbs/menu-item {:event-key 1} "Action 1"]
     [rbs/menu-item {:event-key 2
                     :active    true} "Action 2 (active)"]
     [rbs/menu-item {:dvider true}]
     [rbs/menu-item {:event-key 3} "Seperated Action 3"]]]
   [:h3 "Dropdown customization"]
   [rbs/button-toolbar
    [rbs/dropdown
     [rbs-dropdown/toggle
      [rbs/glyphicon {:glyph "star"}]
      "Pow! Zoom!"]
     [rbs-dropdown/menu
      [rbs/menu-item {:event-key 1} "Action 1"]
      [rbs/menu-item {:event-key 2
                      :active    true} "Action 2 (active)"]
      [rbs/menu-item {:dvider true}]
      [rbs/menu-item {:event-key 3} "Seperated Action 3"]]]]
   [rbs/button-toolbar
    [rbs/dropdown
     [rbs/button {:bs-style "info"} "mix it up style-wise"]
     [rbs-dropdown/toggle {:bs-style "success"}]
     [rbs-dropdown/menu
      [rbs/menu-item {:event-key 1} "Action 1"]
      [rbs/menu-item {:event-key 2
                      :active    true} "Action 2 (active)"]
      [rbs/menu-item {:dvider true}]
      [rbs/menu-item {:event-key 3} "Seperated Action 3"]]]]])


(defn menu-items-examples
  "Bootstrap menu items component examples"
  []
  [:div
   [rbs/page-header "Menu items " [:small [:code "menu-item"]]]
   [:div {:class "static-menu"}
    [:ul {:class "dropdown-menu opened"}
     [rbs/menu-item {:header true} "Header"]
     [rbs/menu-item "Link"]
     [rbs/menu-item {:divider true}]
     [rbs/menu-item {:header true} "Header"]
     [rbs/menu-item "Link"]
     [rbs/menu-item {:disabled true} "Disabled"]
     [rbs/menu-item {:title "See? I have a title."} "link with title"]]
    [:div {:class "clearfix"}]]])


(defn modal-examples
  "Bootstrap modal component examples"
  [basic-modal-visible]
  [:div
   [rbs/page-header "Modals " [:small [:code "modal"]]]
   [:h3 "Static Markup"]
   [:div {:class "static-modal"}
    [rbs-modal/dialog
     [rbs-modal/header
      [rbs-modal/title "Modal title"]]
     [rbs-modal/body
      [:p "One fine body..."]]
     [rbs-modal/footer
      [rbs/button "Close"]
      [rbs/button {:bs-style "primary"} "Save changes"]]]]
   [:h3 "Basic example"]
   [rbs/button {:bs-style "primary"
                :on-click #(re-frame/dispatch [:toggle-bootstrap-basic-modal])} "Launch demo modal"]
   (if (= basic-modal-visible true)
     [rbs-modal/dialog
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
                    :on-click #(re-frame/dispatch [:toggle-bootstrap-basic-modal])} "Cancel"]
       [rbs/button {:type     "button"
                    :bs-style "primary"
                    :on-click #(re-frame/dispatch [:toggle-bootstrap-basic-modal])} "Sign In"]]])])


(defn tooltip-examples
  "Bootstrap tooltip component examples"
  []
  [:div
   [rbs/page-header "Tooltip " [:small [:code "tooltip"]]]
   [:div {:class "tooltip-static"}
    [rbs/tooltip {:placement "right"
                  :class "in"} "Tooltip right"]
    [rbs/tooltip {:placement "top"
                  :class "in"} "Tooltip top"]
    [rbs/tooltip {:placement "left"
                  :class "in"} "Tooltip left"]
    [rbs/tooltip {:placement "bottom"
                  :class "in"} "Tooltip bottom"]]
   #_[:h3 "With overlay trigger"]
   #_[rbs/button-toolbar
    [rbs/overlay-trigger {:placement "left"
                          :overlay (tooltip-test)}
     [rbs/button "Holy guacamole!"]]]])


(defn popover-examples
  "Bootstrap popover component examples"
  []
  [:div
   [rbs/page-header "Popovers " [:small [:code "popover"]]]
   [:h3 "Static example"]
   [:div {:class "static-popover"}
    [rbs/popover {:placement "right"
                  :position-left 200
                  :position-top 50
                  :title "Popover right"}
     "And here's some "
     [:strong "amazing"]
     " content.  It's very engaging.  Right?"]]
   #_[:h3 "With Overlay Trigger"]])


(defn nav-examples
  "Bootstrap navbar component examples"
  [nav-basic-key nav-dropdown-key nav-stacked-key nav-justified-key]
  [:div
   [rbs/page-header "Nav " [:small [:code "nav"]]]
   [:h3 "Navs"]
   [rbs/nav {:bs-style "pills"
             :active-key nav-basic-key
             :on-select #(re-frame/dispatch [:set-bootstrap-nav-basic %])}
    [rbs/nav-item {:event-key 1
                   :href "#"} "NavItem 1 content"]
    [rbs/nav-item {:event-key 2
                   :title "Item"} "NavItem 2 content"]
    [rbs/nav-item {:event-key 3
                   :disabled true} "NavItem 3 content"]]
   [:h4 "Dropdown"]
   [rbs/nav {:bs-style "tabs"
             :active-key nav-dropdown-key
             :on-select #(re-frame/dispatch [:set-bootstrap-nav-dropdown %])}
    [rbs/nav-item {:event-key 1
                   :href "#"} "NavItem 1 content"]
    [rbs/nav-item {:event-key 2
                   :title "Item"} "NavItem 2 content"]
    [rbs/nav-item {:event-key 3
                   :disabled true} "NavItem 3 content"]
    [rbs/nav-dropdown {:event-key 4
                       :title "Dropdown"}
     [rbs/menu-item {:event-key 4.1} "Action 1"]
     [rbs/menu-item {:event-key 4.2} "Action 2"]
     [rbs/menu-item {:dvider true}]
     [rbs/menu-item {:event-key 4.3} "Seperated Action 3"]]]
   [:h4 "Stacked"]
   [rbs/nav {:bs-style "pills"
             :stacked true
             :active-key nav-stacked-key
             :on-select #(re-frame/dispatch [:set-bootstrap-nav-stacked %])}
    [rbs/nav-item {:event-key 1
                   :href "#"} "NavItem 1 content"]
    [rbs/nav-item {:event-key 2
                   :title "Item"} "NavItem 2 content"]
    [rbs/nav-item {:event-key 3
                   :disabled true} "NavItem 3 content"]]
   [:h4 "Justified"]
   [rbs/nav {:bs-style "tabs"
             :justified true
             :active-key nav-justified-key
             :on-select #(re-frame/dispatch [:set-bootstrap-nav-justified %])}
    [rbs/nav-item {:event-key 1
                   :href "#"} "NavItem 1 content"]
    [rbs/nav-item {:event-key 2
                   :title "Item"} "NavItem 2 content"]
    [rbs/nav-item {:event-key 3
                   :disabled true} "NavItem 3 content"]]
   [rbs/nav {:bs-style "pills"
             :justified true
             :active-key nav-justified-key
             :on-select #(re-frame/dispatch [:set-bootstrap-nav-justified %])}
    [rbs/nav-item {:event-key 4
                   :href "#"} "NavItem 1 content"]
    [rbs/nav-item {:event-key 5
                   :title "Item"} "NavItem 2 content"]
    [rbs/nav-item {:event-key 6
                   :disabled true} "NavItem 3 content"]]])

(defn navbar-examples
  "Bootstrap navbar component examples"
  [navbar-basic-key navbar-responsive-key]
  [:div
   [rbs/page-header "Navbar " [:small [:code "navbar"]]]
   [:h3 "Basic example"]
   [rbs/navbar
    [rbs-navbar/header
     [rbs-navbar/brand
      [:a {:href "#"} "CLJS React Bootstrap"]]]
    [rbs/nav {:className "navbar-nav"
              :active-key navbar-basic-key
              :on-select #(re-frame/dispatch [:set-bootstrap-navbar-basic %])}
     [rbs/nav-item {:event-key 1
                    :href "#"} "Link 1"]
     [rbs/nav-item {:event-key 2
                    :href "#"} "Link 2"]
     [rbs/nav-dropdown {:event-key 3
                        :title "Dropdown"
                        :id "basic-nav-dropdown"}
      [rbs/menu-item {:event-key 3.1} "Action 1"]
      [rbs/menu-item {:event-key 3.2} "Action 2"]
      [rbs/menu-item {:dvider true}]
      [rbs/menu-item {:event-key 3.3} "Seperated Action 3"]]]]
   [:h3 "Responsive navbar"]
   [rbs/navbar {:inverse true}
    [rbs-navbar/header
     [rbs-navbar/toggle]
     [rbs-navbar/brand
      [:a {:href "#"} "CLJS React Bootstrap"]]]
    [rbs-navbar/collapse
     [rbs/nav {:className "navbar-nav"
               :active-key navbar-responsive-key
               :on-select #(re-frame/dispatch [:set-bootstrap-navbar-responsive %])}
      [rbs/nav-item {:event-key 1
                     :href "#"} "Link 1"]
      [rbs/nav-item {:event-key 2
                     :href "#"} "Link 2"]
      [rbs/nav-dropdown {:event-key 3
                         :title "Dropdown"
                         :id "basic-nav-dropdown"}
       [rbs/menu-item {:event-key 3.1} "Action 1"]
       [rbs/menu-item {:event-key 3.2} "Action 2"]
       [rbs/menu-item {:dvider true}]
       [rbs/menu-item {:event-key 3.3} "Seperated Action 3"]]]
     [rbs/nav {:className "navbar-nav"
               :active-key navbar-responsive-key
               :on-select #(re-frame/dispatch [:set-bootstrap-navbar-responsive %])
               :pull-right true}
      [rbs/nav-item {:event-key 4
                     :href "#"} "Link Right 4"]
      [rbs/nav-item {:event-key 5
                     :href "#"} "Link Right 5"]]]]
   #_[:h3 "Text and non-nav links"]
   #_[rbs/navbar {:inverse true}
    [rbs-navbar/header
     [rbs-navbar/brand
      [:a {:href "#"} "CLJS React Bootstrap"]]]
    [rbs-navbar/collapse
     [rbs-navbar/text
      [:span "Sign in as: "]
      [rbs-navbar/link {:href "#"} "Mark Otto"]]
     [rbs-navbar/text {:pull-right true} "Have a great day!"]]]])


(defn breadcrumb-examples
  "Bootstrap breadcrumb examples"
  []
  [:div
   [rbs/page-header "Breadcrumbs " [:small [:code "breadcrumb"]]]
   [:h3 "Breadcrumbs example"]
   [rbs/breadcrumb
    [rbs/breadcrumb-item {:href "#"} "Home"]
    [rbs/breadcrumb-item {:href "#"} "Library"]
    [rbs/breadcrumb-item {:active true} "Data"]]])


(defn tabs-examples
  "Bootstrap tab component examples"
  [controlled-key no-animation-key left-tabs-key pills-key left-pills-key]
  [:div
   [rbs/page-header "Togglable tabs " [:small [:code "tabs"] [:code "tab"]]]
   [:h3 "Controlled"]
   [rbs/tabs {:active-key controlled-key
              :on-select #(re-frame/dispatch [:set-bootstrap-tabs-controlled %])}
    [rbs/tab {:event-key 1
              :title "Tab 1"
              :disabled false} [rbs/well "Tab 1 content"]]
    [rbs/tab {:event-key 2
              :title "Tab 2"
              :disabled true} [rbs/well "Tab 2 content"]]
    [rbs/tab {:event-key 3
              :title "Tab 3"
              :disabled false} [rbs/well "Tab 3 content"]]]
   [:h3 "No animation"]
   [rbs/tabs {:active-key no-animation-key
              :on-select #(re-frame/dispatch [:set-bootstrap-tabs-no-animation %])
              :animation false}
    [rbs/tab {:event-key 1
              :title "Tab 1"
              :disabled false} [rbs/well "Tab 1 content"]]
    [rbs/tab {:event-key 2
              :title "Tab 2"
              :disabled false} [rbs/well "Tab 2 content"]]
    [rbs/tab {:event-key 3
              :title "Tab 3"
              :disabled true} [rbs/well "Tab 3 content"]]]
   [:h3 "Left tabs"]
   [rbs/tabs {:active-key left-tabs-key
              :on-select #(re-frame/dispatch [:set-bootstrap-tabs-left-tabs %])
              :position "left"
              :bs-style "tabs"}
    [rbs/tab {:event-key 1
              :title "Tab 1"
              :disabled false} [rbs/well "Tab 1 content"]]
    [rbs/tab {:event-key 2
              :title "Tab 2"
              :disabled false} [rbs/well "Tab 2 content"]]
    [rbs/tab {:event-key 3
              :title "Tab 3"
              :disabled true} [rbs/well "Tab 3 content"]]]
   [:h3 "Pills"]
   [rbs/tabs {:active-key pills-key
              :on-select #(re-frame/dispatch [:set-bootstrap-tabs-pills %])
              :bs-style "pills"}
    [rbs/tab {:event-key 1
              :title "Tab 1"
              :disabled false} [rbs/well "Tab 1 content"]]
    [rbs/tab {:event-key 2
              :title "Tab 2"
              :disabled false} [rbs/well "Tab 2 content"]]
    [rbs/tab {:event-key 3
              :title "Tab 3"
              :disabled true} [rbs/well "Tab 3 content"]]]
   [:h3 "Left Pills"]
   [rbs/tabs {:active-key left-pills-key
              :on-select #(re-frame/dispatch [:set-bootstrap-tabs-left-pills %])
              :position "left"
              :bs-style "pills"}
    [rbs/tab {:event-key 1
              :title "Tab 1"
              :disabled false} [rbs/well "Tab 1 content"]]
    [rbs/tab {:event-key 2
              :title "Tab 2"
              :disabled false} [rbs/well "Tab 2 content"]]
    [rbs/tab {:event-key 3
              :title "Tab 3"
              :disabled true} [rbs/well "Tab 3 content"]]]])


(defn pagination-examples
  "Bootstrap pagination component examples"
  [basic-key smart-key]
  [:div
   [rbs/page-header "Pagination " [:small [:code "pagination"]]]
   [:h3 "Basic example"]
   (for [val (map-indexed vector ["large" "medium" "small"])]
     (let [size (last val)]
       [:div
        [rbs/pagination {:bs-size size
                         :items 10
                         :active-page basic-key
                         :on-select #(re-frame/dispatch [:set-bootstrap-pagination-basic (aget %2 "eventKey")])}]]))
   [:h3 "Smart example"]
   (for [val (map-indexed vector ["large" "medium" "small"])]
     (let [size (last val)]
       [:div
        [rbs/pagination {:bs-size size
                         :prev true
                         :next true
                         :first true
                         :last true
                         :ellipsis true
                         :boundary-links true
                         :items 20
                         :max-buttons 5
                         :active-page smart-key
                         :on-select #(re-frame/dispatch [:set-bootstrap-pagination-smart (aget %2 "eventKey")])}]]))])


(defn pager-examples
  "Bootstrap pager component examples"
  [wired-key]
  [:div
   [rbs/page-header "Pager " [:small [:code "pager"]]]
   [:h3 "Centers by default"]
   [rbs/pager
    [rbs/page-item {:href "#"} "Previous"]
    [rbs/page-item {:href "#"} "Next"]]
   [:h3 "Previous and next"]
   [rbs/pager
    [rbs/page-item {:href "#"
                    :previous true} "Previous"]
    [rbs/page-item {:href "#"
                    :next true} "Next"]]
   [:h3 "Disabled"]
   [rbs/pager
    [rbs/page-item {:href "#"
                    :previous true
                    :disabled true} "Previous"]
    [rbs/page-item {:href "#"
                    :next true
                    :disabled true} "Next"]]
   [:h3 "Wired"]
   (if (= wired-key 1)
     [rbs/well [:p "First page content"]]
     [rbs/well [:p "Second page content"]])
   [rbs/pager {:on-select #(re-frame/dispatch [:set-bootstrap-pager-wired %])}
    [rbs/page-item {:href "#"
                    :event-key 1
                    :previous true
                    :disabled (= wired-key 1)} "Previous"]
    [rbs/page-item {:href "#"
                    :event-key 2
                    :next true
                    :disabled (= wired-key 2)} "Next"]]])


(defn grid-examples
  "Bootstrap grid component examples"
  []
  [:div
   [rbs/page-header "Grid " [:small [:code "grid"] [:code "row"] [:code "col"]]]
   [:h3 "Grid example"]
   [rbs/grid
    [rbs/row {:class "show-grid"}
     [rbs/col {:xs 12 :md 8} "{:xs 12 :md 8}"]
     [rbs/col {:xs 6 :md 4} "{:xs 6 :md 4}"]]
    [rbs/row {:class "show-grid"}
     [rbs/col {:xs 6 :md 4} "{:xs 6 :md 4}"]
     [rbs/col {:xs 6 :md 4} "{:xs 6 :md 4}"]
     [rbs/col {:xs-hidden true :md 4} "{:xs-hidden true :md 4}"]]
    [rbs/row {:class "show-grid"}
     [rbs/col {:xs 6 :xs-offset 6} "{:xs 6 :xs-offset 6}"]]
    [rbs/row {:class "show-grid"}
     [rbs/col {:md 6 :md-push 6} "{:md 6 :md-push 6}"]
     [rbs/col {:md 6 :md-pull 6} "{:md 6 :md-pull 6}"]]]])


(defn jumbotron-examples
  "Bootstrap jumbotron component examples"
  []
  [:div
   [rbs/page-header "Jumbotron " [:small [:code "jumbotron"]]]
   [rbs/jumbotron
    [:h1 "Hello, CLJS!"]
    [:p "This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information."]
    [rbs/button {:bs-style "primary"} "Learn more"]]])


(defn page-header-examples
  "Bootstrap page header component examples"
  []
  [:div
   [rbs/page-header "Page header " [:small [:code "page-header"]]]
   [:div {:class "page-header-contained"}
    [rbs/page-header "Example page header " [:small "Subtext for header"]]]])


(defn list-group-examples
  "Bootstrap list group component examples"
  []
  [:div
   [rbs/page-header "List group " [:small [:code "list-group"]]]
   [:h3 "Centers by default"]
   [rbs/list-group
    [rbs/list-group-item {:href "#"} "Link 1"]
    [rbs/list-group-item {:href "#"} "Link 2"]]
   [:h3 "Linked"]
   [rbs/list-group
    [rbs/list-group-item {:href "/home"} "Home link"]
    [rbs/list-group-item {:on-click #(js/alert "Hello from CLJS!")} "Alert link"]]
   [:h3 "Styling by state"]
   [rbs/list-group
    [rbs/list-group-item {:href "#"
                          :active true} "Link 1"]
    [rbs/list-group-item {:href "#"} "Link 2"]
    [rbs/list-group-item {:href "#"
                          :disabled true} "Link 3"]]
   [:h3 "Styling by color"]
   [rbs/list-group
    (for [val (map-indexed vector ["success" "info" "warning" "danger"])]
      (let [style (last val)
            name (clojure.string/capitalize (last val))]
        [rbs/list-group-item {:href "#"
                              :bs-style style} (clojure.string/join [name " link"])]))]
   [:h3 "With header"]
   [rbs/list-group
    [rbs/list-group-item {:href "#"
                          :header "Header 1"
                          :active true} "Link 1"]
    [rbs/list-group-item {:href "#"
                          :header "Header 2"} "Link 2"]
    [rbs/list-group-item {:href "#"
                          :header "Header 3"
                          :disabled true} "Link 3"]]
   [:h3 "With custom component children"]
   [rbs/list-group
    (for [index (range 1 4)]
      (let [name (clojure.string/join ["Component name " index])
            message (clojure.string/join ["Hello from " name])]
        [rbs/list-group-item
         [(fn []
            [rbs/button {:on-click #(js/alert message)} name])]]))]])


(defn tables-examples
  "Bootstrap tables component examples"
  []
  [:div
   [rbs/page-header "Tables " [:small [:code "table"]]]
   [:h3 "Common example"]
   [rbs/table {:striped true
               :bordered true
               :condensed true
               :hover true}
    [:thead
     [:tr
      [:th "#"]
      [:th "First Name"]
      [:th "Last Name"]
      [:th "Username"]]]
    [:tbody
     [:tr
      [:td "1"]
      [:td "Justin"]
      [:td "Firth"]
      [:td "@justinfirth"]]
     [:tr
      [:td "2"]
      [:td "John"]
      [:td "Doe"]
      [:td "@johndoe"]]
     [:tr
      [:td "3"]
      [:td {:col-span 2} "Frank the Tank"]
      [:td "@frankthetank"]]]]
   [:h3 "Responsive example"]
   [rbs/table {:responsive true}
    [:thead
     [:tr
      [:th "#"]
      [:th "Table heading"]
      [:th "Table heading"]
      [:th "Table heading"]
      [:th "Table heading"]
      [:th "Table heading"]
      [:th "Table heading"]]]
    [:tbody
     (for [index (range 1 6)]
       [:tr
        [:td index]
        [:td "Table cell"]
        [:td "Table cell"]
        [:td "Table cell"]
        [:td "Table cell"]
        [:td "Table cell"]
        [:td "Table cell"]])]]])


(defn panels-examples
  "Bootstrap panels component examples"
  []
  [:div
   [rbs/page-header "Panels " [:small [:code "panel"]]]])


(defn wells-examples
  "Bootstrap well component examples"
  []
  [:div
   [rbs/page-header "Wells " [:small [:code "well"]]]])