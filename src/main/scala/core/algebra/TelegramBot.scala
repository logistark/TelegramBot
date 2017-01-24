package core.algebra

import ADTs.TelegramDTO._
import cats.free._
import com.sun.xml.internal.ws.message.PayloadElementSniffer



/**
  * Created by jose on 4/10/16.
  */


sealed trait TelegramBotOp[A]
final case class GetMeOp() extends TelegramBotOp[Option[User]]
final case class GetUpdatesOp( getUpdatesOptions: GetUpdates) extends TelegramBotOp[Seq[Update]]
final case class SendMessageOp(messageToSend: SendMessage ) extends TelegramBotOp[Message]
object TelegramBotOps {
  import cats.free.Free._
  type TelegramBotProgram[A] = Free[TelegramBotOp, A]

  def getMe(): TelegramBotProgram[Option[User]] = liftF(GetMeOp())

  def getUpdates(offset: Option[Int], limit: Option[Int], runtime: Option[Int]): TelegramBotProgram[Seq[Update]] = {
    liftF(GetUpdatesOp(GetUpdates(offset, limit, runtime)))
  }

  def sendMessage(id: Int,
                  text: String,
                  parse_mode: Option[String],
                  disable_web_page_preview: Option[Boolean],
                  disable_notification: Option[Boolean],
                  reply_to_message_id: Option[Int],
                  reply_markup: ReplyMarkup): TelegramBotProgram[Message] = {
    liftF(SendMessageOp(SendMessage(id, text, parse_mode, disable_web_page_preview, disable_notification, reply_to_message_id, reply_markup)))  }
}





