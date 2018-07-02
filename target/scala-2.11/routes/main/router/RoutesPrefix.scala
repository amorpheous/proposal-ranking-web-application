
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/fredrik/github/idea-ranking-web-application/conf/routes
// @DATE:Sat Oct 21 18:44:54 CEST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
