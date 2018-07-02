
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object list_Scope0 {
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

class list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Proposal],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(proposals: List[Proposal]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.29*/("""

"""),_display_(/*3.2*/main("Product List")/*3.22*/{_display_(Seq[Any](format.raw/*3.23*/("""

"""),format.raw/*5.1*/("""<style type="text/css">
.list-style """),format.raw/*6.13*/("""{"""),format.raw/*6.14*/("""
    """),format.raw/*7.5*/("""max-width: 1000px;
    padding: 10px 20px;
    background: #f4f7f8;
    margin: 10px auto;
    padding: 20px;
    border-radius: 8px;
    font-family: Georgia, "Times New Roman", Times, serif;
    font-size: 17px;
  """),format.raw/*15.3*/("""}"""),format.raw/*15.4*/("""

"""),format.raw/*17.1*/(""".list-style table """),format.raw/*17.19*/("""{"""),format.raw/*17.20*/("""
	"""),format.raw/*18.2*/("""border-collapse: collapse;
	witdh: 100%;
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/("""



"""),format.raw/*24.1*/(""".list-style legend """),format.raw/*24.20*/("""{"""),format.raw/*24.21*/("""
		"""),format.raw/*25.3*/("""display: block;
    	font-size: 40px;
   		 margin-bottom: 30px;
"""),format.raw/*28.1*/("""}"""),format.raw/*28.2*/("""


"""),format.raw/*31.1*/(""".list-style p:nth-child(even) """),format.raw/*31.31*/("""{"""),format.raw/*31.32*/("""background-color: #e8eeef;
				padding: 10px;	
				"""),format.raw/*33.5*/("""}"""),format.raw/*33.6*/("""

"""),format.raw/*35.1*/("""#button """),format.raw/*35.9*/("""{"""),format.raw/*35.10*/("""
  """),format.raw/*36.3*/("""display: inline-block;
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 18px;
  padding: 0px;
  width: 100px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
"""),format.raw/*48.1*/("""}"""),format.raw/*48.2*/("""

"""),format.raw/*50.1*/(""".post-up span """),format.raw/*50.15*/("""{"""),format.raw/*50.16*/("""
		"""),format.raw/*51.3*/("""cursor: pointer;
		display:inline-block;
		position: relative;
		transition:0.5s;		
"""),format.raw/*55.1*/("""}"""),format.raw/*55.2*/("""

"""),format.raw/*57.1*/(""".post-up span:after """),format.raw/*57.21*/("""{"""),format.raw/*57.22*/("""
				"""),format.raw/*58.5*/("""content: '\2191';
				position: absolut;
				opacity: 0;
				top: 0;
				right: 25px;
				transition: 0.5s;
"""),format.raw/*64.1*/("""}"""),format.raw/*64.2*/("""

"""),format.raw/*66.1*/(""".post-up:hover span """),format.raw/*66.21*/("""{"""),format.raw/*66.22*/("""
	"""),format.raw/*67.2*/("""padding-right: 25px;
"""),format.raw/*68.1*/("""}"""),format.raw/*68.2*/("""

"""),format.raw/*70.1*/(""".post-up:hover span:after """),format.raw/*70.27*/("""{"""),format.raw/*70.28*/("""
	"""),format.raw/*71.2*/("""opacity: 10;
	right: 0;
"""),format.raw/*73.1*/("""}"""),format.raw/*73.2*/("""

"""),format.raw/*75.1*/(""".post-down span """),format.raw/*75.17*/("""{"""),format.raw/*75.18*/("""
		"""),format.raw/*76.3*/("""cursor: pointer;
		display:inline-block;
		position: relative;
		transition:0.5s;		
"""),format.raw/*80.1*/("""}"""),format.raw/*80.2*/("""

"""),format.raw/*82.1*/(""".post-down span:after """),format.raw/*82.23*/("""{"""),format.raw/*82.24*/("""
				"""),format.raw/*83.5*/("""content: '\2193';
				position: absolut;
				opacity: 0;
				top: 0;
				right: 25px;
				transition: 0.5s;
"""),format.raw/*89.1*/("""}"""),format.raw/*89.2*/("""

"""),format.raw/*91.1*/(""".post-down:hover span """),format.raw/*91.23*/("""{"""),format.raw/*91.24*/("""
	"""),format.raw/*92.2*/("""padding-right: 25px;
"""),format.raw/*93.1*/("""}"""),format.raw/*93.2*/("""

"""),format.raw/*95.1*/(""".post-down:hover span:after """),format.raw/*95.29*/("""{"""),format.raw/*95.30*/("""
	"""),format.raw/*96.2*/("""opacity: 10;
	right: 0;
"""),format.raw/*98.1*/("""}"""),format.raw/*98.2*/("""

"""),format.raw/*100.1*/("""</style>

<div class=list-style>

<legend>&nbsp; Proposal List</legend>

<input type="button" align="left" value="New Post" class="new-post"></input>


<fieldset align="right">
    List size: 
    <label for="radio-1">10</label>
    <input type="radio" name="radio-1" id="radio-1">
    <label for="radio-2">20</label>
    <input type="radio" name="radio-1" id="radio-2">
    <label for="radio-3">All</label>
    <input type="radio" name="radio-1" id="radio-3">
  </fieldset>

<legend> </legend>
  
<table>
		"""),_display_(/*122.4*/for(proposal <- proposals.sortBy(- _.rank)) yield /*122.47*/ {_display_(Seq[Any](format.raw/*122.49*/("""
  			"""),format.raw/*123.6*/("""<p><font size="5">&nbsp; """),_display_(/*123.32*/proposal/*123.40*/.name),format.raw/*123.45*/("""</font><br><br>
			 &nbsp; &nbsp; """),_display_(/*124.20*/proposal/*124.28*/.description),format.raw/*124.40*/(""" """),format.raw/*124.41*/("""<br><br> Rank: """),_display_(/*124.57*/proposal/*124.65*/.rank),format.raw/*124.70*/(""" """),format.raw/*124.71*/("""<br> Created: """),_display_(/*124.86*/proposal/*124.94*/.date),format.raw/*124.99*/(""" """),format.raw/*124.100*/("""<br> Last updated: """),_display_(/*124.120*/proposal/*124.128*/.udate),format.raw/*124.134*/("""
			 """),format.raw/*125.5*/("""<input type="button" align="right" value="Promote" data-uuid=""""),_display_(/*125.68*/proposal/*125.76*/.uuid.get()),format.raw/*125.87*/("""" data-rank="" id=button class="post-up"></input> 
			 <input type="button" align="right" value="Demote" data-uuid=""""),_display_(/*126.67*/proposal/*126.75*/.uuid.get()),format.raw/*126.86*/("""" data-rank="" id=button class="post-down"></input> 
			 <input type="button" align="right" value="Update" data-uuid=""""),_display_(/*127.67*/proposal/*127.75*/.uuid.get()),format.raw/*127.86*/(""""  class="update-form"></input>                           
			 <input type="button" aling="right" value="Delete" data-uuid=""""),_display_(/*128.67*/proposal/*128.75*/.uuid.get()),format.raw/*128.86*/(""""  class="delete"></input>
			</p>	
""")))}),format.raw/*130.2*/("""
"""),format.raw/*131.1*/("""</table>
</div>
""")))}))
      }
    }
  }

  def render(proposals:List[Proposal]): play.twirl.api.HtmlFormat.Appendable = apply(proposals)

  def f:((List[Proposal]) => play.twirl.api.HtmlFormat.Appendable) = (proposals) => apply(proposals)

  def ref: this.type = this

}


}

/**/
object list extends list_Scope0.list
              /*
                  -- GENERATED --
                  DATE: Sat Oct 21 18:44:54 CEST 2017
                  SOURCE: /Users/fredrik/github/idea-ranking-web-application/app/views/list.scala.html
                  HASH: 670a1a213dc7f6937aaec0d5811e7ab8e40cca9f
                  MATRIX: 751->1|873->28|901->31|929->51|967->52|995->54|1058->90|1086->91|1117->96|1360->312|1388->313|1417->315|1463->333|1492->334|1521->336|1589->377|1617->378|1648->382|1695->401|1724->402|1754->405|1846->470|1874->471|1904->474|1962->504|1991->505|2069->556|2097->557|2126->559|2161->567|2190->568|2220->571|2486->810|2514->811|2543->813|2585->827|2614->828|2644->831|2755->915|2783->916|2812->918|2860->938|2889->939|2921->944|3056->1052|3084->1053|3113->1055|3161->1075|3190->1076|3219->1078|3267->1099|3295->1100|3324->1102|3378->1128|3407->1129|3436->1131|3487->1155|3515->1156|3544->1158|3588->1174|3617->1175|3647->1178|3758->1262|3786->1263|3815->1265|3865->1287|3894->1288|3926->1293|4061->1401|4089->1402|4118->1404|4168->1426|4197->1427|4226->1429|4274->1450|4302->1451|4331->1453|4387->1481|4416->1482|4445->1484|4496->1508|4524->1509|4554->1511|5090->2020|5150->2063|5191->2065|5225->2071|5279->2097|5297->2105|5324->2110|5387->2145|5405->2153|5439->2165|5469->2166|5513->2182|5531->2190|5558->2195|5588->2196|5631->2211|5649->2219|5676->2224|5707->2225|5756->2245|5775->2253|5804->2259|5837->2264|5928->2327|5946->2335|5979->2346|6124->2463|6142->2471|6175->2482|6322->2601|6340->2609|6373->2620|6526->2745|6544->2753|6577->2764|6645->2801|6674->2802
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|37->6|37->6|38->7|46->15|46->15|48->17|48->17|48->17|49->18|51->20|51->20|55->24|55->24|55->24|56->25|59->28|59->28|62->31|62->31|62->31|64->33|64->33|66->35|66->35|66->35|67->36|79->48|79->48|81->50|81->50|81->50|82->51|86->55|86->55|88->57|88->57|88->57|89->58|95->64|95->64|97->66|97->66|97->66|98->67|99->68|99->68|101->70|101->70|101->70|102->71|104->73|104->73|106->75|106->75|106->75|107->76|111->80|111->80|113->82|113->82|113->82|114->83|120->89|120->89|122->91|122->91|122->91|123->92|124->93|124->93|126->95|126->95|126->95|127->96|129->98|129->98|131->100|153->122|153->122|153->122|154->123|154->123|154->123|154->123|155->124|155->124|155->124|155->124|155->124|155->124|155->124|155->124|155->124|155->124|155->124|155->124|155->124|155->124|155->124|156->125|156->125|156->125|156->125|157->126|157->126|157->126|158->127|158->127|158->127|159->128|159->128|159->128|161->130|162->131
                  -- GENERATED --
              */
          