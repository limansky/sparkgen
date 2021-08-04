package sparkgen

object Generator {
  import scala.reflect.runtime.universe._
  import scala.reflect.runtime.currentMirror
  import scala.tools.reflect.ToolBox

  def createCalculator: Calculator[Int, Int] = {
    val tb = currentMirror.mkToolBox()

    val tree =
      q"""
          new _root_.sparkgen.Calculator[Int, Int] {
            def doMap(t: Int): Int = t + 1 
          }
        """
    tb.compile(tree)().asInstanceOf[Calculator[Int, Int]]
  }
}
