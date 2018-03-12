// @SOURCE:/home/rafael/Documentos/cadastro-pessoas/conf/routes
// @HASH:5bcc6d0f015d7f8ddadbc5af3f0ca5ac0318afdd
// @DATE:Sun Mar 11 17:37:12 BRT 2018


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:4
private[this] lazy val controllers_Assets_versioned0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_versioned0_invoker = createInvoker(
controllers.Assets.versioned(fakeValue[String], fakeValue[Asset]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[Asset]),"GET", """""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:5
private[this] lazy val controllers_Assets_at1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:8
private[this] lazy val controllers_PessoaController_index2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_PessoaController_index2_invoker = createInvoker(
controllers.PessoaController.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "index", Nil,"GET", """ Pagina Incial""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_PessoaController_index3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cadastropessoas"))))
private[this] lazy val controllers_PessoaController_index3_invoker = createInvoker(
controllers.PessoaController.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "index", Nil,"GET", """""", Routes.prefix + """cadastropessoas"""))
        

// @LINE:10
private[this] lazy val controllers_PessoaController_index4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cadastropessoas/"))))
private[this] lazy val controllers_PessoaController_index4_invoker = createInvoker(
controllers.PessoaController.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "index", Nil,"GET", """""", Routes.prefix + """cadastropessoas/"""))
        

// @LINE:13
private[this] lazy val controllers_PessoaController_findAllPessoas5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pessoaController/findAllPessoas"))))
private[this] lazy val controllers_PessoaController_findAllPessoas5_invoker = createInvoker(
controllers.PessoaController.findAllPessoas(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "findAllPessoas", Nil,"GET", """Pessoas""", Routes.prefix + """pessoaController/findAllPessoas"""))
        

// @LINE:14
private[this] lazy val controllers_PessoaController_cadastrarPessoa6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pessoaController/cadastrarPessoa"))))
private[this] lazy val controllers_PessoaController_cadastrarPessoa6_invoker = createInvoker(
controllers.PessoaController.cadastrarPessoa(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "cadastrarPessoa", Nil,"POST", """""", Routes.prefix + """pessoaController/cadastrarPessoa"""))
        

// @LINE:15
private[this] lazy val controllers_PessoaController_deletarPessoa7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pessoaController/deletarPessoa/"),DynamicPart("cpf", """[^/]+""",true))))
private[this] lazy val controllers_PessoaController_deletarPessoa7_invoker = createInvoker(
controllers.PessoaController.deletarPessoa(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "deletarPessoa", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pessoaController/deletarPessoa/$cpf<[^/]+>"""))
        

// @LINE:16
private[this] lazy val controllers_PessoaController_editarPessoa8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pessoaController/editarPessoa"))))
private[this] lazy val controllers_PessoaController_editarPessoa8_invoker = createInvoker(
controllers.PessoaController.editarPessoa(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "editarPessoa", Nil,"POST", """""", Routes.prefix + """pessoaController/editarPessoa"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.versioned(path:String = "/public", file:Asset)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix,"""controllers.PessoaController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cadastropessoas""","""controllers.PessoaController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cadastropessoas/""","""controllers.PessoaController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pessoaController/findAllPessoas""","""controllers.PessoaController.findAllPessoas()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pessoaController/cadastrarPessoa""","""controllers.PessoaController.cadastrarPessoa()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pessoaController/deletarPessoa/$cpf<[^/]+>""","""controllers.PessoaController.deletarPessoa(cpf:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pessoaController/editarPessoa""","""controllers.PessoaController.editarPessoa()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:4
case controllers_Assets_versioned0_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned0_invoker.call(controllers.Assets.versioned(path, file))
   }
}
        

// @LINE:5
case controllers_Assets_at1_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:8
case controllers_PessoaController_index2_route(params) => {
   call { 
        controllers_PessoaController_index2_invoker.call(controllers.PessoaController.index())
   }
}
        

// @LINE:9
case controllers_PessoaController_index3_route(params) => {
   call { 
        controllers_PessoaController_index3_invoker.call(controllers.PessoaController.index())
   }
}
        

// @LINE:10
case controllers_PessoaController_index4_route(params) => {
   call { 
        controllers_PessoaController_index4_invoker.call(controllers.PessoaController.index())
   }
}
        

// @LINE:13
case controllers_PessoaController_findAllPessoas5_route(params) => {
   call { 
        controllers_PessoaController_findAllPessoas5_invoker.call(controllers.PessoaController.findAllPessoas())
   }
}
        

// @LINE:14
case controllers_PessoaController_cadastrarPessoa6_route(params) => {
   call { 
        controllers_PessoaController_cadastrarPessoa6_invoker.call(controllers.PessoaController.cadastrarPessoa())
   }
}
        

// @LINE:15
case controllers_PessoaController_deletarPessoa7_route(params) => {
   call(params.fromPath[Long]("cpf", None)) { (cpf) =>
        controllers_PessoaController_deletarPessoa7_invoker.call(controllers.PessoaController.deletarPessoa(cpf))
   }
}
        

// @LINE:16
case controllers_PessoaController_editarPessoa8_route(params) => {
   call { 
        controllers_PessoaController_editarPessoa8_invoker.call(controllers.PessoaController.editarPessoa())
   }
}
        
}

}
     