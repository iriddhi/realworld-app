package controllers

import models.{Greeting, User, UserAuthContainer, UserResponseContainer}
import play.api.i18n.Langs
import play.api.libs.json
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}
import play.twirl.api.Html
import services.GreetingService

class AuthController(greetingService: GreetingService,
                     langs: Langs,
                     cc: ControllerComponents) extends AbstractController(cc) {
  def newUser = Action(parse.json) { request =>
    request.body.validate[UserAuthContainer].fold(
      error => {
        BadRequest("Json format is not supported")

      },

      userAuthContainer => {
        val userResponse =
          UserResponseContainer(User(
            32343,
            userAuthContainer.user.email,
            "2018-07-04T05:03:34.937Z",
            "2018-07-04T05:03:34.944Z",
            userAuthContainer.user.username,
            None,
            None,
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MzIzNDMsInVzZXJuYW1lIjoiaWFtcmlkZGhpIiwiZXhwIjoxNTM1ODY0NjE0fQ.3UQrFV8d9tE5l2zWerjC5BY372deUcfSIgOspwma67M"
          ))
        Ok(Json.toJson(userResponse))
      }


    )
  }

}
