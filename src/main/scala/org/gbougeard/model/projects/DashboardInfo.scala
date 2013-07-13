package org.gbougeard.model.projects

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:07
 * To change this template use File | Settings | File Templates.
 */
case class DashboardInfo (kind:String,
                           id:String,
                           project:String,
                           defining_project:String,
                           ref:String,
                           path:String,
                           description:Option[String],
                           foreach:Option[String],
                           url:String,
                           default:Boolean,
                           title:Option[String],
                           sections:List[DashboardSectionInfo])

object DashboardInfo{
  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._
  import DashboardSectionInfo._

  implicit val format = Json.format[DashboardInfo]

  lazy val kind = "gerritcodereview#dashboard"
}