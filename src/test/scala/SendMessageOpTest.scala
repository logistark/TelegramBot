import ADTs.TelegramDTO.{Chat, Message, ReplyMarkups}
import PureInterpreter.KVStoreState
import cats.Eval
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by jose on 24/01/17.
  */
class SendMessageOpTest extends FunSuite with Matchers {
  import core.algebra.TelegramBotOps._

  test("This program should produce a Message") {

    val program = sendMessage(1, "Hola Wey", None, None, None, None, ReplyMarkups.ForceReply())

    val result: KVStoreState[Message] =
      program foldMap PureInterpreter.pureCompiler

    val message: Option[Message] = result.run(Map.empty).value._1.get("Hola Wey").asInstanceOf[Option[Message]]

    message shouldBe (Some(Message(1, None, 1, Chat(1, "Normal"))))
  }


}
