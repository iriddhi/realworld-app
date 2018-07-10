package controllers

import models.{Article, Author, _}
import play.api.i18n.Langs
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}
import services.GreetingService

class ArticlesController(greetingService: GreetingService,
                         langs: Langs,
                         cc: ControllerComponents) extends AbstractController(cc) {

  def getArticles(limit: Option[Int], offset: Option[Int],
                  author: Option[String],
                  favorited: Option[String],
                  tag: Option[String]) = Action {

    if (author.isDefined) {
      val articlesByAuthorResponseLoc = "server/src/main/scala/mockdata/articlesByAuthorResponse.json"

      val articlesByAuthorResponse = scala.io.Source.fromFile(articlesByAuthorResponseLoc, "utf-8").mkString
      Json.parse(articlesByAuthorResponse).validate[Articles].fold(
        error => {
          InternalServerError("We are encountering problem")
        },
        articleResponse => {
          Ok(Json.toJson(articleResponse))
        }
      )
    } else if (tag.isDefined) {
      val articleByTagResponseLoc = "server/src/main/scala/mockdata/articleByTagResponse.json"

      val articlesByTagResponse = scala.io.Source.fromFile(articleByTagResponseLoc, "utf-8").mkString
      Json.parse(articlesByTagResponse).validate[Articles].fold(
        error => {
          InternalServerError("We are encountering problem")
        },
        tagResponse => {
          Ok(Json.toJson(tagResponse))
        }
      )
    } else {
      Ok("woops")
    }
  }


  def getArticleBySlug(slug: String) = Action { request =>
    Ok(slug)
  }

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

