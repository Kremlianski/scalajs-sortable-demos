package examples
import net.scalapro.sortable.Sortable

import scala.scalajs.js
import scala.scalajs.js._
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
        "put" -> js.Array("foo","bar"),
      "animation" -> 100
      )
    )
    )
  }
}
