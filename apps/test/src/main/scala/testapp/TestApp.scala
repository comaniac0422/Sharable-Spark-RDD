import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import Array._
import scala.math._
import org.apache.spark.rdd._
import java.net._

// comaniac: Import extended package
import org.apache.spark.sparkextend._

object TestApp {
    def main(args : Array[String]) {
      val sc = get_spark_context("Test App")
      val srdd: SRDD_I[String] = sc.textFile("testSRDD", "/curr/cody/Course/cs249/Shareable-Spark-RDD/apps/test/testInput.txt", 2)
      srdd.cache
      println("#Input: " + srdd.count)
      println("Quadratic sum: " + srdd.map("pow", Array(2)).reduce("sum"))
      srdd.count
      println("pow test: 4, 3")
      srdd.map("pow", Array(4)).map("pow", Array(3))
      srdd.count
      srdd.map("pow", Array(2)).map("pow", Array(5))
      srdd.count

      println("Average: " + srdd.reduce("avg"))
      srdd.count
      srdd.count
      srdd.count
      srdd.map("pow", Array(7))
    }

    def get_spark_context(appName : String) : SparkContextwithSRDD = {
        val conf = new SparkConf()
        conf.setAppName(appName)
        
        return new SparkContextwithSRDD(conf)
    }
}

