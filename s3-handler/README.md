# s3-handler

This project uploads and downloads files to AWS S3 using Scala3. `Main.scala` does not work by itself. It needs external instantiation and function calls. The `MySuite` code calls the `Main.scala`.

## Learning Objectives

* Class
* Using log4j, AWS SDK

## Usage

This is a normal sbt project. You can run it with `sbt test`.

```shell:
cd ~/scala-training/s3-handler
cp cp setEnv.sh local.sh
vim local.sh
source ./local.sh
sbt test
```

## Reference  
* [Log4j Scala API](https://logging.apache.org/log4j/scala/latest/)  
* [Default credentials provider chain - AWS SDK for Java 2.x](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/credentials-chain.html)
