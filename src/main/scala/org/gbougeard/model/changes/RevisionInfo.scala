package org.gbougeard.model.changes

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 21:16
 * To change this template use File | Settings | File Templates.
 */
case class RevisionInfo(draft: Boolean,
                        _number: Int,
                        fetch: Map[String, FetchInfo],
                        commit: CommentInfo,
                        files: Map[String, FileInfo])

object RevisionInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  import FetchInfo._
  import FileInfo._

  implicit val format = Json.format[RevisionInfo]
}
