package org.gbougeard.model.groups

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
case class GroupsInput(_one_group: Option[String],
                       groups: Option[List[String]])

object GroupsInput {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[GroupsInput]
}
