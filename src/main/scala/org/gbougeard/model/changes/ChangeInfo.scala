package org.gbougeard.model.changes

import org.joda.time.DateTime
import play.api.libs.json._
import play.api.libs.functional.syntax._
import org.gbougeard.model.accounts.AccountInfo
import spray.json.DefaultJsonProtocol

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
case class ChangeInfo(kind: String,
                      id: String,
                      project: String,
                      branch: String,
                      topic: Option[String],
                      change_id: String,
                      subject: String,
                      status: String,
                      created: String,
                      updated: String,
                      mergeable: Option[Boolean],
//                      _sortkey: String,
//                      _number: String,
                      owner: AccountInfo,
                      labels: Option[Map[String, LabelInfo]],
//                      permitted_labels: Option[Map[String, String]],
                      removable_reviewers: Option[List[AccountInfo]],
                      current_revision: Option[String]
//                      revisions: Option[Map[String, RevisionInfo]],
//                      _more_changes: Option[Boolean]
                       )

object ChangeInfo {

  import AccountInfo._
  import RevisionInfo._

  implicit val format = Json.format[ChangeInfo]

  lazy val kind = "gerritcodereview#change"

  //  implicit val readChange = (
  //    (__ \ 'kind).read[String] and
  //    (__ \ 'id).read[String] and
  //    (__ \ "project").read[String] and
  //    (__ \ "change_id").read[String] and
  //    (__ \ "subject").read[String] and
  //    (__ \ "status").read[String] and
  //    (__ \ "created").read[DateTime] and
  //    (__ \ "updatable").read[DateTime] and
  //    (__ \ "mergeable").read[Boolean] and
  //    (__ \ "owner").read[AccountInfo]
  //  )(Change)
}

import spray.json._
object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val accountInfoFormat = jsonFormat2(AccountInfo.apply)
  implicit val approvalInfoFormat = jsonFormat1(ApprovalInfo.apply)
  implicit val labelInfoFormat = jsonFormat8(LabelInfo.apply)
  implicit val changeInfoFormat = jsonFormat15(ChangeInfo.apply)
  //  implicit val orderConfirmationFormat = jsonFormat1(OrderConfirmation)
}
