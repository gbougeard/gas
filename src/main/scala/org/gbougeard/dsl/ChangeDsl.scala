package org.gbougeard.dsl

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 15/07/13
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */

import scala.util.parsing.combinator.syntactical._
import org.gbougeard.api.AST._

object ChangeDsl extends StandardTokenParsers {
  lexical.reserved +=("query", "status", "is", "age", "branch", "project", "owner", "get", "and", "or", "not", "-", "limit", "open", "closed", "merged")
  lexical.delimiters +=("(", ")", ",")

  lazy val changeQuery = queries ~ ("get" ~> (get_values?)) ^^ {
    case q ~ l => ChangeQuery(q, l)
  }

  lazy val queries = "(" ~> rep1sep(query, ",") <~ ")" ^^ Queries

  lazy val query = "query" ~> rep1sep(term, (operator_enum ?)) ^^ Query

  lazy val term = (
    status_spec |
      is_spec |
      age_spec |
      branch_spec |
      project_spec |
      owner_spec |
      limit_spec
    )

  lazy val operator_enum = ("and" | "or")

  lazy val status_spec = "status" ~> status_enum ^^ Status
    lazy val status_enum = ("open" | "merged" | "closed")
  lazy val is_spec = "is" ~> is_enum ^^ Is

    lazy val is_enum = ("open" | "merged" | "closed")

  lazy val age_spec = "age" ~> stringLit ^^ Age

  lazy val branch_spec = "branch" ~> stringLit ^^ Branch

  lazy val project_spec = "project" ~> stringLit ^^ Project
  lazy val owner_spec = "owner" ~> stringLit ^^ Owner
  lazy val limit_spec = "limit" ~> numericLit ^^ {
    case value => Limit(value.toInt)
  }

//  lazy val get_spec = "get" ~> (get_values ?)

  lazy val get_values = "(" ~> rep1sep(stringLit, ",") <~ ")" ^^ {
    case labels => Labels(labels map {
      label => Label(label)
    })
  }
}
