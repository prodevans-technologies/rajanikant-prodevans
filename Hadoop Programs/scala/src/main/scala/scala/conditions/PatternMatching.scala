package scala.conditions

object PatternMatching {
  def main(args : Array[String]){
    
    println(matchTestInt(2))
    println(matchTestString("R"))
    println(matchTestAny("two"))
     println(matchTestAny("dcdv"))
    def matchTestInt(x: Int): String = x match{
      case 1 => "one"
      case 2 => "two"
      case _ => "many"
    }
    
    def matchTestString(str : String): String = str match{
      case "R" => "rajani"
      case "K" => "Kant"
      case _ => "others"
    }
    
    def matchTestAny(x : Any): Any = x match{
       case 1 => "one"
      case "two" => 2
      case y: Int => "scala.Int"
      case _ => "others"
    }
    
  }
}