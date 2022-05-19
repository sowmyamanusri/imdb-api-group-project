package repositories

import models.Movie

import javax.inject.{Inject, Singleton}
import scala.collection.mutable
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import play.api.libs.json._
import play.api.libs.ws.ahc._

@Singleton
class IMDbRepository @Inject() (ws: StandaloneAhcWSClient) {

  private var APIKey = "k_12zl50uv"


  def getIMDbMovieById(IMDbID: String): String = {
    var IMDbRequestUrl = s"https://imdb-api.com/en/API/Trailer/"
    val APIService = ws.url(s"$IMDbRequestUrl$APIKey/$IMDbID").get()
    val response = Await.result(APIService, Duration.Inf)
    return response.body.toString
  }

  def getIMDbMoviesByName(MovieName: String): String = {
    var IMDbRequestUrl = s"https://imdb-api.com/en/API/SearchTitle/"
    val APIService = ws.url(s"$IMDbRequestUrl$APIKey/$MovieName").get()
    val response = Await.result(APIService, Duration.Inf)
    return response.body.toString
  }
}
