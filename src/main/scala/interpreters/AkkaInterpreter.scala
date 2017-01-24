package interpreters


import ADTs.TelegramDTO.{Chat, Message, User}
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
import MediaTypes._
import cats.{Id, ~>}
import core.algebra.{GetMeOp, SendMessageOp, TelegramBotOp}

import scala.concurrent.{ExecutionContext, Future}
import HttpCharsets._
import HttpMethods._


/**
  * Created by jose on 24/01/17.
  */
object AkkaInterpreter {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  def instance(token: String)(implicit ec: ExecutionContext): (TelegramBotOp ~> Future) = new (TelegramBotOp ~> Future) {




    override def apply[A](fa: TelegramBotOp[A]): Future[A] = fa match {
      case SendMessageOp(messageToSend) => Future(Message(1, None, 1, Chat(1, "Normal")).asInstanceOf[A])
      case GetMeOp() => {
        val method = "GetMe"
        val request = HttpRequest(GET, uri = s"https://api.telegram.org/bot$token/$method")
        val responseFuture: Future[HttpResponse] =
          Http().singleRequest(request)

        Future(User(1, "pepe").asInstanceOf[A])

      }
    }
  }

}
