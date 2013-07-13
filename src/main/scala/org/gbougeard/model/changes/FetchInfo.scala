package org.gbougeard.model.changes

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 20:55
 * To change this template use File | Settings | File Templates.
 */
case class FetchInfo(url: String,
                     ref: String)

object FetchInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[FetchInfo]
}
