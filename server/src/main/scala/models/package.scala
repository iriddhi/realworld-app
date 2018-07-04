import play.api.libs.json.Json

package object models {

  case class Greeting(id: Int = -1, message: String, name: String)

  object Greeting {
    implicit val greetingFormat = Json.format[Greeting]
  }

  case class Person(name: String, address: Address, qualifications: Seq[Qualification])

  case class Address(streetName: String, firstLine: String)

  case class Qualification(name: String, institute: Institute, yearOfPassing: Int)

  case class Institute(name: String, address: Address)


  object Address {
    implicit val addressFormat = Json.format[Address]
  }

  object Institute {
    implicit val institute = Json.format[Institute]
  }
  object Qualification {
    implicit val qualificationFormat = Json.format[Qualification]
  }

  object Person {
    implicit val personFormat = Json.format[Person]
  }

  case class Articles(articles: Seq[Article], articleCount: Int)

  case class Article(title: String, slug: String, body: String, createdAt: String, updatedAt: String, description: String, author: Seq[Author], favorited: Boolean, favoritesCount: Int, tagList: Seq[String])

  case class Author(username: String, bio: Option[String], image: String, following: Boolean)

  object Author {
    implicit val authorFormat = Json.format[Author]
  }

  object Article {
    implicit val articlesFormat = Json.format[Article]
  }

  object Articles {
    implicit val articlesFormat = Json.format[Articles]
  }

}
