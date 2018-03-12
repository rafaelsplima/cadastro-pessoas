// @SOURCE:/home/rafael/Documentos/cadastro-pessoas/conf/routes
// @HASH:5bcc6d0f015d7f8ddadbc5af3f0ca5ac0318afdd
// @DATE:Sun Mar 11 17:37:12 BRT 2018

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:5
// @LINE:4
package controllers {

// @LINE:5
// @LINE:4
class ReverseAssets {


// @LINE:5
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

// @LINE:4
def versioned(file:Asset): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
}
                        

}
                          

// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
class ReversePessoaController {


// @LINE:14
def cadastrarPessoa(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "pessoaController/cadastrarPessoa")
}
                        

// @LINE:13
def findAllPessoas(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "pessoaController/findAllPessoas")
}
                        

// @LINE:16
def editarPessoa(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "pessoaController/editarPessoa")
}
                        

// @LINE:15
def deletarPessoa(cpf:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "pessoaController/deletarPessoa/" + implicitly[PathBindable[Long]].unbind("cpf", cpf))
}
                        

// @LINE:10
// @LINE:9
// @LINE:8
def index(): Call = {
   () match {
// @LINE:8
case ()  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix)
                                         
   }
}
                                                

}
                          
}
                  


// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:5
// @LINE:4
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:5
// @LINE:4
class ReverseAssets {


// @LINE:5
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

// @LINE:4
def versioned : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.versioned",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
class ReversePessoaController {


// @LINE:14
def cadastrarPessoa : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PessoaController.cadastrarPessoa",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pessoaController/cadastrarPessoa"})
      }
   """
)
                        

// @LINE:13
def findAllPessoas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PessoaController.findAllPessoas",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pessoaController/findAllPessoas"})
      }
   """
)
                        

// @LINE:16
def editarPessoa : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PessoaController.editarPessoa",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pessoaController/editarPessoa"})
      }
   """
)
                        

// @LINE:15
def deletarPessoa : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PessoaController.deletarPessoa",
   """
      function(cpf) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pessoaController/deletarPessoa/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("cpf", cpf)})
      }
   """
)
                        

// @LINE:10
// @LINE:9
// @LINE:8
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PessoaController.index",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cadastropessoas"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cadastropessoas/"})
      }
      }
   """
)
                        

}
              
}
        


// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:5
// @LINE:4
package controllers.ref {


// @LINE:5
// @LINE:4
class ReverseAssets {


// @LINE:5
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      

// @LINE:4
def versioned(path:String, file:Asset): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.versioned(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[Asset]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
class ReversePessoaController {


// @LINE:14
def cadastrarPessoa(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PessoaController.cadastrarPessoa(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "cadastrarPessoa", Seq(), "POST", """""", _prefix + """pessoaController/cadastrarPessoa""")
)
                      

// @LINE:13
def findAllPessoas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PessoaController.findAllPessoas(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "findAllPessoas", Seq(), "GET", """Pessoas""", _prefix + """pessoaController/findAllPessoas""")
)
                      

// @LINE:16
def editarPessoa(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PessoaController.editarPessoa(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "editarPessoa", Seq(), "POST", """""", _prefix + """pessoaController/editarPessoa""")
)
                      

// @LINE:15
def deletarPessoa(cpf:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PessoaController.deletarPessoa(cpf), HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "deletarPessoa", Seq(classOf[Long]), "GET", """""", _prefix + """pessoaController/deletarPessoa/$cpf<[^/]+>""")
)
                      

// @LINE:8
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PessoaController.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PessoaController", "index", Seq(), "GET", """ Pagina Incial""", _prefix + """""")
)
                      

}
                          
}
        
    