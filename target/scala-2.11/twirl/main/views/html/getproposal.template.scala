
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object getproposal_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class getproposal extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Optional[Proposal],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(proposal: Optional[Proposal]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

"""),_display_(/*3.2*/main("The Proposal")/*3.22*/ {_display_(Seq[Any](format.raw/*3.24*/("""

"""),format.raw/*5.1*/("""<style type="text/css"> 
.proposal-style"""),format.raw/*6.16*/("""{"""),format.raw/*6.17*/("""
    """),format.raw/*7.5*/("""max-width: 1000px;
    padding: 10px 20px;
    background: #f04f7f8;
    margin: 10px auto;
    background: #f4f7f8;
    border-radius: 8px;
    font-family: Georgia, "Times New Roman", Times, serif;
    font-size: 17px;
"""),format.raw/*15.1*/("""}"""),format.raw/*15.2*/("""

"""),format.raw/*17.1*/(""".proposal-style legend """),format.raw/*17.24*/("""{"""),format.raw/*17.25*/("""
		"""),format.raw/*18.3*/("""display: block;
    	font-size: 40px;
    	margin-bottom: 30px;
"""),format.raw/*21.1*/("""}"""),format.raw/*21.2*/("""


"""),format.raw/*24.1*/(""".proposal-style [id=textarea] """),format.raw/*24.31*/("""{"""),format.raw/*24.32*/("""
			"""),format.raw/*25.4*/("""background: #e8eeef;
			padding: 10px;
"""),format.raw/*27.1*/("""}"""),format.raw/*27.2*/("""

"""),format.raw/*29.1*/("""</style>

<div class=proposal-style>
<legend> Post Successful</legend>
	<br>
	<div id=textarea>
	<h3>&nbsp; """),_display_(/*35.14*/proposal/*35.22*/.get().name),format.raw/*35.33*/("""</h3><br>
	<p> &nbsp; &nbsp; """),_display_(/*36.21*/proposal/*36.29*/.get().description),format.raw/*36.47*/("""</p><br>
	<p> &nbsp; Rank: """),_display_(/*37.20*/proposal/*37.28*/.get().rank),format.raw/*37.39*/("""</p><br>
	<p> &nbsp; Date: """),_display_(/*38.20*/proposal/*38.28*/.get().date),format.raw/*38.39*/("""</p><br>
	<p> &nbsp; UUID: """),_display_(/*39.20*/proposal/*39.28*/.get().uuid.get()),format.raw/*39.45*/("""</p><br>
	<input type="button" align="right" value="Back to List" class="backToList"></input>
	<hr>
	</div>
</div>
""")))}),format.raw/*44.2*/("""

"""))
      }
    }
  }

  def render(proposal:Optional[Proposal]): play.twirl.api.HtmlFormat.Appendable = apply(proposal)

  def f:((Optional[Proposal]) => play.twirl.api.HtmlFormat.Appendable) = (proposal) => apply(proposal)

  def ref: this.type = this

}


}

/**/
object getproposal extends getproposal_Scope0.getproposal
              /*
                  -- GENERATED --
                  DATE: Sat Oct 21 18:44:54 CEST 2017
                  SOURCE: /Users/fredrik/github/idea-ranking-web-application/app/views/getproposal.scala.html
                  HASH: 0891072774ac8a44959136c345f08cc498287f42
                  MATRIX: 769->1|894->31|922->34|950->54|989->56|1017->58|1084->98|1112->99|1143->104|1391->325|1419->326|1448->328|1499->351|1528->352|1558->355|1649->419|1677->420|1707->423|1765->453|1794->454|1825->458|1891->497|1919->498|1948->500|2084->609|2101->617|2133->628|2190->658|2207->666|2246->684|2301->712|2318->720|2350->731|2405->759|2422->767|2454->778|2509->806|2526->814|2564->831|2710->947
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|37->6|37->6|38->7|46->15|46->15|48->17|48->17|48->17|49->18|52->21|52->21|55->24|55->24|55->24|56->25|58->27|58->27|60->29|66->35|66->35|66->35|67->36|67->36|67->36|68->37|68->37|68->37|69->38|69->38|69->38|70->39|70->39|70->39|75->44
                  -- GENERATED --
              */
          