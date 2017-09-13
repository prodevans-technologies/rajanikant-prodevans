package data.frame

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object FrameBasis {
  def main(args: Array[String]): Unit = {
    /*
     * configuration the job
     */
    val conf = new SparkConf().setAppName("Frame Basic").setMaster("local").set("spark.hadoop.validateOutputSpaces", "false")
    val sc = new SparkContext(conf)

    /*
     * Load Employee Data
     */
    val employeeRDD = sc.textFile("/Users/rajanikant/Documents/GitHub/rajanikant-prodevans/Hadoop notes/spark notes/input/emp_data.csv", 2)

    val rawRDDEmployee = employeeRDD.map { record => record.split(",", -1) }
      .map { x =>
        CaseClassEmployess(
          Integer.parseInt(x(0).toString()),
          x(1),
          x(2),
          x(3),
          Integer.parseInt(x(4).toString()),
          x(5))
      }

    val deptRDD = sc.textFile("/Users/rajanikant/Documents/GitHub/rajanikant-prodevans/Hadoop notes/spark notes/input/dept.csv", 2)

    val rawRDDDept = deptRDD.map { record => record.split(",", -1) }
      .map { x =>
        CaseClassDept(
          x(0),
          x(1))
      }

    val sqlContext = new SQLContext(sc)

    import sqlContext.implicits._

    val rawDF = rawRDDEmployee.toDF();

    rawDF.show()

    val rawDFDept = rawRDDDept.toDF();

    rawDFDept.show()
    
    /*
      * Display only the name filds
      */
    //rawDF.select("emp_name").show()

    /*
      * filter dataframe based n < emp_salary
      */
    //rawDF.select($"emp_sal" > 50000).show()

    /*
      * grouped by the base on emp_department
      */

    //rawDF.groupBy("emp_dept").count().show()

    /*
      * data flow registration as temprary table
      */
    rawDF.registerTempTable("Employees")
    rawDFDept.registerTempTable("Departments")
    // val queryDF = sqlContext.sql("select emp_name, emp_sal from Employees")
    val queryDF = sqlContext.sql("select emp_dept, max(emp_sal) from Employees group by emp_dept")

    queryDF.show();
    
    val queryJoin = sqlContext.sql("select e.emp_id, e.emp_name, e.emp_doj, d.dept_name "
        +" from Employees e JOIN Departments d where e.emp_dept = d.dept_id")
    
    queryJoin.show()
    
    sc.stop()
    
  }
}