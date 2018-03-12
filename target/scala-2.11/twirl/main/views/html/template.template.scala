
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object template extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="pt-BR" ng-app="moduleTemplate" ng-controller="controllerTemplate">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="icon" href='/assets/images/favicon.ico'>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="CIMTech">

	<title>Cadastro Pessoas</title>

	<link rel="stylesheet" href="assets/stylesheets/css/main.css">
	
	<link rel="stylesheet" media="screen" href='"""),_display_(/*14.47*/routes/*14.53*/.Assets.at("/stylesheets/vendor/bootstrap.css")),format.raw/*14.100*/("""'>
	<link rel="stylesheet" href='"""),_display_(/*15.32*/routes/*15.38*/.Assets.at("/stylesheets/vendor/font-awesome.min.css")),format.raw/*15.92*/("""'>
	
	<script>
	function validar(field) """),format.raw/*18.26*/("""{"""),format.raw/*18.27*/("""
		  """),format.raw/*19.5*/("""str = field.value;
		  if (str.length > 11) """),format.raw/*20.26*/("""{"""),format.raw/*20.27*/("""
		    """),format.raw/*21.7*/("""field.value = str.substring(0, str.length - 1);
		  """),format.raw/*22.5*/("""}"""),format.raw/*22.6*/("""
		"""),format.raw/*23.3*/("""}"""),format.raw/*23.4*/("""

		"""),format.raw/*25.3*/("""function numerico(evt) """),format.raw/*25.26*/("""{"""),format.raw/*25.27*/("""
		  """),format.raw/*26.5*/("""var key_code = evt.keyCode ? evt.keyCode : evt.charCode ? evt.charCode : evt.which ? evt.which : void 0;
		  if (key_code == 8 || key_code == 9 || key_code == 13 || key_code == 27 || key_code == 46) """),format.raw/*27.95*/("""{"""),format.raw/*27.96*/("""
		    """),format.raw/*28.7*/("""return true;
		  """),format.raw/*29.5*/("""}"""),format.raw/*29.6*/(""" """),format.raw/*29.7*/("""else if ((key_code >= 35) && (key_code <= 40)) """),format.raw/*29.54*/("""{"""),format.raw/*29.55*/("""
		    """),format.raw/*30.7*/("""return true
		  """),format.raw/*31.5*/("""}"""),format.raw/*31.6*/(""" """),format.raw/*31.7*/("""else if ((key_code >= 48) && (key_code <= 57)) """),format.raw/*31.54*/("""{"""),format.raw/*31.55*/("""
		    """),format.raw/*32.7*/("""return true
		  """),format.raw/*33.5*/("""}"""),format.raw/*33.6*/("""
		  """),format.raw/*34.5*/("""return false;
		"""),format.raw/*35.3*/("""}"""),format.raw/*35.4*/("""

	"""),format.raw/*37.2*/("""</script>
	
	
	<style>
	.template-alerta """),format.raw/*41.19*/("""{"""),format.raw/*41.20*/("""
	    """),format.raw/*42.6*/("""position: fixed;
	    z-index: 9999999;
	    padding: 20px;
	    border-radius: 5px 5px 5px 5px;
	    margin: -1.4em auto;
	    width: 60%;
	    text-align: center;
	    margin-left: 20%;
	"""),format.raw/*50.2*/("""}"""),format.raw/*50.3*/("""
	"""),format.raw/*51.2*/("""</style>

</head>

<body>

   	<section>
		<div id="divMain wrapper">
		<div class="template-alerta">
		   	<div directive-alerta-sistema-template></div>
		</div>
			<div ng-view></div>
		</div>
	</section>

	<section class="footer">
		<footer>
			<div class="row">
				<div class="col-md-12">
					<hr class = "line-rodape" />
					<div class ="col-md-6">
						<h6 style="text-align: center; color: #000;">
							Desenvolvido por: <b> Rafael Silvestrini Lima </b>- 2018
						</h6>
					</div>
					<div class = "col-md-3"></div>
					<div class = "col-md-3">
						<h6> <b> GT4W </b> </h6>
					</div>
				</div>
			</div>
		</footer>
	</section>
	
	<!-- angular -->
	<script src="assets/javascripts/vendor/angular.js"></script>
	<script src="assets/javascripts/vendor/angular-route.min.js"></script>
	<script src="assets/javascripts/vendor/angular-cookies.min.js"></script>
	<script src="/assets/javascripts/vendor/angular-translate.js"></script>
	<script src="assets/javascripts/vendor/angular-md5.js"></script>
	<script src="/assets/javascripts/vendor/i18n/angular-locale_pt-br.js"></script>
	
	<!-- jquery -->
	<script src="assets/javascripts/vendor/jquery-1.11.3.min.js"></script>

	<!-- jquery ui -->
	<script src="assets/javascripts/vendor/jquery-ui.min.js"></script>

	<!-- ui bootstrap -->
	<script src="assets/javascripts/vendor/ui-bootstrap-tpls-0.13.3.min.js"></script>
	<script src="assets/javascripts/vendor/bootstrap.min.js"></script>

	<!-- moment -->
	<script src="assets/javascripts/vendor/moment.min.js"></script>

	<!-- blockUI -->
	<script src="assets/javascripts/vendor/jquery.blockUI.min.js"></script>

	<!-- smart table -->
	<script type="text/javascript" src="assets/javascripts/vendor/smart-table.min.js"></script>



	<!-- Controllers -->
	<script src="assets/controller/templateController.js"></script>
	<script src="assets/controller/indexController.js"></script>


</body>
</html>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 11 17:37:13 BRT 2018
                  SOURCE: /home/rafael/Documentos/cadastro-pessoas/app/views/template.scala.html
                  HASH: ce6e623b136efc87a406fa37211cf5c72d696115
                  MATRIX: 801->0|1319->491|1334->497|1403->544|1464->578|1479->584|1554->638|1622->678|1651->679|1683->684|1755->728|1784->729|1818->736|1897->788|1925->789|1955->792|1983->793|2014->797|2065->820|2094->821|2126->826|2353->1025|2382->1026|2416->1033|2460->1050|2488->1051|2516->1052|2591->1099|2620->1100|2654->1107|2697->1123|2725->1124|2753->1125|2828->1172|2857->1173|2891->1180|2934->1196|2962->1197|2994->1202|3037->1218|3065->1219|3095->1222|3164->1263|3193->1264|3226->1270|3442->1459|3470->1460|3499->1462
                  LINES: 29->1|42->14|42->14|42->14|43->15|43->15|43->15|46->18|46->18|47->19|48->20|48->20|49->21|50->22|50->22|51->23|51->23|53->25|53->25|53->25|54->26|55->27|55->27|56->28|57->29|57->29|57->29|57->29|57->29|58->30|59->31|59->31|59->31|59->31|59->31|60->32|61->33|61->33|62->34|63->35|63->35|65->37|69->41|69->41|70->42|78->50|78->50|79->51
                  -- GENERATED --
              */
          