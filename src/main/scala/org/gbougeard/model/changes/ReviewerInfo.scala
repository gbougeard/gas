package org.gbougeard.model.changes

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 21:12
 * To change this template use File | Settings | File Templates.
 */
case class ReviewerInfo(kind: String,
                        approvals: Map[String,String])

object ReviewerInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[ReviewerInfo]

  lazy val kind = "gerritcodereview#reviewer"
}
