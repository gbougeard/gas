package org.gbougeard.api

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 15/07/13
 * Time: 16:40
 * To change this template use File | Settings | File Templates.
 */
object AST {

  case class ChangeQuery(queries: Queries, labels: Option[Labels]) {
    override def toString: String = {
      val label = labels match {
        case Some(l) => "&" + l.toString
        case None => ""
      }
      queries + label
    }
  }

  case class Query(terms: List[Term]) {
    override def toString: String = "q=" + terms.mkString("+")
  }

  case class Queries(queries: List[Query]) {
    override def toString: String = queries.mkString("&")
  }

  case class Labels(labels: List[Label]) {
    override def toString: String = labels.mkString("&")
  }

  case class Label(label: String) {
    override def toString: String = s"o=${label}"
  }

  trait Term {
    val name: String
    val value: String

    override def toString: String = s"${name}:${value}"
  }

  case class Status(v: String) extends Term {
    val name = "status"
    val value = v
  }

  case class Is(v: String) extends Term {
    val name = "is"
    val value = v
  }

  case class Branch(v: String) extends Term {
    val name = "branch"
    val value = v
  }

  case class Project(v: String) extends Term {
    val name = "project"
    val value = v
  }

  case class Owner(v: String) extends Term {
    val name = "owner"
    val value = v
  }

  case class Age(v: String) extends Term {
    val name = "age"
    val value = v
  }

  case class Limit(v: String) extends Term {
    val name = "limit"
    val value = v
  }

}
