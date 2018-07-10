package models

import play.api.libs.json.Json


case class ProfileContainer(profile: Profile)
case class Profile(username: String, bio: String, image: String, following: Boolean)

object Profile {
  implicit val profileFormat = Json.format[Profile]
}

object ProfileContainer {
  implicit val profileFormat = Json.format[ProfileContainer]
}



