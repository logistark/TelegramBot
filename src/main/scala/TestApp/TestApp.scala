package TestApp

import ADTs.TelegramDTO.User
import cats.Id
import cats.free.Free
import core.algebra.{TelegramBotOp, TelegramBotOps}
import interpreters.Interpreters._
import org.http4s.client.Client
import org.http4s.client.blaze.PooledHttp1Client

import scalaz.concurrent.Task

/**
  * Created by jose on 4/10/16.
  */
object TestApp extends App {


  val client: Client = PooledHttp1Client()
  val program = TelegramBotOps.getMe()
  val result: Free[Task, Option[User]] = program compile telegramBotInterpreter(client)[Id]



}
