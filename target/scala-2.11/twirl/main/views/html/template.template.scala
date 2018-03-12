
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
	
	/* Função que não permite o campo cpf exceder 11 caracteres */
	function validar(field) """),format.raw/*20.26*/("""{"""),format.raw/*20.27*/("""
		  """),format.raw/*21.5*/("""str = field.value;
		  if (str.length > 11) """),format.raw/*22.26*/("""{"""),format.raw/*22.27*/("""
		    """),format.raw/*23.7*/("""field.value = str.substring(0, str.length - 1);
		  """),format.raw/*24.5*/("""}"""),format.raw/*24.6*/("""
		"""),format.raw/*25.3*/("""}"""),format.raw/*25.4*/("""
	
	
		"""),format.raw/*28.3*/("""/* Função que restringe letras no campo */
		function numerico(evt) """),format.raw/*29.26*/("""{"""),format.raw/*29.27*/("""
		  """),format.raw/*30.5*/("""var key_code = evt.keyCode ? evt.keyCode : evt.charCode ? evt.charCode : evt.which ? evt.which : void 0;
		  if (key_code == 8 || key_code == 9 || key_code == 13 || key_code == 27 || key_code == 46) """),format.raw/*31.95*/("""{"""),format.raw/*31.96*/("""
		    """),format.raw/*32.7*/("""return true;
		  """),format.raw/*33.5*/("""}"""),format.raw/*33.6*/(""" """),format.raw/*33.7*/("""else if ((key_code >= 35) && (key_code <= 40)) """),format.raw/*33.54*/("""{"""),format.raw/*33.55*/("""
		    """),format.raw/*34.7*/("""return true
		  """),format.raw/*35.5*/("""}"""),format.raw/*35.6*/(""" """),format.raw/*35.7*/("""else if ((key_code >= 48) && (key_code <= 57)) """),format.raw/*35.54*/("""{"""),format.raw/*35.55*/("""
		    """),format.raw/*36.7*/("""return true
		  """),format.raw/*37.5*/("""}"""),format.raw/*37.6*/("""
		  """),format.raw/*38.5*/("""return false;
		"""),format.raw/*39.3*/("""}"""),format.raw/*39.4*/("""
	"""),format.raw/*40.2*/("""</script>
	
	
	<style>
	.template-alerta """),format.raw/*44.19*/("""{"""),format.raw/*44.20*/("""
	    """),format.raw/*45.6*/("""position: fixed;
	    z-index: 9999999;
	    padding: 20px;
	    border-radius: 5px 5px 5px 5px;
	    margin: -1.4em auto;
	    width: 60%;
	    text-align: center;
	    margin-left: 20%;
	"""),format.raw/*53.2*/("""}"""),format.raw/*53.3*/("""
	"""),format.raw/*54.2*/("""</style>

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
                  DATE: Mon Mar 12 16:44:47 BRT 2018
                  SOURCE: /home/rafael/Documentos/cadastro-pessoas/app/views/template.scala.html
                  HASH: 18d86ca6690d9fa0b5903978bf8901361f4724d0
                  MATRIX: 801->0|1319->491|1334->497|1403->544|1464->578|1479->584|1554->638|1688->744|1717->745|1749->750|1821->794|1850->795|1884->802|1963->854|1991->855|2021->858|2049->859|2083->866|2179->934|2208->935|2240->940|2467->1139|2496->1140|2530->1147|2574->1164|2602->1165|2630->1166|2705->1213|2734->1214|2768->1221|2811->1237|2839->1238|2867->1239|2942->1286|2971->1287|3005->1294|3048->1310|3076->1311|3108->1316|3151->1332|3179->1333|3208->1335|3277->1376|3306->1377|3339->1383|3555->1572|3583->1573|3612->1575
                  LINES: 29->1|42->14|42->14|42->14|43->15|43->15|43->15|48->20|48->20|49->21|50->22|50->22|51->23|52->24|52->24|53->25|53->25|56->28|57->29|57->29|58->30|59->31|59->31|60->32|61->33|61->33|61->33|61->33|61->33|62->34|63->35|63->35|63->35|63->35|63->35|64->36|65->37|65->37|66->38|67->39|67->39|68->40|72->44|72->44|73->45|81->53|81->53|82->54
                  -- GENERATED --
              */
          