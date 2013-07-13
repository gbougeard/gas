package org.gbougeard.model.changes

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
case class AbandonInput(message: Option[String])

object AbandonInput {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[AbandonInput]
}
