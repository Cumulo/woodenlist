
(ns app.comp.sidebar
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo-ui.colors :as colors]
            [respo.macros :refer [defcomp <> span div]]
            [respo-ui.comp.icon :refer [comp-icon]]))

(def style-entry (merge ui/center {:width 40, :height 40, :cursor :pointer}))

(defcomp
 comp-sidebar
 (logged-in?)
 (div
  {:style (merge
           ui/column-parted
           {:font-size 24,
            :border-right (str "1px solid " (hsl 0 0 0 0.1)),
            :font-family ui/font-fancy})}
  (div
   {:style (merge ui/column)}
   (div
    {:on-click (fn [e d! m!] (d! :router/change {:name :home})), :style style-entry}
    (comp-icon :home))
   (div
    {:on-click (fn [e d! m!] (d! :router/change {:name :later})), :style style-entry}
    (comp-icon :ios-time-outline))
   (div
    {:on-click (fn [e d! m!] (d! :router/change {:name :done})), :style style-entry}
    (comp-icon :social-buffer)))
  (div
   {:style style-entry, :on-click (fn [e d! m!] (d! :router/change {:name :profile}))}
   (if logged-in? (comp-icon :ios-contact) (comp-icon :log-in)))))
