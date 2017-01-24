package ADTs

import ADTs.TelegramDTO.ReplyMarkup.{InlineKeyboardMarkup, ReplyKeyboardMarkup}
import shapeless.:+:

object TelegramDTO {
  sealed trait ReplyMarkup
  object ReplyMarkup{
    case class InlineKeyboardMarkup() extends ReplyMarkup
    case class ReplyKeyboardMarkup() extends ReplyMarkup
    case class ReplyKeyboardHide() extends ReplyMarkup
    case class ForceReply() extends ReplyMarkup
  }

  case class User(id: Int, first_name: String, last_name: Option[String], username: Option[String])
  case class Chat(id: Int, _type: String, title: Option[String], username: Option[String], first_name: Option[String], last_name: Option[String])
  case class Audio(file_id: String, duration: Int, performer: Option[String], title: Option[String], mime_type: Option[String], file_size: Option[Int])
  case class Document(file_id: String, thumb: Option[PhotoSize], file_name: Option[String], mime_type: Option[String], file_size: Option[Int])
  case class PhotoSize(file_id: String, width: Int, height: Int, file_size: Option[String])
  case class Sticker(file_id: String, width: Int, height: Int, thumb: Option[PhotoSize], emoji: Option[String], file_size: Option[Int])
  case class Video(file_id: String, width: Int, height: Int, duration: Int, thumb: Option[PhotoSize], mime_type: Option[String], file_size: Option[Int])
  case class Voice(file_id: String, duration: Int, mime_type: Option[String], file_size: Option[Int])
  case class Contact(phone_number: String, first_name: String, last_name: Option[String], user_id: Int)
  case class Location(longitude: Float, latitude: Float)
  case class Venue(location: Location, title: String, address: String, foursquare_id: Option[String])
  case class UserProfilePhotos(total_count: Int, photos: Seq[Seq[String]])
  case class File(file_id: String, file_size: Option[Int], file_path: Option[String])
  case class Message(message_id: Int,
                   from: Option[User],
                   date: Int,
                   chat: Chat,
                   forward_from: Option[User],
                   forward_date: Option[Int],
                   reply_to_message: Option[Message],
                   text: Option[String],
                   audio: Option[Audio],
                   document: Option[Document],
                   photo: Option[List[PhotoSize]],
                   sticker: Option[Sticker],
                   video: Option[Video],
                   voice: Option[Voice],
                   caption: Option[String],
                   contact: Option[Contact],
                   location: Option[Location],
                   new_chat_participant: Option[User],
                   left_chat_participant: Option[User],
                   new_chat_title: Option[String],
                   new_chat_photo: Option[List[PhotoSize]],
                   delete_chat_photo: Option[Boolean],
                   group_chat_created: Option[Boolean],
                   supergroup_chat_created: Option[Boolean],
                   channel_chat_created: Option[Boolean],
                   migrate_to_chat_id: Option[Int],
                   migrate_from_chat_id: Option[Int]
                  )
  case class MessageEntitity(_type: String, offset: Int, length: Int, url: Option[String])
  case class InlineQueryResult()
  case class InlineQuery(id: String, from: User, query: String, offset: String)
  case class ChosenInlineResult(inline_query_id: String, results: List[InlineQueryResult], cache_time: Int, nex_offset: String)
  case class Update(update_id: Int, message: Option[Message], inline_query: Option[InlineQuery], chosen_inline_result: Option[ChosenInlineResult], callbackQuery: Option[CallbackQuery])
  case class CallbackQuery()
  case class InputFile()
  case class SetWebhook(url: Option[String], certificate: Option[InputFile])




}




