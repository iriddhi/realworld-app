import play.api.libs.json.Json

package object models {

  case class Greeting(id: Int = -1, message: String, name: String)

  object Greeting {
    implicit val GreetingFormat = Json.format[Greeting]
  }

  case class Person(name: String, address: Address, qualifications: Seq[Qualification])

  case class Address(streetName: String, firstLine: String)

  case class Qualification(name: String, institute: Institute, yearOfPassing: Int)

  case class Institute(name: String, address: Address)


  object Address {
    implicit val AddressFormat = Json.format[Address]
  }

  object Institute {
    implicit val Institute = Json.format[Institute]
  }
  object Qualification {
    implicit val QualificationFormat = Json.format[Qualification]
  }

  object Person {
    implicit val PersonFormat = Json.format[Person]
  }

}
