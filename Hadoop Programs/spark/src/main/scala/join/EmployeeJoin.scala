package join

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
/*
 * EmployeeManager.csv(id,manager)
 * EmployeeName.csv(id,name)
 * EmployeeSalary.csv(id,salary)
 * 
 * 
 * 
 * Using spark generate a joined output like below ans save as in text file( seperated by comma)
 * for final distribution and the final output must be stored
 * [id,name,manager,salary]
 * 
 */
object EmployeeJoin {
  def main(args: Array[String]) {
    /*
     * configuration of the job    
     */
    val conf = new SparkConf().setAppName("Join on Employee").setMaster("local").set("spark.hadoop.validateOutputSpaces", "false")
    val sc = new SparkContext(conf)

    /*
     * Load EmployeeManager.csv form the HDFS and load data to an RDD and create pair RDD
     */

    val manager = sc.textFile("/Users/rajanikant/Documents/GitHub/rajanikant-prodevans/Hadoop notes/spark notes/input/EmployeeManager.csv")

    val ManagerPairRDD = manager.map { x => (x.split(",")(0), x.split(",")(1)) }

    /*
     * Load EmployeeName.csv form the HDFS and load data to an RDD and create pair RDD
     */

    val EmployeeName = sc.textFile("/Users/rajanikant/Documents/GitHub/rajanikant-prodevans/Hadoop notes/spark notes/input/EmployeeName.csv")

    val EmployeeNamePairRDD = EmployeeName.map { x => (x.split(",")(0), x.split(",")(1)) }

    /*
     * Load EmployeeSalary.csv form the HDFS and load data to an RDD and create pair RDD
     */

    val EmployeeSalary = sc.textFile("/Users/rajanikant/Documents/GitHub/rajanikant-prodevans/Hadoop notes/spark notes/input/EmployeeSalary.csv")

    val EmployeeSalaryPairRDD = EmployeeSalary.map { x => (x.split(",")(0), x.split(",")(1)) }

    /*
     *Join operation 
     */

    val joinedRDD = ManagerPairRDD.join(EmployeeNamePairRDD).join(EmployeeSalaryPairRDD)

    /*
     * Showing result on the terminal and the file
     */
    val resultRDD = joinedRDD.map(record => record._1 + "," + record._2._1._1 + "," + record._2._1._2 + "," + record._2._2)
    resultRDD.take(10).foreach { println }
   resultRDD.saveAsTextFile("/Users/rajanikant/Documents/GitHub/rajanikant-prodevans/Hadoop notes/spark notes/output/join")
   
   sc.stop()
  }
}