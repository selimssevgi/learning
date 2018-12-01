
// representing a row
final case class Message(
  sender:  String,
  content: String,
  id:      Long = 0L)

// tells slick how to map back and forth between db data and instances
final class MessageTable(tag: Tag) // tag is an implementation detail
      extends Table[Message](tag, "message") {

  def id        = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def sender    = column[String]("sender")
  def content   = column[String]("content")

  // allows us to query db and get back Messages instead of tuples
  def * = (sender, content, id) <>
          (Message.tupled, Message.unapply)
}

def freshTestData = Seq(
  Messages("Selim", "Whatsup?"),
  Messages("Dave", "Whatsup you?"),

)


// Queries
val messages = TableQuery[MessageTable]     // building the query
val SelimSays = messages.filter(_.sender === "Selim")  // still building

// run this to see what schema is going to be created
messages.schema.createStatements.mkString

val db = Database.forConfig("chapter01")

/// create the schema
val action: DBIO[Unit] = messages.schema.create
val future: Future[Unit] = db.run(action)
val result = Await.result(future, 2 seconds) // if experimenting, we can wait

// insert
val insert: DBIO[Option[Int]] = messages ++= freshTestData
val resIns: Future[Option[Int]] = db.run(insert) // number of inserted inserted

// select
val messagesAction: DBIO[Seq[Message]] = messages.result
val messagesFuture: Future[Seq[Message]] = db.run(messagesAction)
// messages.result.statements.mkString

val myMessagesAction: DBIO[Seq[Message]] = messages.filter(_.sender === "Selim").result.statements.mkString

// single insert
val singleMsg = Message("Selim", "How are u doing?")
val singleAct = messages += singleMsg
val singleFut = db.run(singleAct)

