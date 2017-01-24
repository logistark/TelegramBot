package ADTs


object TelegramDTO {
  sealed trait ReplyMarkup
  object ReplyMarkups {
    case class InlineKeyboardMarkup() extends ReplyMarkup
    case class ReplyKeyboardMarkup() extends ReplyMarkup
    case class ReplyKeyboardHide() extends ReplyMarkup
    case class ForceReply() extends ReplyMarkup
  }

  final case class GetMe()
  final case class GetUpdates(offset: Option[Int], limit: Option[Int], timeout: Option[Int])
  final case class SendMessage(id: Int,
                               text: String,
                               parse_mode: Option[String],
                               disable_web_page_preview: Option[Boolean],
                               disable_notification: Option[Boolean],
                               reply_to_message_id: Option[Int],
                               reply_markup: ReplyMarkup )

  case class User(id: Int, first_name: String, last_name: Option[String] = None, username: Option[String] = None)
  case class Chat(id: Int, _type: String, title: Option[String] = None, username: Option[String] = None, first_name: Option[String] = None, last_name: Option[String] = None)
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
                   from: Option[User] = None,
                   date: Int,
                   chat: Chat,
                   forward_from: Option[User] = None,
                   forward_date: Option[Int] = None,
                   reply_to_message: Option[Message] = None,
                   text: Option[String] = None,
                   audio: Option[Audio] = None,
                   document: Option[Document] = None,
                   photo: Option[List[PhotoSize]] = None,
                   sticker: Option[Sticker] = None,
                   video: Option[Video] = None,
                   voice: Option[Voice] = None,
                   caption: Option[String] = None,
                   contact: Option[Contact] = None,
                   location: Option[Location] = None,
                   new_chat_participant: Option[User] = None,
                   left_chat_participant: Option[User] = None,
                   new_chat_title: Option[String] = None,
                   new_chat_photo: Option[List[PhotoSize]] = None,
                   delete_chat_photo: Option[Boolean] = None,
                   group_chat_created: Option[Boolean] = None,
                   supergroup_chat_created: Option[Boolean] = None,
                   channel_chat_created: Option[Boolean] = None,
                   migrate_to_chat_id: Option[Int] = None,
                   migrate_from_chat_id: Option[Int] = None
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




