package core.algebra

import ADTs.TelegramDTO.{Message, ReplyMarkup, Update, User}
import cats.free._


/**
  * Created by jose on 4/10/16.
  */


sealed trait TelegramBotOp[A]
final case class GetMe() extends TelegramBotOp[Option[User]]
final case class GetUpdates(offset: Option[Int], limit: Option[Int], timeout: Option[Int]) extends TelegramBotOp[Seq[Update]]
final case class SendMessage(id: Int,
                             text: String,
                             parse_mode: Option[String],
                             disable_web_page_preview: Option[Boolean],
                             disable_notification: Option[Boolean],
                             reply_to_message_id: Option[Int],
                             reply_markup: ReplyMarkup ) extends TelegramBotOp[Message]

class TelegramBotOps[F[_]](implicit I: Inject[TelegramBotOp, F]) {
  def getMeI(): Free[F, Option[User]] =
    Free.inject[TelegramBotOp, F](GetMe())

  def getUpdatesI(offset: Option[Int], limit: Option[Int], runtime: Option[Int]) ={
    Free.inject[TelegramBotOp, F](GetUpdates(offset, limit, runtime))
  }

  def sendMessage(id: Int,
                  text: String,
                  parse_mode: Option[String],
                  disable_web_page_preview: Option[Boolean],
                  disable_notification: Option[Boolean],
                  reply_to_message_id: Option[Int],
                  reply_markup: ReplyMarkup) = {
    Free.inject[TelegramBotOp, F](SendMessage(id, text, parse_mode, disable_web_page_preview, disable_notification, reply_to_message_id, reply_markup))  }
}

object TelegramBotOps {
  implicit def instance[F[_]](implicit I: Inject[TelegramBotOp, F]): TelegramBotOps[F] = new TelegramBotOps[F]
}
