name := "TelegramBot"

version := "1.0"

scalaVersion := "2.11.8"
val circeVersion = "0.5.1"
val http4sVersion = "0.14.8a"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats" % "0.7.2",
)

