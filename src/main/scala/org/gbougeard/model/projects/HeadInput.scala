package org.gbougeard.model.projects

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
case class HeadInput(ref:String)

object HeadInput {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[HeadInput]
}
