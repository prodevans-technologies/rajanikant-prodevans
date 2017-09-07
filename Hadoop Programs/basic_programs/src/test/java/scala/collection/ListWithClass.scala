package scala.collection

object ListWithClass {
  def main(args : Array[String]){
    case class Student(st_roll : Int, st_name: String, st_marks: Int)
    val st_list = List(new Student(1,"ram",80),new Student(3,"vaibhav",80),new Student(4,"krish",40),new Student(5,"kam",60))
    st_list drop 1 take 3
    
    val first_student = st_list.head
    
    st_list.foreach { x => println("Student : "+x) }
    
    val last_student  = st_list.tail.last
    
    println(first_student)
    println(last_student)
    
    val pass_student = st_list.filter { x => x.st_marks > 60 }
  }
}