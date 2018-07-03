import controllers.{ApiController, GreeterController}
import play.api.i18n.Langs
import play.api.mvc.ControllerComponents
import services.ServicesModule

trait GreetingModule extends ServicesModule {

  import com.softwaremill.macwire._

  lazy val greeterController = wire[GreeterController]
  lazy val apiController = wire[ApiController]

  def langs: Langs

  def controllerComponents: ControllerComponents
}
