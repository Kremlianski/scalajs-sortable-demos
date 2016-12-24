package examples
import net.scalapro.sortable.Sortable

import scala.scalajs.js
import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom

object App {
  @JSExportTopLevel("main")
  def main(): Unit = {
    new Sortable(dom.document.getElementById("items"), null)
  }
}
