package org.gbougeard.model.groups

import org.gbougeard.model.accounts.AccountInfo

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
case class GroupInfo(kind: String,
                     id: String,
                     name: String,
                     url: String,
                     options: GroupOptionsInfo,
                     description: String,
                     group_id: Long,
                     owner: String,
                     owner_id: String,
                     members: List[AccountInfo],
                     includes: List[GroupInfo])

object GroupInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  import AccountInfo._
  import GroupInfo._

  implicit val format = Json.format[GroupInfo]

  lazy val kind = "gerritcodereview#group"
}
