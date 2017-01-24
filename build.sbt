name := "TelegramBot"

version := "1.0"

scalaVersion := "2.12.1"


libraryDependencies ++= Seq(
  "de.heikoseeberger" %% "akka-http-circe" % "1.11.0",
  "com.typesafe.akka" %% "akka-http" % "10.0.2",
  "org.typelevel" %% "cats" % "0.9.0",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

