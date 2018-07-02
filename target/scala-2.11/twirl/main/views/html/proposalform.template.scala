
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object proposalform_Scope0 {
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

class proposalform extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Optional[Proposal],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(proposal: Optional[Proposal]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

"""),_display_(/*3.2*/main("Proposal form")/*3.23*/ {_display_(Seq[Any](format.raw/*3.25*/("""
	




"""),format.raw/*9.1*/("""<div class="form-style-5">
	<form data-url="/proposal/" data-nexturl="/proposal/">
		<fieldset>
			<legend id=heading> Proposal Form </legend>	
			<input data-field="uuid" type="hidden" </input>
			<input data-field="name" type="text" placeholder="Proposal Name" """),_display_(/*14.70*/if(proposal.isPresent())/*14.94*/ {_display_(Seq[Any](format.raw/*14.96*/(""" """),format.raw/*14.97*/("""value=""""),_display_(/*14.105*/proposal/*14.113*/.get().name),format.raw/*14.124*/("""" """)))}),format.raw/*14.127*/("""></input>
			<textarea data-field="description" type="text" placeholder="Your Proposal" """),_display_(/*15.80*/if(proposal.isPresent())/*15.104*/{_display_(Seq[Any](format.raw/*15.105*/("""""""),_display_(/*15.107*/proposal/*15.115*/.get().description),format.raw/*15.133*/(""""""")))}),format.raw/*15.135*/("""></textarea>
			<input data-field="date" type="hidden" """),_display_(/*16.44*/if(proposal.isPresent())/*16.68*/{_display_(Seq[Any](format.raw/*16.69*/(""" """),format.raw/*16.70*/("""value=""""),_display_(/*16.78*/proposal/*16.86*/.get().date),format.raw/*16.97*/("""" """)))}),format.raw/*16.100*/("""></input>
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
		<input type="submit" class="post-btn" value="Submit"</input>
	</form>
</div>
""")))}),format.raw/*33.2*/("""

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
object proposalform extends proposalform_Scope0.proposalform
              /*
                  -- GENERATED --
                  DATE: Sat Oct 21 18:44:54 CEST 2017
                  SOURCE: /Users/fredrik/github/idea-ranking-web-application/app/views/proposalform.scala.html
                  HASH: 986c8f4dc23df1895a0cc0b644b9495b3f9d8bda
                  MATRIX: 771->1|896->31|924->34|953->55|992->57|1025->64|1316->328|1349->352|1389->354|1418->355|1454->363|1472->371|1505->382|1540->385|1656->474|1690->498|1730->499|1760->501|1778->509|1818->527|1852->529|1935->585|1968->609|2007->610|2036->611|2071->619|2088->627|2120->638|2155->641|2688->1144
                  LINES: 27->1|32->1|34->3|34->3|34->3|40->9|45->14|45->14|45->14|45->14|45->14|45->14|45->14|45->14|46->15|46->15|46->15|46->15|46->15|46->15|46->15|47->16|47->16|47->16|47->16|47->16|47->16|47->16|47->16|64->33
                  -- GENERATED --
              */
          