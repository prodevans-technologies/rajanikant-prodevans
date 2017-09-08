package scala.functions

object Clouser {
  def main(args : Array[String]){
    val x : Int = 5
    val multiplyer = (I : Int) => I * x
    
    println("Multiplication(10) value is  : "+multiplyer(10))
    println("Multiplication(20) value is  : "+multiplyer(20))
    
  }
}