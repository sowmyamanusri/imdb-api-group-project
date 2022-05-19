package controllers

import models.Movie
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import play.api.libs.json._
import repositories.IMDbRepository
import javax.inject.{Inject, Singleton}

@Singleton
class IMDbController @Inject()(val controllerComponents: ControllerComponents, IMDbRepository: IMDbRepository) extends BaseController {

  @throws(classOf[Exception])
  def getMovieByID(IMDbID: String ): Action[AnyContent] = Action {
    val response = IMDbRepository.getIMDbMovieById(IMDbID)
    if (response.isEmpty) throw new Exception("No IMDb API service response is found")
    Ok(Json.toJson(response))
  }

  @throws(classOf[Exception])
  def getMoviesByName(IMDbName: String ): Action[AnyContent] = Action {
    val response = IMDbRepository.getIMDbMoviesByName(IMDbName)
    if (response.isEmpty) throw new Exception("No IMDb API service response is found")
    Ok(Json.toJson(response))
  }
}
