;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/.
;;
;; Copyright (c) 2017-2019 Andrey Antukh <niwi@niwi.nz>

(ns uxbox.main.refs
  "A collection of derived refs."
  (:require [lentes.core :as l]
            [beicon.core :as rx]
            [uxbox.main.constants :as c]
            [uxbox.main.store :as st]))

(def profile
  (-> (l/key :profile)
      (l/derive st/state)))

(def workspace
  (-> (l/key :workspace-local)
      (l/derive st/state)))

(def workspace-local
  (-> (l/key :workspace-local)
      (l/derive st/state)))

(def workspace-layout
  (-> (l/key :workspace-layout)
      (l/derive st/state)))

(def workspace-page
  (-> (l/key :workspace-page)
      (l/derive st/state)))

(def workspace-file
  (-> (l/key :workspace-file)
      (l/derive st/state)))

(def workspace-users
  (-> (l/key :workspace-users)
      (l/derive st/state)))

(def workspace-data
  (-> (l/key :workspace-data)
      (l/derive st/state)))

(def selected-shapes
  (-> (l/key :selected)
      (l/derive workspace-local)))

(def selected-canvas
  (-> (l/key :selected-canvas)
      (l/derive workspace-local)))

(def toolboxes
  (-> (l/key :toolboxes)
      (l/derive workspace-local)))

;; DEPRECATED
(def flags
  (-> (l/key :flags)
      (l/derive workspace-local)))

(def selected-flags
  (-> (l/key :flags)
      (l/derive workspace-local)))

(def selected-zoom
  (-> (l/key :zoom)
      (l/derive workspace-local)))

(def selected-tooltip
  (-> (l/key :tooltip)
      (l/derive workspace-local)))

(def selected-drawing-shape
  (-> (l/key :drawing)
      (l/derive workspace-local)))

(def selected-drawing-tool
  (-> (l/key :drawing-tool)
      (l/derive workspace)))

(def selected-edition
  (-> (l/key :edition)
      (l/derive workspace)))

(def history
  (-> (l/key :history)
      (l/derive workspace)))

(defn selected-modifiers
  [id]
  {:pre [(uuid? id)]}
  (-> (l/in [:modifiers id])
      (l/derive workspace)))

(defn alignment-activated?
  [flags]
  (and (contains? flags :grid-indexed)
       (contains? flags :grid-snap)))

(def selected-alignment
  (-> (comp (l/key :flags)
            (l/lens alignment-activated?))
      (l/derive workspace)))

(def shapes-by-id
  (-> (l/key :shapes)
      (l/derive st/state)))




