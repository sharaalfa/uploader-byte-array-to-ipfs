package io.ipfs.controllers

import play.api.libs.json.Json
import play.api.mvc._

import javax.inject._

@Singleton
class WebController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def greetings() = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson("Welcome to sbt-play-npm!"))
  }
}
