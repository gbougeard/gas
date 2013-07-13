package org.gbougeard.model.projects

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
case class RepositoryStatisticsInfo(number_of_loose_objects:Int,
                                    number_of_loose_refs:Int,
                                    number_of_pack_files:Int,
                                    number_of_packed_objects:Int,
                                    number_of_packed_refs:Int,
                                    size_of_loose_objects:Int,
                                    size_of_packed_objects:Int)

object RepositoryStatisticsInfo {

  import play.api.libs.json.Json
  import play.api.libs.functional.syntax._

  implicit val format = Json.format[RepositoryStatisticsInfo]
}
