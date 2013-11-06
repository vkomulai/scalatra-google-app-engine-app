import org.scalatra._

import com.google.appengine.api.datastore.{KeyFactory, Key}

import highchair.datastore._
import highchair.datastore.Connection.default

class ExampleServlet(dao: Dao) extends ScalatraServlet {
  def this() = this(Dao)

  get("/text") {
    <h1>Hello, appengine!</h1>
  }
  get("/") {
    <h1>Test!</h1>
  }
  get("/save") {
//    Person where (_.lastName === "Lewis") fetch() map Person.delete

    val chris = Person(None, "Chris", Some("Aaron"), "Lewis", 29, new java.util.Date, Nil)
    val saved = Person.put(chris)
    saved.key.getOrElse("Didn't save!")
    //dao.user
  }
  get("/load") {
    //    Person where (_.lastName === "Lewis") fetch() map Person.delete

//    val saved = Person where (_.lastName === "Lewis") fetch()
    val key = Person.keyFor(5629499534213120L)
    val saved = Person.get(key)
    saved
    //dao.user
  }
}


trait Dao {
  def user: String
}

object Dao extends Dao {
  def user = "mtkopone"
}
