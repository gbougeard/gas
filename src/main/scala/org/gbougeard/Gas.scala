package org.gbougeard
package dsl

import akka.io.IO
import spray.can.Http
import org.gbougeard.api.Common


object Gas extends App {
  println("Hello, gas")

  val str = """
               (query status open and branch "master" limit 5 ,
               query status closed limit 5 ) get ("LABELS","ALL_FILES")
            """"

  import ChangeDsl._

  val changes = changeQuery(new lexical.Scanner(str)) match {
    case Success(order, _) => println(order)
      order
    case Failure(msg, _) => println("Failure: " + msg)
    case Error(msg, _) => println("Error: " + msg)
  }

   Common.GetChanges(changes.toString)
}
