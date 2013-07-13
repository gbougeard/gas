package org.gbougeard.model.changes

import org.joda.time.DateTime

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
case class CommentInput(kind: Option[String],
                        id: Option[String],
                        path: Option[String],
                        side: Option[String],
                        line: Option[String],
                        in_reply_to: Option[String],
                        updated: Option[DateTime],
                        message: Option[String]
                         )

object CommentInput {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[CommentInput]
}
