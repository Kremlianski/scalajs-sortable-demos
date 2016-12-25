package examples

import org.scalajs.dom._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|


/**
  * Created by EXXO on 13.12.2016.
  */
@ScalaJSDefined
trait EventS extends js.Object {
  val to: js.Any
  val from: js.Any
  val item: js.Any
  //  val clone: js.Any
  val oldIndex: js.Any
  val newIndex: js.Any
}

@ScalaJSDefined //move event
trait EventM extends js.Object {
  val to: js.Any
  val from: js.Any
  val dragged: js.Any
  val draggedRect: js.Any
  val related: js.Any
  val relatedRect: js.Any
}


case class SortableProps
(
  group: js.Any = js.undefined, // or { name: "...", pull: [true, false, clone], put: [true, false, array] }
  sort: js.UndefOr[Boolean] = js.undefined, // sorting inside list
  delay: js.UndefOr[Int] = js.undefined, // time in milliseconds to define when the sorting should start
  disable: js.UndefOr[Boolean] = js.undefined, // Disables the sortable if set to true.
  store: js.Any = js.undefined, // @see Store
  animation: js.UndefOr[Int] = js.undefined, // ms, animation speed moving items when sorting, `0` — without animation
  handle: js.UndefOr[String] = js.undefined, // Drag handle selector within list items
  filter: js.UndefOr[String] = js.undefined, // Selectors that do not lead to dragging (String or Function)
  draggable: js.UndefOr[String] = js.undefined, // Specifies which items inside the element should be draggable
  ghostClass: js.UndefOr[String] = js.undefined, // Class name for the drop placeholder
  chosenClass: js.UndefOr[String] = js.undefined, // Class name for the chosen item
  dragClass: js.UndefOr[String] = js.undefined, // Class name for the dragging item
  dataIdAttr: js.UndefOr[String] = js.undefined, forceFallback: js.UndefOr[Boolean] = js.undefined, // ignore the HTML5 DnD behaviour and force the fallback to kick in

  fallbackClass: js.UndefOr[String] = js.undefined, // Class name for the cloned DOM Element when using forceFallback
  fallbackOnBody: js.UndefOr[Boolean] = js.undefined, // Appends the cloned DOM Element into the Document's Body
  fallbackTolerance: js.UndefOr[Int] = js.undefined, // Specify in pixels how far the mouse should move before it's considered as a drag.

  scroll: js.UndefOr[Boolean] | Element = js.undefined, // or HTMLElement
  scrollFn: js.UndefOr[(Int, Int, Event) => Unit] = js.undefined, //function(offsetX, offsetY, originalEvent) { ... }, if you have custom scrollbar scrollFn may be used for autoscrolling
  scrollSensitivity: js.UndefOr[Int] = js.undefined, // px, how near the mouse must be to an edge to start scrolling.
  scrollSpeed: js.UndefOr[Int] = js.undefined, // px

  /* DataTransfer dataTransfer, /** HTMLElement */dragEl) {
   *dataTransfer.setData('Text', dragEl.textContent); // `dataTransfer` object of HTML5 DragEvent
   * }, */
  setData: js.UndefOr[(DataTransfer, Element) => Unit] = js.undefined,


  // Element is chosen
  /*function (/**Event*/evt) {
    evt.oldIndex;  // element index within parent
  } */
  onChoose: js.UndefOr[(EventS) => Unit] = js.undefined,


  // Element dragging started

  /*
  function (/**Event*/evt) {
  evt.oldIndex;  // element index within parent
  },
   */
  onStart: js.UndefOr[(EventS) => Unit] = js.undefined,


  /*
  function (/**Event*/evt) {
  evt.oldIndex;  // element's old index within parent
  evt.newIndex;  // element's new index within parent
  },
  */
  // Element dragging ended
  onEnd: js.UndefOr[(EventS) => Unit] = js.undefined,


  /*
   function (/**Event*/evt) {
   var itemEl = evt.item;  // dragged HTMLElement
   evt.from;  // previous list
   // + indexes from onEnd
  },
  */
  // Element is dropped into the list from another list
  onAdd: js.UndefOr[(EventS) => Unit] = js.undefined,


  /*
   function (/**Event*/evt) {
   var itemEl = evt.item;  // dragged HTMLElement
   // + indexes from onEnd
   },
   */
  // Changed sorting within list
  onUpdate: js.UndefOr[(EventS) => Unit] = js.undefined,


  /*
  function (/**Event*/evt) {
  // same properties as onUpdate
  },
  */
  // Called by any change to the list (add / update / remove)
  onSort: js.UndefOr[(EventS) => Unit] = js.undefined,


  /*
  function (/**Event*/evt) {
  // same properties as onUpdate
  },
  */
  // Element is removed from the list into another list
  onRemove: js.UndefOr[(EventS) => Unit] = js.undefined,


  /*
  function (/**Event*/evt) {
   var itemEl = evt.item;  // HTMLElement receiving the `mousedown|tapstart` event.
   },
   */
  // Attempt to drag a filtered element
  onFilter: js.UndefOr[(EventS) => Unit] = js.undefined,


  /*
  function (/**Event*/evt, /**Event*/originalEvent) {
  // Example: http://jsbin.com/tuyafe/1/edit?js,output
  evt.dragged; // dragged HTMLElement
  evt.draggedRect; // TextRectangle {left, top, right и bottom}
  evt.related; // HTMLElement on which have guided
  evt.relatedRect; // TextRectangle
  originalEvent.clientY; // mouse position
  // return false; — for cancel
  },
  */
  // Event when you move an item in the list or between lists
  onMove: js.UndefOr[(EventM, Event) => Unit] = js.undefined,


  /*
  function (/**Event*/evt) {
  var origEl = evt.item;
  var cloneEl = evt.clone;
  }
  */
  // Called when creating a clone of element
  onClone: js.UndefOr[(EventS) => Unit] = js.undefined


)


@js.native
class Sortable(element: Element, props: js.Any) extends js.Any {
  val el: Element = js.native
}


