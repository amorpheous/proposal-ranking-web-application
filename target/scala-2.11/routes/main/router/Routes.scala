
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/fredrik/github/idea-ranking-web-application/conf/routes
// @DATE:Sat Oct 21 18:44:54 CEST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:8
  CountController_0: controllers.CountController,
  // @LINE:10
  AsyncController_2: controllers.AsyncController,
  // @LINE:13
  Assets_4: controllers.Assets,
  // @LINE:16
  ProposalController_3: controllers.ProposalController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:8
    CountController_0: controllers.CountController,
    // @LINE:10
    AsyncController_2: controllers.AsyncController,
    // @LINE:13
    Assets_4: controllers.Assets,
    // @LINE:16
    ProposalController_3: controllers.ProposalController
  ) = this(errorHandler, HomeController_1, CountController_0, AsyncController_2, Assets_4, ProposalController_3, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, CountController_0, AsyncController_2, Assets_4, ProposalController_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """proposal/new""", """controllers.ProposalController.newProposal()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """proposal/""" + "$" + """id<[^/]+>/update""", """controllers.ProposalController.updateProposal(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """proposal/""" + "$" + """id<[^/]+>""", """controllers.ProposalController.get(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """proposal/""", """controllers.ProposalController.save()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """proposal/""", """controllers.ProposalController.update()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """proposal/""", """controllers.ProposalController.list(offset:java.lang.Integer ?= null, size:java.lang.Integer ?= null)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """proposal/""" + "$" + """id<[^/]+>""", """controllers.ProposalController.delete(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """proposal/""" + "$" + """id<[^/]+>/incRank""", """controllers.ProposalController.incRank(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """proposal/""" + "$" + """id<[^/]+>/decRank""", """controllers.ProposalController.decRank(id:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_CountController_count1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count1_invoker = createInvoker(
    CountController_0.count,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      """ An example controller showing how to use dependency injection""",
      this.prefix + """count"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AsyncController_message2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message2_invoker = createInvoker(
    AsyncController_2.message,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      """ An example controller showing how to write asynchronous code""",
      this.prefix + """message"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_ProposalController_newProposal4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("proposal/new")))
  )
  private[this] lazy val controllers_ProposalController_newProposal4_invoker = createInvoker(
    ProposalController_3.newProposal(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProposalController",
      "newProposal",
      Nil,
      "GET",
      """GET  / 						 controllers.ProposalController.index()""",
      this.prefix + """proposal/new"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ProposalController_updateProposal5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("proposal/"), DynamicPart("id", """[^/]+""",true), StaticPart("/update")))
  )
  private[this] lazy val controllers_ProposalController_updateProposal5_invoker = createInvoker(
    ProposalController_3.updateProposal(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProposalController",
      "updateProposal",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """proposal/""" + "$" + """id<[^/]+>/update"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_ProposalController_get6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("proposal/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProposalController_get6_invoker = createInvoker(
    ProposalController_3.get(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProposalController",
      "get",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """proposal/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_ProposalController_save7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("proposal/")))
  )
  private[this] lazy val controllers_ProposalController_save7_invoker = createInvoker(
    ProposalController_3.save(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProposalController",
      "save",
      Nil,
      "POST",
      """""",
      this.prefix + """proposal/"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_ProposalController_update8_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("proposal/")))
  )
  private[this] lazy val controllers_ProposalController_update8_invoker = createInvoker(
    ProposalController_3.update(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProposalController",
      "update",
      Nil,
      "PUT",
      """""",
      this.prefix + """proposal/"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_ProposalController_list9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("proposal/")))
  )
  private[this] lazy val controllers_ProposalController_list9_invoker = createInvoker(
    ProposalController_3.list(fakeValue[java.lang.Integer], fakeValue[java.lang.Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProposalController",
      "list",
      Seq(classOf[java.lang.Integer], classOf[java.lang.Integer]),
      "GET",
      """""",
      this.prefix + """proposal/"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_ProposalController_delete10_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("proposal/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProposalController_delete10_invoker = createInvoker(
    ProposalController_3.delete(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProposalController",
      "delete",
      Seq(classOf[String]),
      "DELETE",
      """""",
      this.prefix + """proposal/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_ProposalController_incRank11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("proposal/"), DynamicPart("id", """[^/]+""",true), StaticPart("/incRank")))
  )
  private[this] lazy val controllers_ProposalController_incRank11_invoker = createInvoker(
    ProposalController_3.incRank(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProposalController",
      "incRank",
      Seq(classOf[String]),
      "POST",
      """""",
      this.prefix + """proposal/""" + "$" + """id<[^/]+>/incRank"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_ProposalController_decRank12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("proposal/"), DynamicPart("id", """[^/]+""",true), StaticPart("/decRank")))
  )
  private[this] lazy val controllers_ProposalController_decRank12_invoker = createInvoker(
    ProposalController_3.decRank(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProposalController",
      "decRank",
      Seq(classOf[String]),
      "POST",
      """""",
      this.prefix + """proposal/""" + "$" + """id<[^/]+>/decRank"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:8
    case controllers_CountController_count1_route(params) =>
      call { 
        controllers_CountController_count1_invoker.call(CountController_0.count)
      }
  
    // @LINE:10
    case controllers_AsyncController_message2_route(params) =>
      call { 
        controllers_AsyncController_message2_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:13
    case controllers_Assets_versioned3_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:16
    case controllers_ProposalController_newProposal4_route(params) =>
      call { 
        controllers_ProposalController_newProposal4_invoker.call(ProposalController_3.newProposal())
      }
  
    // @LINE:17
    case controllers_ProposalController_updateProposal5_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProposalController_updateProposal5_invoker.call(ProposalController_3.updateProposal(id))
      }
  
    // @LINE:18
    case controllers_ProposalController_get6_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProposalController_get6_invoker.call(ProposalController_3.get(id))
      }
  
    // @LINE:19
    case controllers_ProposalController_save7_route(params) =>
      call { 
        controllers_ProposalController_save7_invoker.call(ProposalController_3.save())
      }
  
    // @LINE:20
    case controllers_ProposalController_update8_route(params) =>
      call { 
        controllers_ProposalController_update8_invoker.call(ProposalController_3.update())
      }
  
    // @LINE:21
    case controllers_ProposalController_list9_route(params) =>
      call(params.fromQuery[java.lang.Integer]("offset", Some(null)), params.fromQuery[java.lang.Integer]("size", Some(null))) { (offset, size) =>
        controllers_ProposalController_list9_invoker.call(ProposalController_3.list(offset, size))
      }
  
    // @LINE:22
    case controllers_ProposalController_delete10_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProposalController_delete10_invoker.call(ProposalController_3.delete(id))
      }
  
    // @LINE:23
    case controllers_ProposalController_incRank11_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProposalController_incRank11_invoker.call(ProposalController_3.incRank(id))
      }
  
    // @LINE:24
    case controllers_ProposalController_decRank12_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProposalController_decRank12_invoker.call(ProposalController_3.decRank(id))
      }
  }
}
