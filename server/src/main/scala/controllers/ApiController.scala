package controllers

import models.{Article, Author, _}
import play.api.i18n.Langs
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}
import play.twirl.api.Html
import services.GreetingService

class ApiController(greetingService: GreetingService,
                    langs: Langs,
                    cc: ControllerComponents) extends AbstractController(cc) {


  val articles = Articles(Seq(Article("tes 1", "tes1-kme2d0", "test only", "2018-07-02T02:46:31.902Z", "2018-07-02T02:46:31.902Z", "tes 1 test",
    Seq(
      Author("tes", None, "https://static.productionready.io/images/smiley-cyrus.jpg", false)),
    false, 1, Seq("elm", "learn"))), 500)


  val person = new Person("Riddhi",
    Address("narmada", "apartment"),
    Seq(
      Qualification("high school",
        Institute("olf", Address("ramghat", "road")),
        2010), Qualification("senior secondary", Institute("amu", Address("marris", "road")), 2012)

    )
  )

  def getUser(id: String) = Action {
    val personJson = Json.toJson(person)
    Ok(personJson)
  }

  def newUser = Action(parse.json) {
    request =>
      request.body.validate[Person].map {
        e =>
          println(e)
          Ok("Thanks for registration")

      }.recover {
        case _ => BadRequest("The format is not supported")
      }.get

  }

  def getArticles = Action {
    val articleJson = Json.toJson(articles)
    Ok(articleJson)
  }


  //  def getUser(id: String) = Action {
  //    val personJson = Json.toJson(person)
  //    Ok(personJson)
  //  }

  // Homework
  // create api for posting
  // POST  /user controllers.ApiController.newUser
  // in newUser
  // Json.validate[Person].get
  // print

  // All articles api
}