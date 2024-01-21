# scala-training  
This is my scala training repository. The project stored minimum application for each flameworks and services. If you want to know app details, please read each app's `Readme.md`.

## How to setup a scala environment  
This project is based on WSL(Ubuntu).  
  
1. Install SDKMAN!  
```
sudo apt update
sudo apt install -y zip unzip
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
```
  
2. Install Java and SBT  
```
sdk install java
java --version
sdk install sbt
which sbt
```


## Applications
| Application Name         | Summary |
| ------------------------ | ------- |
| azure-blob-storage       | The Application manipulate files or data with Azure BLOB Storage                   |
  
## Reference  
* [Scala研修テキスト](https://scala-text.github.io/scala_text/)