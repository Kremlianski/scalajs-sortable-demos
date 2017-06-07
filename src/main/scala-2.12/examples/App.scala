package examples

import net.scalapro.sortable._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom
import org.scalajs.dom._
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js.{Function1, UndefOr}

object App {
  @JSExportTopLevel("main")
  def main(): Unit = {

    //example1
    Sortable(dom.document.getElementById("items"))


    //example2
    new Sortable(dom.document.getElementById("bar"), js.Dictionary(
      "group" -> "bar",
      "animation" -> 100
    ))
    new Sortable(dom.document.getElementById("foo"), js.Dictionary(
      "group" -> "foo",
      "animation" -> 100
    ))
    new Sortable(dom.document.getElementById("qux"), js.Dictionary(
      "group" -> js.Dictionary(
        "name" -> "qux",
        "put" -> js.Array("foo", "bar")),
      "animation" -> 100
    )
    )

    //example3
    //with 1.6.0
    val pull: js.Function2[Sortable, Sortable, js.Any] = { (to: Sortable, from: Sortable) => {

      from.el.children.length match {
        case x if x > 3 => true
        case _ => "clone"
      }
    }
    }

    val put: js.Function1[Sortable, js.Any] = { (to: Sortable) => to.el.children.length < 4 }

    new Sortable(dom.document.getElementById("foo1"), js.Dictionary("group" -> "foo1", "animation" -> 100))

    val bar1Prop = new SortableProps {
      override val group = js.Dictionary(

            "name" -> "bar1",
            "put" -> js.Array("qux1"),
            "pull" -> pull


      )
      override val animation = 100
    }

//    val bar1Prop = js.Dictionary(
//      "group" -> js.Dictionary(
//        "name" -> "bar1",
//        "put" -> js.Array("qux1"),
//        "pull" -> pull
//
//      ),
//
//      "animation" -> 100
//    )
    new Sortable(dom.document.getElementById("bar1"), bar1Prop)

    new Sortable(dom.document.getElementById("qux1"), js.Dictionary(
      "group" -> js.Dictionary(
        "name" -> "qux1",
        "put" -> put),
      "animation" -> 100

    )
    )
    // example 4
    // sorting
    new Sortable(dom.document.getElementById("sortTrue"), js.Dictionary(
      "group" -> "sorting",
      "sort" -> true,
      "animation" -> 200

    )
    )
    new Sortable(dom.document.getElementById("sortFalse"), js.Dictionary(
      "group" -> "sorting",
      "sort" -> false,
      "animation" -> 200

    )
    )

    // example 5
    // delay
    new Sortable(dom.document.getElementById("list"), js.Dictionary(

      "delay" -> 400

    ))

    // example 6
    // disable

    val sortable = new Sortable(dom.document.getElementById("list1"), null)
    val switcher = dom.document.getElementById("switcher")
    switcher.asInstanceOf[HTMLElement].onclick = (event: Event) => {
      val state = sortable.option("disabled").asInstanceOf[Boolean] // get

      sortable.option("disabled", !state) // set

      switcher.innerHTML = state match {
        case true => "disable"
        case false => "enable"
      }
    }

    // example 7
    // handle
    new Sortable(dom.document.getElementById("listWithHandle"), js.Dictionary(
      "handle" -> ".my-handle",
      "animation" -> 150
    ))

    // example 8
    // ghost
    new Sortable(dom.document.getElementById("simpleList"), js.Dictionary(
      "ghostClass" -> "ghost",
      "animation" -> 350
    ))

    // example 9
    // chosen
    new Sortable(dom.document.getElementById("chosenList"), js.Dictionary(
      "ghostClass" -> "ghost1",
      "chosenClass" -> "chosen",
      "animation" -> 200
    ))

    // example 10
    // force callback
    new Sortable(dom.document.getElementById("foo2"), js.Dictionary(
    "group" -> "foo2",
    "animation" -> 100,
    "forceFallback" -> true,
    "fallbackClass" -> "good"

  ))


  //example11
  //Scroll
  Sortable(dom.document.getElementById("scrollList"))


  //example12
  //Events
  val props = js.Dictionary("group" -> "share", "animation" -> 100)

  val e1 = Sortable(dom.document.getElementById("eventsList1"), props)
  val e2 = Sortable(dom.document.getElementById("eventsList2"), props)

  val fs: js.Function1[EventS, Unit] = (event) => {
    console info event.`type`
    console log event
  }
  val fm: js.Function1[EventM, Unit] = (event) => {
    console info event.`type`
    console log event
  }

  e1.option("onChoose", fs)
  e1.option("onStart", fs)
  e1.option("onEnd", fs)
  e1.option("onAdd", fs)
  e1.option("onUpdate", fs)
  e1.option("onSort", fs)
  e1.option("onRemove", fs)
  e1.option("onFilter", fs)
  e1.option("onClone", fs)
  e1.option("onMove", fm)


  e2.option("onChoose", fs)
  e2.option("onStart", fs)
  e2.option("onEnd", fs)
  e2.option("onAdd", fs)
  e2.option("onUpdate", fs)
  e2.option("onSort", fs)
  e2.option("onRemove", fs)
  e2.option("onFilter", fs)
  e2.option("onClone", fs)
  e2.option("onMove", fm)


  //example13
  //Storage

  val get: js.Function1[Sortable, js.Array[String]] = { (sortable: Sortable) => {

    import js.JSConverters._ //this adds additional 30kB :((

    val order = window.localStorage.getItem(sortable.option("group").name.asInstanceOf[String])
    order match {
      case x:String => x.split("|").toJSArray
      case _ => js.Array[String]()
    }
  }}

  val set: js.Function1[Sortable, Unit] = { (sortable: Sortable) => {
    val order = sortable.toArray()
    window.localStorage.setItem("localStorage-example", order.join("|"))
  }}

//  val storeProps = js.Dictionary(
//    "group" -> "localStorage-example",
//    "store" -> js.Dictionary(
//      "get" -> get,
//      "set" -> set
//
//
//    )
//  )


  val storeProps = new SortableProps{
    override val group = "localStorage-example"
    override val store = js.Dictionary(
      "get" -> get,
      "set" -> set

    )
    override val onStart: UndefOr[Function1[EventS, Unit]] = js.defined{
      (event:EventS) => console log event
    }
  }


  Sortable(dom.document.getElementById("storage"), storeProps)


}}
