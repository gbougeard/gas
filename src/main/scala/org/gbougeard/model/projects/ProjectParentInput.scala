package org.gbougeard.model.projects

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
case class ProjectParentInput(parent: String,
                              commit_message: Option[String])

object ProjectParentInput {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[ProjectParentInput]
}
