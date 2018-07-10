package models

import play.api.libs.json.Json

case class Comments(comments: Seq[Comment])

case class Comment(id: Int, createdAt: String, updatedAt: String, body: String, author: Author)

object Comment {
  implicit val commentFormat = Json.format[Comment]
}

object Comments {
  implicit val CommentsFormat = Json.format[Comments]
}

