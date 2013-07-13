package org.gbougeard.model.changes

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 20:53
 * To change this template use File | Settings | File Templates.
 */
case class CommitInfo(commit: String,
                      parent: List[CommitInfo],
                      author: GitPersonInfo,
                      commiter: GitPersonInfo,
                      subject: String,
                      message: String)

object CommitInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  import GitPersonInfo._

  implicit val format = Json.format[CommitInfo]
}
