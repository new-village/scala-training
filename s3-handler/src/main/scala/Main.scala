import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider
import java.io.File
import org.apache.logging.log4j.scala.Logging

class S3Handler extends Logging{
  // Check if the necessary environment variables are set
  private val requiredEnvVars = List("AWS_ACCESS_KEY_ID", "AWS_SECRET_ACCESS_KEY", "S3_REGION", "S3_BUCKET_NAME")
  requiredEnvVars.foreach { envVar =>
    // Throw an exception if an environment variable is not set
    if (sys.env.get(envVar).isEmpty) {
      throw new IllegalArgumentException(s"$envVar environment variable is not set.")
    }
  }
  // Initalizing Variables
  private val s3BucketName = sys.env("S3_BUCKET_NAME")
  // Building AWS Connection
  private val s3Client = AmazonS3ClientBuilder.standard()
      .withCredentials(new EnvironmentVariableCredentialsProvider())
      .withRegion(sys.env("S3_REGION"))
      .build()

  /**
   * Uploads a file to S3.
   * 
   * This function attempts to upload a file specified by the filePath to an S3 bucket. It logs the outcome of the operation.
   * 
   * @param filePath The path of the file to be uploaded.
   * @return Returns true if the upload was successful, false otherwise.
   */
  def uploadFileToS3(filePath: String): Boolean = {
    scala.util.Try {
      val file = new File(filePath)
      s3Client.putObject(s3BucketName, file.getName, file)
      logger.info(s"$filePath is uploaded to $s3BucketName.")
    } match {
      case scala.util.Success(_) => true
      case scala.util.Failure(e) =>
        logger.error(s"Failed to upload $filePath to $s3BucketName.", e)
        false
    }
  }
}