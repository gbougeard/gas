package org.gbougeard.model.projects

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
case class ProjectInfo(kind: String,
                       id: String,
                       name: String,
                       parent: Option[String],
                       description: Option[String],
                       branches: Option[Map[String, String]])

object ProjectInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[ProjectInfo]

  lazy val kind = "gerritcodereview#project"
}
