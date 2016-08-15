package au.gov.csc.rest

import net.liftweb.http.S
import net.liftweb.http.rest._

import scala.util.{Failure, Success}
import net.liftweb.json.JsonAST._

object Validate extends RestHelper {

  serve {
    case "api" :: "RequestAccessNumberWithEmail" :: q JsonGet _ =>
      val searchString = q ::: S.params("q")
      val mn = searchString.head
      mn match {
        case "case1" => JObject(List(JField("id", JString(mn)), JField("mn valid", JString("true")), JField("email valid", JString("true"))))

        case "case2" => JObject(List(JField("id", JString(mn)), JField("mn valid", JString("false")), JField("email valid", JString("true"))))

        case "case3" => JObject(List(JField("id", JString(mn)), JField("mn valid", JString("true")), JField("email valid", JString("false"))))

        case "case4" => JObject(List(JField("id", JString(mn)), JField("mn valid", JString("false")), JField("email valid", JString("false"))))
      }
  }
}