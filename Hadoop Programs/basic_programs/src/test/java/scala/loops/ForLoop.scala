package scala.loops

import scala.io.StdIn

object ForLoop {
  def main(args : Array[String]){
    println("Enter the data")
    
    val input = StdIn.readLine().toInt
    
    for(j <- 1 to input)
    {
      println(j)
    }
  }
}