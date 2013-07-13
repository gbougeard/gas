package org.gbougeard.model.accounts

import play.api.libs.json.Json

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
case class QueryLimitInfo(min: Int, max: Int)

object QueryLimitInfo {
  implicit val format = Json.format[QueryLimitInfo]
}