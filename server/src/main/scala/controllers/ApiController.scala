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


  val articles = Articles(Seq(Article("How to train your drdagon", "How-to-train-your-drdagon", "with two dhands", "2018-07-02T02:46:31.902Z", "2018-07-02T02:46:31.902Z", None,

      Author("johnjacob", None, "https://static.productionready.io/images/smiley-cyrus.jpg", false),
    false, 1, Seq("training", "dragons"))), 500)


  val person = new Person("Riddhi",
    Address("narmada", "apartment"),
    Seq(
      Qualification("high school",
        Institute("olf", Address("ramghat", "road")),
        2010), Qualification("senior secondary", Institute("amu", Address("marris", "road")), 2012)

    )
  )


  val tags = Tags(Seq("dragons", "training", "tags", "test", "as", "coffee", "flowers", "sushi", "money", "cars", "cookies", "well", "japan", "caramel", "animation", "clean", "happiness", "sugar", "baby"))

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

  def getTags = Action {
    val tagsJson = Json.toJson(tags)
    Ok(tagsJson)
  }

  val user = User(32343, "riddhi041994@mailinator.com", "2018-07-04T05:03:34.937Z", "2018-07-04T05:03:34.937Z", "i am riddhi", None, None, "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MzIzNDMsInVzZXJuYW1lIjoiaWFtcmlkZGhpIiwiZXhwIjoxNTM1ODY0NjE0fQ.3UQrFV8d9tE5l2zWerjC5BY372deUcfSIgOspwma67M")

  def getUser = Action {
    val userJson = Json.toJson(user)
    Ok(userJson)
  }

  def articleByAuthor = Action {
    val aarticleJson = Json.toJson(articles)
    Ok(aarticleJson)
  }

  def articlesFavoritedByUsername = Action {
    val aarticleFavoritedJson = Json.toJson(articles)
    Ok(aarticleFavoritedJson)
  }

  def singleArticleBySlug = Action {
    val singleArticleJson = Json.toJson(articles)
    Ok(singleArticleJson)
  }


}