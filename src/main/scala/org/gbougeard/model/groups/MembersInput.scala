package org.gbougeard.model.groups

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
case class MembersInput(_one_member: String,
                        members: List[String])

object MembersInput {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[MembersInput]
}
