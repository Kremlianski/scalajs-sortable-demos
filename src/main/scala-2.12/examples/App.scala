package examples
import net.scalapro.sortable.Sortable

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom

object App {
  @JSExportTopLevel("main")
  def main(): Unit = {

    //example1
    new Sortable(dom.document.getElementById("items"), null)


    //example2
    new Sortable(dom.document.getElementById("bar"), js.Dictionary("group"->"bar", "animation"->100))
    new Sortable(dom.document.getElementById("foo"), js.Dictionary("group"->"foo", "animation"->100))
    new Sortable(dom.document.getElementById("qux"), js.Dictionary(
      "group" -> js.Dictionary(
        "name" -> "qux",
        "put" -> js.Array("foo","bar")),
      "animation" -> 100
      )
    )

    //example3
    //only with 1.5.0
    val pull: js.Function2[Sortable, Sortable, js.Any] = {(to:Sortable, from: Sortable) => {

      from.el.children.length match {
        case x if x > 2 => true
        case _ => "clone"
      }
    }}

    val put: js.Function1[Sortable, js.Any] = {(to:Sortable ) => to.el.children.length < 4}

    new Sortable(dom.document.getElementById("foo1"), js.Dictionary("group"->"foo1", "animation"->100))
    new Sortable(dom.document.getElementById("bar1"), js.Dictionary(
      "group" -> js.Dictionary(
        "name" -> "bar1",
        "put" -> js.Array("qux1"),
        "pull" -> pull

      ),

        "animation" -> 100
      )
    )
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

    )
    )
  }
}
