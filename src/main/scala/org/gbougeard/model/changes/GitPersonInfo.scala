package org.gbougeard.model.changes

import org.joda.time.DateTime

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */
case class GitPersonInfo(name: String,
                         email: String,
                         date: DateTime,
                         tz: String)

object GitPersonInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[GitPersonInfo]
}
