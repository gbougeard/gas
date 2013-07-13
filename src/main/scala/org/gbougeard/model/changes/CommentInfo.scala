package org.gbougeard.model.changes

import org.joda.time.DateTime

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 20:47
 * To change this template use File | Settings | File Templates.
 */
case class CommentInfo(kind: String,
                       id: String,
                       path: Option[String],
                       side: Option[String],
                       line: Option[String],
                       in_reply_to: Option[String],
                       message: Option[String],
                       updated: DateTime
                        )

object CommentInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[CommentInfo]

  lazy val kind = "gerritcodereview#comment"
}
