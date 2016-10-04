package core.algebra

import ADTs.TelegramDTO.{Update, User}
import cats.free._


/**
  * Created by jose on 4/10/16.
  */

sealed trait TelegramBotOp[A]
final case class GetMe() extends TelegramBotOp[Option[User]]
final case class GetUpdates(offset: Option[Int], limit: Option[Int], timeout: Option[Int]) extends TelegramBotOp[Seq[Update]]

class TelegramBotOps[F[_]](implicit I: Inject[TelegramBotOp, F]) {
  def getMeI(): Free[F, Option[User]] =
    Free.inject[TelegramBotOp, F](GetMe())
}

object TelegramBotOps {
  implicit def instance[F[_]](implicit I: Inject[TelegramBotOp, F]): TelegramBotOps[F] = new TelegramBotOps[F]

  type TelegramBotProgram[A] = Free[TelegramBotOp, A]

  def getMe(): TelegramBotProgram[Option[User]] = {
    import cats.free.Free.liftF
    liftF(GetMe())
  }
}
