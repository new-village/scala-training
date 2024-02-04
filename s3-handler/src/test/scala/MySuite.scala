import munit.FunSuite

class MySuite extends munit.FunSuite {
  val s3 = new S3Handler()

  test("Test uploading file to S3") {
    val correctFp = "./src/test/resources/transaction.txt"
    assertEquals(true, s3.uploadFileToS3(correctFp))
  }
}

