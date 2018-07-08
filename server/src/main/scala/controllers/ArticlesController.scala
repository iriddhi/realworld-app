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

    val responseJsonFile = "server/src/main/scala/mockdata/articlesByAuthorResponse.json"

    val articlesByAuthorResponse = scala.io.Source.fromFile(responseJsonFile, "utf-8").mkString

    if(author.isDefined){
      Json.parse(articlesByAuthorResponse).validate[Articles].fold(
        error=> {
          InternalServerError("We are encountering problem")
        },
        articleResponse =>{
          Ok(Json.toJson(articleResponse))
        }

      )
    }else{
      Ok("woops")
    }



  }

  def getArticleBySlug(slug: String) = Action { request =>
    Ok(slug)
  }

}