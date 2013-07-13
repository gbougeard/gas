package org.gbougeard.model.groups

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
case class GroupOptionsInfo(visible_to_all: Boolean)

object GroupOptionsInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[GroupOptionsInfo]
}
