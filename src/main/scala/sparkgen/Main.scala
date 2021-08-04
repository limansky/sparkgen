package sparkgen

import org.apache.spark.{ SparkConf, SparkContext }

object Main {
  def main(args: Array[String]): Unit = {
    val sc = SparkContext.getOrCreate(new SparkConf().setAppName("GENA"))

    val data = sc.parallelize(1 to 1000)

    val calc = Generator.createCalculator

    val mapped = data.map(calc.doMap)

    val result = mapped.reduce(_ + _)

    println(s"DONE,  result = $result")
  }
}
