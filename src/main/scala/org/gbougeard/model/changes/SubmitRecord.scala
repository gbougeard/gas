package org.gbougeard.model.changes

import org.gbougeard.model.accounts.AccountInfo

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
case class SubmitRecord(status: String,
                        ok: Option[Map[String, AccountInfo]],
                        reject: Option[Map[String, AccountInfo]],
                        need: Option[Map[String, AccountInfo]],
                        may: Option[Map[String, AccountInfo]],
                        impossible: Option[Map[String, AccountInfo]],
                        error_message: Option[String])

object SubmitRecord {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  import AccountInfo._

  implicit val format = Json.format[SubmitRecord]
}
