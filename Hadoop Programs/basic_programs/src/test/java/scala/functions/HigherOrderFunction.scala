package scala.functions

class FunctionClass {
  def number[A](x: A): String = {
    return (x.toString() + x.toString())
  }
}

object HigherOrderFunction {
  def main(args: Array[String]) {
    def sumation(f: Int => String, x: Int) = f(x)

    def number[A](x: A): String = {
      return (x.toString() )
    }

    val obj = new FunctionClass();

    println(sumation(obj.number, 7))
    println(sumation(number, 10))

  }
}