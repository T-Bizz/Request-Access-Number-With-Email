package au.gov.csc.rest.snippet

import net.liftweb.common.Loggable
import net.liftweb.http.SHtml
import net.liftweb.http.js.JE.ValById
import net.liftweb.http.js.{JsCmds}
import net.liftweb.json.DefaultFormats
import net.liftweb.util.Helpers._

import scala.xml.Text
import scala.util.{Success,Failure}

object AjaxInvoke extends Loggable {

  implicit val formats = DefaultFormats

  def isValid(in: String) : String = {
    ""
  }

  def render = "button [onclick]" #>
    SHtml.ajaxCall(ValById("sn"), s => JsCmds.SetHtml("inject", Text(isValid(s))))
}