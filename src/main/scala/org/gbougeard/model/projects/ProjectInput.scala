package org.gbougeard.model.projects

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
case class ProjectInput(name: Option[String],
                        parent: Option[String],
                        description: Option[String],
                        permission_only: Boolean,
                        create_empty_commit: Boolean,
                        submit_type: Option[String],
                        branches: Option[List[String]],
                        owners: Option[List[String]],
                        use_contributor_agreements: String,
                        use_signed_off_by: String,
                        use_content_merge: String,
                        require_change_id: String)

object ProjectInput {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[ProjectInput]
}
