package scala.collection

object TuppleBasic {
  def main(args : Array[String]){
    
    //creating of tupple
    val t = (1, "Hello", "Hadoop")
    val emp = ("emp01","RK",7500)
    
    //fetch single value form tupple
    println(emp._2)
    
    //iterate over the tuppel
    emp.productIterator.foreach { x => println("Value : " + x ) }
    
    val student = new Tuple4(1,"RK", "prodevans", "class-2")
    println("Concatinated with tostring : "+student.toString())

    
    val person = new Tuple2("RK",23)
    println(person.swap)
  }
}