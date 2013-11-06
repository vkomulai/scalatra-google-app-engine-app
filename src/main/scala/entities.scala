import highchair.datastore._
import java.util.Date
import org.joda.time.DateTime
import com.google.appengine.api.datastore.{Key, Text}

case class Person(key: Option[Key],
                  firstName: String,
                  middleName: Option[String],
                  lastName: String,
                  age: Int,
                  birthday: Date,
                  aliases: List[String]) extends Entity[Person]

object Person extends Kind[Person] with Async[Person] {
  val firstName = property[String]
  val middleName = property[Option[String]]
  val lastName = property[String]
  val age = property[Int]
  val birthday = property[Date]
  val aliases = property[List[String]]

  /* Test set. */
  val testSet = List(
    Person(None, "Erin", Some("Pate"), "Lewis", 31, new Date, Nil),
    Person(None, "Chris", Some("Aaron"), "Lewis", 29, new Date, Nil),
    Person(None, "Garrett", Some("Donald"), "Lewis", 60, new Date, List("Pop"))
  )
}


case class User(key: Option[Key],
                firstName: String,
                contactInfo: Option[Key],
                friends: List[Key]) extends Entity[User]

object User extends Kind[User] {
  val firstName = property[String]
  val contactInfo = property[Option[Key]]
  val friends = property[List[Key]]
}


case class ContactInfo(key: Option[Key],
                       email: String,
                       mobile: String) extends Entity[ContactInfo]

object ContactInfo extends Kind[ContactInfo] {
  val email = property[String]
  val mobile = property[String]
}


case class Note(key: Option[Key],
                title: String,
                details: Text,
                created: DateTime) extends Entity[Note]

object Note extends Kind[Note] {
  val title = property[String]
  val details = property[Text]
  val created = property[DateTime]
}