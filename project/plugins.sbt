// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.3")

// Corux's repository
resolvers += "corux-releases" at "http://tomcat.corux.de/nexus/content/repositories/releases/"

// Use javadoc sbt plugin to generate javadoc - https://github.com/corux/javadoc-sbt
addSbtPlugin("de.corux" % "javadoc-sbt" % "0.2.0")
