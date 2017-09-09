package wordcount

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCountChar {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Word Count & character count").setMaster("local") 
    val sc =  new SparkContext(conf)
    
    
    val key_value_1 = sc.textFile("/Users/rajanikant/Documents/GitHub/rajanikant-prodevans/Hadoop notes/spark notes/input/ip.txt")
                      .flatMap ( line => line.split(" ") )
                      .map ( word => (word,1) )
                      .reduceByKey(_+_)
    
    
    val key_value_2 = sc.textFile("/Users/rajanikant/Documents/GitHub/rajanikant-prodevans/Hadoop notes/spark notes/input/ip.txt")
                      .flatMap ( line => line.split(" ") )
                      .flatMap ( word => for( c <- word)
                              yield(c, 1)  
                      )
                      .reduceByKey(_+_)
 
                      
    key_value_1.foreach(println)
    key_value_2.foreach(println)
    sc.stop()
  }
}