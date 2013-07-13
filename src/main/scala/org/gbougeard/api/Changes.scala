package org.gbougeard.api

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 18:28
 * To change this template use File | Settings | File Templates.
 */
class Changes {
  def query = ???

}

class Query {
  import Statuses._

  def status(s: Status) = ???

  def owner(user: String) = ???

  def topic(t: String) = ???

  def age(a: String) = ???

  def change(id: String) = ???

  def ownerIn(group: String) = ???

  def reviewer(user: String) = ???

  def reviewerIn(group: String) = ???

  def commit(sha1: String) = ???

  def project(p: String) = ???

  def branch(b: String) = ???

  def tr(id: String) = ???

  def bug(id: String) = ???

  def label(b: String) = ???

  def message(b: String) = ???
}


class Operator {
  def AND = ???

  def OR = ???

  def NOT = ???
}

object Statuses {

  sealed trait Status

  case object Open extends Status

  case object Merged extends Status

  case object Abandoned extends Status

  case object Draft extends Status

  case object Starred extends Status

  case object Watched extends Status

  case object Reviewed extends Status

  case object Submitted extends Status

  case object Closed extends Status

}