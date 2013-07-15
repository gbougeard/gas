package org.gbougeard.dsl

import org.specs2.mutable._
import org.specs2.matcher.ParserMatchers


/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 15/07/13
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
class ChangeDslSpec extends Specification  with ParserMatchers {
  val parsers = ChangeDsl

  import ChangeDsl._

  "The ChangeDsl" should {
    "parse a simple Query" in {
      val str = """( query status "open" ) get"""
      val expectedResult = """q=status:open"""

      changes must succeedOn(new lexical.Scanner(str)).withResult(expectedResult)
    }

    "parse a double Query with Labels" in {
      val str = """
                   ( query status "open" and branch "myBranch" ,
                     query status "closed" limit 5) get("LABELS","ALL_FILES")
                """
      val expectedResult = """q=status:open+branch:myBranch&q=status:closed+limit:5&o=LABELS&o=ALL_FILES"""

      changes must succeedOn(new lexical.Scanner(str)).withResult(expectedResult)
    }


  }

}