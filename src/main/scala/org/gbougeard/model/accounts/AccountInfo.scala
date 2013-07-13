package org.gbougeard.model.accounts

import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
case class AccountInfo(name: Option[String],
                       email: Option[String])

object AccountInfo {
  implicit val ownerFormat = Json.format[AccountInfo]
}