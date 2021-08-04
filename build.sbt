lazy val sparkGen = (project in file("."))
  .settings(
    name := "sparkGen",
    version := "0.1",
    scalaVersion := "2.12.14",
    libraryDependencies ++= Seq(
      "org.scala-lang"       %  "scala-reflect"                % scalaVersion.value,
      "org.scala-lang"       %  "scala-compiler"               % scalaVersion.value,
      "org.apache.spark"     %% "spark-core"                   % versions.spark              % Provided,
      "ch.qos.logback"       %  "logback-classic"              % versions.logback              % Runtime
      
    )
  )

lazy val versions = new {
  val spark =  "3.1.2"
  val logback = "1.2.3"
}
