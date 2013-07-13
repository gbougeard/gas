package org.gbougeard.model.changes

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
case class TopicInput(topic: Option[String],
                      message: Option[String])

object TopicInput {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[TopicInput]
}
