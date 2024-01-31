import munit.FunSuite
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.DoubleType

class MainTest extends FunSuite {

  test("helloSpark") {
    val spark = SparkSession.builder().appName("helloSparkTest").master("local[*]").getOrCreate()
    val path = "./src/main/resources/transaction.txt"
    val row = spark.read.options(Map("delimiter"->",", "header"->"true")).csv(path)
    val df = row.withColumn("transactionAmount", col("transactionAmount").cast(DoubleType))

    // Call the helloSpark method
    helloSpark()

    // Add your assertions here
    // For example, you can check the number of rows in the DataFrame
    val expectedRowCount: Long = 991
    assertEquals(df.count(), expectedRowCount)
  }
}