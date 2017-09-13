package wordcount

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object filter {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Word Count & character count").setMaster("local")
    val sc = new SparkContext(conf)

    val contentRDD = sc.textFile("/Users/rajanikant/Documents/GitHub/rajanikant-prodevans/Hadoop notes/spark notes/input/ip_new.txt")

    val word = contentRDD.flatMap(line => line.split(","))

    val removeRDD = sc.textFile("/Users/rajanikant/Documents/GitHub/rajanikant-prodevans/Hadoop notes/spark notes/input/op_new.txt")
      .flatMap(line => line.split(",", -1))

    val bRemove = sc.broadcast(removeRDD.collect().toList)

    val filterRDD = word.filter {
      x =>
        x match {
          case x => !bRemove.value.contains(x)
        }

    }
    filterRDD.saveAsTextFile("/Users/rajanikant/Documents/GitHub/rajanikant-prodevans/Hadoop notes/spark notes/input/des.txt")

  }
}