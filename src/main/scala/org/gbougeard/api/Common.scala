package org.gbougeard.api

import com.typesafe.config.ConfigFactory

import scala.concurrent.Future
import scala.util.{Success, Failure}
import akka.actor.ActorSystem
import akka.event.Logging

import play.api.libs.json._
import play.api.libs.functional.syntax._

import spray.http._
import spray.client.pipelining._
import org.gbougeard.model.changes.ChangeInfo


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
  val PREFIX = ")]}'"

  def GetChanges(path: String) {
    implicit val system = ActorSystem("changes-client")

    import system.dispatcher

    // execution context for futures below
    val log = Logging(system, getClass)

    val pipeline: HttpRequest => Future[HttpResponse] = (
      addHeader("Content-Type", "application/json")
        ~> sendReceive
        ~> logResponse(log)
      //        ~> unmarshal[ChangeInfo]
      )

    log.info("Get " + host + path)
    val responseFuture: Future[HttpResponse] = pipeline(Get(host + path))

    responseFuture onComplete {
      case Success(response) =>
        //        log.info("response is: {} ", response.entity)
        val body = response.entity.toOption
        body.map {
          b =>
            val msg = b.asString
//            log.info(s"${msg.indexOf(PREFIX) + PREFIX.length}")
            val json = msg.substring(msg.indexOf(PREFIX) + PREFIX.length)
            log.info(s"json ${json.substring(0, 50)}")
            val changeInfo :ChangeInfo = Json.parse(json).as[ChangeInfo]
            log.info("changeInfo {}", changeInfo)
        }

        shutdown()

      case Failure(error) =>
        log.error(error, "Couldn't get changes")
        shutdown()
    }

    def shutdown(): Unit = {
      log.warning("shutdown!")
      //      IO(Http).ask(Http.CloseAll)(1.second).await
      system.shutdown()
    }
  }

  def url(path: String): String = {
    host + path
  }
}
