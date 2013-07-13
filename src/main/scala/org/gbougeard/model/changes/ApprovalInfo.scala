package org.gbougeard.model.changes

import play.api.libs.json.Json

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
case class ApprovalInfo(value :Option[String])

object ApprovalInfo{
  implicit val format = Json.format[ApprovalInfo]
}