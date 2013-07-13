package org.gbougeard.model.changes

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
case class FileInfo(status: Option[String],
                    binary: Option[Boolean],
                    old_path: Option[String],
                    lines_inserted: Option[Int],
                    lines_deleted: Option[Int]
                     )

object FileInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[FileInfo]
}
