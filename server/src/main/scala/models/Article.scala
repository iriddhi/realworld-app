package models

import play.api.libs.json.Json

case class Articles(articles: Seq[Article], articlesCount: Int)

case class Article(title: String, slug: String, body: String, createdAt: String, updatedAt: String, description: Option[String], author: Author, favorited: Boolean, favoritesCount: Int, tagList: Seq[String])

case class Author(username: String, bio: Option[String], image: String, following: Boolean)

case class Tags(tags: Seq[String])

object Author {
  implicit val authorFormat = Json.format[Author]
}

object Article {
  implicit val articlesFormat = Json.format[Article]
}

object Articles {
  implicit val articlesFormat = Json.format[Articles]
}


object Tags {
  implicit val tagsFormat = Json.format[Tags]
}
