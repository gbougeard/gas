package org.gbougeard.api

import com.typesafe.config.ConfigFactory


/**
 * Created with IntelliJ IDEA.
 * User: gbougeard
 * Date: 15/07/13
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
object Common {
  val config = ConfigFactory.load()
  val host = config.getString("gerrit.url")

  def GET(path:String) = {
    Async {
      WS.url(url(path))
        .withHeaders(("Accept", "application/json"))
        .get().map {
        response =>
        //            Logger.debug(response.body)
      }
    }
  }

  def url(path: String): String = {
    host + path
  }
}
