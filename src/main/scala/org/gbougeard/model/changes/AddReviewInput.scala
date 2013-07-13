package org.gbougeard.model.changes

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 20:44
 * To change this template use File | Settings | File Templates.
 */
case class AddReviewInput(reviewers: Option[List[ReviewerInfo]],
                          error: Option[String],
                          confirm: Option[Boolean])

object AddReviewInput {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  import ReviewerInfo._

  implicit val format = Json.format[AddReviewInput]
}
