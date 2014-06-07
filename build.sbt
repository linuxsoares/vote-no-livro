name := "vote-no-livro"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final"
)

play.Project.playJavaSettings
