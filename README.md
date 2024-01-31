# scala-training  
This is my scala training repository. The project stored minimum application for each flameworks and services. If you want to know app details, please read each app's `Readme.md`.

## Setup a scala environment  
This project is based on WSL(Ubuntu).  
  
1. Install Scala  
```
cd ~
curl -fL https://github.com/coursier/coursier/releases/latest/download/cs-x86_64-pc-linux.gz | gzip -d > cs && chmod +x cs && ./cs setup
cs java --jvm 11 --setup
```
  
2. Create new project  
```
cd ~
git clone git@github.com:new-village/scala-training.git
cd ~/scala-training
sbt new scala/scala3.g8
name [Scala 3 Project Template]: <PROJECT_NAME>
```

## Projects
| Project Name | Learning Objectives |
| --- | --- |
| [Hello World](https://github.com/new-village/scala-training/tree/main/hello-world) | Understanding Simple Scala Prject |
| [REST Call](https://github.com/new-village/scala-training/tree/main/rest-call) | Requesting HTTP, Parsing JSON, Using libraries |
| [Hello Spark](https://github.com/new-village/scala-training/tree/main/hello-spark) | Loading CSV to Spark, Manipulating Data on Spark |

## Reference  
* [Scala](https://www.scala-lang.org/)
* [Scala研修テキスト](https://scala-text.github.io/scala_text/)