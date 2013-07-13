package org.gbougeard.model.changes

import play.api.libs.json.Json
import org.gbougeard.model.accounts.AccountInfo

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 18:52
 * To change this template use File | Settings | File Templates.
 */
case class LabelInfo(approved:Option[AccountInfo],
                     rejected:Option[AccountInfo],
                     recommended:Option[AccountInfo],
                     disliked:Option[AccountInfo],
                     value:Option[String],
                     optional:Option[Boolean],
                     all:Option[List[ApprovalInfo]],
                     values:Option[Map[String, String]])

object LabelInfo{
  import AccountInfo._
  import ApprovalInfo._

  implicit val format = Json.format[LabelInfo]
}