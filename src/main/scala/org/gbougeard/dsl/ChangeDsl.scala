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
  lexical.reserved +=("query", "status", "is", "age", "branch", "project", "owner", "get", "and", "or", "not", "-", "limit")
  lexical.delimiters +=("(", ")", ",")

  lazy val changes = queries ~ get_spec ^^ {
    case q ~ l => ChangeQuery(q, Some(l))
  }

  lazy val queries = "(" ~> rep1sep(query, ",") <~ ")" ^^ {
    case queries => Queries(queries)
  }

  lazy val query = "query" ~> rep1sep(term, (operator_enum ?)) ^^ {
    case terms => Query(terms)
  }

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

  lazy val status_spec = "status" ~> stringLit ^^ {
    case name => Status(name)
  }
  //  lazy val status_enum = ("open" | "merged" | "closed")
  lazy val is_spec = "is" ~> stringLit ^^ {
    case status => Is(status)
  }

  //  lazy val is_enum = ("open" | "merged" | "closed")

  lazy val age_spec = "age" ~> stringLit ^^ {
    case value => Age(value)
  }

  lazy val branch_spec = "branch" ~> stringLit ^^ {
    case name => Branch(name)
  }

  lazy val project_spec = "project" ~> stringLit ^^ {
    case name => Project(name)
  }
  lazy val owner_spec = "owner" ~> stringLit ^^ {
    case name => Owner(name)
  }
  lazy val limit_spec = "limit" ~> numericLit ^^ {
    case value => Limit(value)
  }

//  lazy val get_spec = "get" ~> (get_values ?) ^^ {
//    case Some(labels) => labels.toString
//    case None => ""
//  }
  lazy val get_spec = "get" ~> "(" ~> rep1sep(stringLit, ",") <~ ")" ^^ {
    case labels => Labels(labels map {
      label => Label(label)
    })
  }
}
