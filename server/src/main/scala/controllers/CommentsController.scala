package controllers

import models._
import play.api.i18n.Langs
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}
import services.GreetingService

class CommentsController(greetingService: GreetingService,
                         langs: Langs,
                         cc: ControllerComponents) extends AbstractController(cc) {

  def getCommentsForArticle(articleName: String) = Action {
      val commentLoc = "server/src/main/scala/mockdata/comments.json"

      val commentResponse = scala.io.Source.fromFile(commentLoc, "utf-8").mkString
      Json.parse(commentResponse).validate[Comments].fold(
        error => {
          InternalServerError("We are encountering problem")
        },
        commentResponse => {
          Ok(Json.toJson(commentResponse))
        }
      )

    }


}