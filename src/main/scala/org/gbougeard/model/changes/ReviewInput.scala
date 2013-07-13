package org.gbougeard.model.changes

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 21:08
 * To change this template use File | Settings | File Templates.
 */
case class ReviewInput(message: Option[String],
                       labels: Option[Map[String, String]],
                       comments: Option[List[CommentInput]],
                       strict_labels: Option[Boolean],
                       drafts: Option[String],
                       notif: Option[String])

object ReviewInput {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  import CommentInput._

  implicit val format = Json.format[ReviewInput]
}
