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





  case class User(id: Int, email: String, createdAt: String, updatedAt: String, userName: String, bio: Option[String], image: Option[String], token: String)

  case class UserResponseContainer(user: User)

  object User {
    implicit val userFormat = Json.format[User]
  }
  object UserResponseContainer{
    implicit val format = Json.format[UserResponseContainer]
  }


  case class UserAuthContainer(user: UserAuth)
  case class UserAuth(email: String, password: String, username: String)

  object UserAuth{
    implicit val format = Json.format[UserAuth]
  }

  object UserAuthContainer {
    implicit val format = Json.format[UserAuthContainer]
  }

  case class Error(error: String)

  object Error {
    implicit val format = Json.format[Error]
  }



}