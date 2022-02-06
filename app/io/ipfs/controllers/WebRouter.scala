package io.ipfs.controllers

import controllers.Assets
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

import javax.inject.Inject

class WebRouter @Inject()(assets: Assets) extends SimpleRouter
{
  override def routes: Routes = {
    case GET(p"/") => assets.at("index.html")
    case GET(p"/$file<[^.]+([.][^.]+)+>") => assets.at(file)
    case GET(p"/$route*") => assets.at("index.html")
  }
}
