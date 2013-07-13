package org.gbougeard.model.projects

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:07
 * To change this template use File | Settings | File Templates.
 */
case class DashboardSectionInfo(name: String,
                                query: String)

object DashboardSectionInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[DashboardSectionInfo]
}
