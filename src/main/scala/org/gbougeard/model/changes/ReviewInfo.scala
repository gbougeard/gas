package org.gbougeard.model.changes

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 21:08
 * To change this template use File | Settings | File Templates.
 */
case class ReviewInfo(labels:Map[String, String])

object ReviewInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[ReviewInfo]
}
