
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object updateform_Scope0 {
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

class updateform extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Optional[Proposal],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(proposal: Optional[Proposal]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

"""),_display_(/*3.2*/main("Update proposal")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
	


"""),format.raw/*7.1*/("""<div class="form-style-5">
	<form data-url="/proposal/">
		<fieldset>
			<legend id=heading> Proposal Form </legend>	
			<input data-field="uuid" type="hidden" """),_display_(/*11.44*/if(proposal.isPresent())/*11.68*/ {_display_(Seq[Any](format.raw/*11.70*/(""" """),format.raw/*11.71*/("""value=""""),_display_(/*11.79*/proposal/*11.87*/.get().uuid.get()),format.raw/*11.104*/("""" """)))}),format.raw/*11.107*/("""></input>
			<input data-field="name" type="text" placeholder="Proposal Name" """),_display_(/*12.70*/if(proposal.isPresent())/*12.94*/ {_display_(Seq[Any](format.raw/*12.96*/("""value=""""),_display_(/*12.104*/proposal/*12.112*/.get().name),format.raw/*12.123*/(""""""")))}),format.raw/*12.125*/("""></input>
			<textarea data-field="description" type="text" placeholder="Your Proposal">"""),_display_(/*13.80*/if(proposal.isPresent())/*13.104*/ {_display_(_display_(/*13.107*/proposal/*13.115*/.get().description))}),format.raw/*13.134*/("""</textarea>
			<input data-field="rank" type="hidden" """),_display_(/*14.44*/if(proposal.isPresent())/*14.68*/ {_display_(Seq[Any](format.raw/*14.70*/("""value=""""),_display_(/*14.78*/proposal/*14.86*/.get().rank),format.raw/*14.97*/(""""""")))}),format.raw/*14.99*/("""></input>
			
			<label> Subject: </label>
			<select id=subject> 
			<optgroup label="Regional">
				<option value="politics">Politics</option>
				<option value="city environment">City Environment</option>
			</optgroup>	
			<optgroup label="World">
				<option value="climate">Climate</option>
				<option value="poverty">Poverty</option>
				<option value="hunger">Hunger</option>
			</optgroup>
			</select>
		</fieldset>
		<input type="submit" class="update-btn" value="update"</input>
	</form>
</div>
""")))}),format.raw/*32.2*/("""
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
object updateform extends updateform_Scope0.updateform
              /*
                  -- GENERATED --
                  DATE: Sat Oct 21 18:44:54 CEST 2017
                  SOURCE: /Users/fredrik/github/idea-ranking-web-application/app/views/updateform.scala.html
                  HASH: e9648eb49cdd6c863a9a711689b1276e7c07f225
                  MATRIX: 767->1|892->31|920->34|951->57|990->59|1021->64|1209->225|1242->249|1282->251|1311->252|1346->260|1363->268|1402->285|1437->288|1543->367|1576->391|1616->393|1652->401|1670->409|1703->420|1737->422|1853->511|1887->535|1919->538|1937->546|1980->565|2062->620|2095->644|2135->646|2170->654|2187->662|2219->673|2252->675|2791->1184
                  LINES: 27->1|32->1|34->3|34->3|34->3|38->7|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|43->12|43->12|43->12|43->12|43->12|43->12|43->12|44->13|44->13|44->13|44->13|44->13|45->14|45->14|45->14|45->14|45->14|45->14|45->14|63->32
                  -- GENERATED --
              */
          