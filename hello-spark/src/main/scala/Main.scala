import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.DoubleType

@main def helloSpark() = {    
    spark.sparkContext.setLogLevel("WARN")
    df.groupBy("accountId").sum("transactionAmount").show()
    println("Account ID count: " + df.select("accountId").distinct().count())
}

val spark = SparkSession.builder().appName("helloSpark").master("local[*]").getOrCreate()
val path = "./src/main/resources/transaction.txt"
val row = spark.read.options(Map("delimiter"->",", "header"->"true")).csv(path)
val df = row.withColumn("transactionAmount", col("transactionAmount").cast(DoubleType))
