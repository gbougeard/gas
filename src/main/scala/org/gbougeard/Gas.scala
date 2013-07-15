package org.gbougeard
package dsl

object Gas extends App {
  println("Hello, gas")

  val str = """
               (query status "open" and branch "myBranch" ,
               query status "closed" limit 5 ) get ("LABELS","ALL_FILES")
            """"

  import ChangeDsl._

  changes(new lexical.Scanner(str)) match {
    case Success(order, _)  => println(order)
    case Failure(msg, _)    => println("Failure: " + msg)
    case Error(msg, _)      => println("Error: " + msg)
  }
}
