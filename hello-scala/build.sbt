// build.sbt
scalaVersion := "2.13.12"
scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")

// 今後廃止の予定のAPIを利用している（-deprecation）
// 明示的に使用を宣言しないといけない実験的な機能や注意しなければならない機能を利用している（-feature）
// 型消去などでパターンマッチが有効に機能しない場合（-unchecked）
// その他、望ましい書き方や落とし穴についての情報（-Xlint）