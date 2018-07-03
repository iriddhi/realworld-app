package controllers

import models._
import play.api.i18n.Langs
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}
import play.twirl.api.Html
import services.GreetingService

class ApiController(greetingService: GreetingService,
                    langs: Langs,
                    cc: ControllerComponents) extends AbstractController(cc) {
  val person = new Person("Riddhi",
    Address("narmada", "apartment"),
    Seq(
      Qualification("high school",
        Institute("olf", Address("ramghat", "road")),
        2010),Qualification("senior secondary",Institute("amu", Address("marris", "road")), 2012)

    )
  )


  def getUser(id: String) = Action {
    val personJson = Json.toJson(person)
    Ok(personJson)
  }
}