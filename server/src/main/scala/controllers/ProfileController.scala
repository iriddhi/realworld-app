package controllers

import models.{Article, Author, _}
import play.api.i18n.Langs
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}
import services.GreetingService

class ProfileController(greetingService: GreetingService,
                        langs: Langs,
                        cc: ControllerComponents) extends AbstractController(cc) {

  def getProfile(username: String) = Action {
    val profileLoc = "server/src/main/scala/mockdata/profile.json"

    val profileResponse = scala.io.Source.fromFile(profileLoc, "utf-8").mkString
    Json.parse(profileResponse).validate[ProfileContainer].fold(
      error => {
        InternalServerError("We are encountering problem")
      },
      profileResponse => {
        Ok(Json.toJson(profileResponse))
      }
    )
    }



}