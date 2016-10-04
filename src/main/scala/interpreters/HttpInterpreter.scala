package interpreters

import cats.{Monad, RecursiveTailRecM, ~>}
import core.algebra.{GetMe, TelegramBotOp}
import org.http4s.Uri
import org.http4s.client.Client

/**
  * Created by jose on 4/10/16.
  */
object Interpreters {


  implicit def telegramBotInterpreter[M[_] : Monad : RecursiveTailRecM](implicit HI: Client): (TelegramBotOp ~> M) = new (TelegramBotOp ~> M) {

    override def apply[A](fa: TelegramBotOp[A]): M[A] = fa match {
      case GetMe() => {
        val target = Uri.uri("http://localhost:8080/hello/")
        HI.expect[String](target).run.mkString("\n").asInstanceOf[M[A]]
      }
    }
  }
}

