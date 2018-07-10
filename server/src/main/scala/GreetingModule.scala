import controllers._
import play.api.i18n.Langs
import play.api.mvc.ControllerComponents
import services.ServicesModule

trait GreetingModule extends ServicesModule {

  import com.softwaremill.macwire._

  lazy val greeterController = wire[GreeterController]
  lazy val apiController = wire[ApiController]
  lazy val authController = wire[AuthController]
  lazy val articlesController = wire[ArticlesController]
  lazy val profileController = wire[ProfileController]
  lazy val commentsController = wire[CommentsController]

  def langs: Langs

  def controllerComponents: ControllerComponents
}
