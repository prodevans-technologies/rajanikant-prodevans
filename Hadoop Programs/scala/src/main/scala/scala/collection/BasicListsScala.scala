package scala.collection

object BasicListsScala {
  val numbers :List[Int] =  List(1,2,3,4,5,6)
  val string : List[String] = List("ABC","PWZ","JJK","ijm","asd","dff")
  
  def displayNumbers(){
    numbers.foreach { println }
  }
  
  def displayString(){
    string.foreach{println}
  }
  
  def main(main : Array[String]){
      BasicListsScala.displayNumbers()
      BasicListsScala.displayString()
  }
  
  val fruit1 = "apples" :: ("oranges" :: ("pears" :: Nil))
  val fruit2 = "mangoes" :: ("banana" :: Nil)
  
  var fruits = fruit1 ::: fruit2 
  println("fruit1 ::: fruit2 :" + fruits)
  
   fruits = List.concat(fruit1 , fruit2)
   println("List.concat(fruit1 , fruit2) : "+fruits)

   val fruite_apple = List.fill(10)(2) // Repeat 2 , 10 times
   println("num  : " + fruite_apple)  
   
   val squres = List.tabulate(6)(n => n*n)
   println("square : "+ squres)
   
   val mul =List.tabulate(4, 5)(_*_)
   println("Mul : "+mul)
}