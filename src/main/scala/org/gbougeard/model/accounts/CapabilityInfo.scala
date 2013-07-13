package org.gbougeard.model.accounts

import play.api.libs.json.Json

/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 13/07/13
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
case class CapabilityInfo(administrateServer: Boolean,
                          queryLimit: QueryLimitInfo,
                          createAccount: Boolean,
                          createGroup: Boolean,
                          createProject: Boolean,
                          emailReviewers: Boolean,
                          killTask: Boolean,
                          viewCaches: Boolean,
                          flushCaches: Boolean,
                          viewConnections: Boolean,
                          viewQueue: Boolean,
                          runGC: Boolean,
                          startReplication: Boolean)

object CapabilityInfo {
  implicit val format = Json.format[CapabilityInfo]
}
