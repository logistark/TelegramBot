import ADTs.TelegramDTO.{Chat, Message}
import cats.data.State
import cats.~>
import core.algebra.{SendMessageOp, TelegramBotOp}

/**
  * Created by jose on 11/10/16.
  */
object PureInterpreter {

  type KVStoreState[A] = State[Map[String, Any], A]
  val pureCompiler: TelegramBotOp ~> KVStoreState = new (TelegramBotOp ~> KVStoreState) {
    override def apply[A](fa: TelegramBotOp[A]): KVStoreState[A] = {
      fa match {
        case SendMessageOp(messageToSend) =>  State.modify[Map[String, Any]](_.updated(messageToSend.text, Message(1, None, 1, Chat(1, "Normal")))).asInstanceOf[KVStoreState[A]]

      }
    }
  }

}
