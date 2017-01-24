import cats.{Monad, RecursiveTailRecM, ~>}
import core.algebra.{TelegramBotOp, TelegramBotOps}

/**
  * Created by jose on 11/10/16.
  */
object PureInterpreter {

  def instance[M[_]: Monad : RecursiveTailRecM](): (TelegramBotOp ~> M) = new (TelegramBotOp ~> M) {
    override def apply[A](fa: TelegramBotOp[A]): M[A] = ???
  }

}
