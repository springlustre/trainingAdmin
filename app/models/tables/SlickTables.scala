package models.tables

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object SlickTables extends {
  val profile = slick.driver.MySQLDriver
} with SlickTables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait SlickTables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(tAdmin.schema, tGame.schema, tImage.schema, tTyping.schema, tUser.schema, tVoice.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table tAdmin
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param password Database column password SqlType(VARCHAR), Length(255,true) */
  case class rAdmin(id: Long, name: String, password: String)
  /** GetResult implicit for fetching rAdmin objects using plain SQL queries */
  implicit def GetResultrAdmin(implicit e0: GR[Long], e1: GR[String]): GR[rAdmin] = GR{
    prs => import prs._
    rAdmin.tupled((<<[Long], <<[String], <<[String]))
  }
  /** Table description of table admin. Objects of this class serve as prototypes for rows in queries. */
  class tAdmin(_tableTag: Tag) extends Table[rAdmin](_tableTag, "admin") {
    def * = (id, name, password) <> (rAdmin.tupled, rAdmin.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(password)).shaped.<>({r=>import r._; _1.map(_=> rAdmin.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column password SqlType(VARCHAR), Length(255,true) */
    val password: Rep[String] = column[String]("password", O.Length(255,varying=true))
  }
  /** Collection-like TableQuery object for table tAdmin */
  lazy val tAdmin = new TableQuery(tag => new tAdmin(tag))

  /** Entity class storing rows of table tGame
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column userid SqlType(BIGINT), Default(0)
   *  @param createTime Database column create_time SqlType(BIGINT), Default(0)
   *  @param rightResult Database column right_result SqlType(INT), Default(0)
   *  @param totalCnt Database column total_cnt SqlType(INT), Default(0)
   *  @param gradeCnt Database column grade_cnt SqlType(INT), Default(0)
   *  @param mark Database column mark SqlType(INT), Default(0) */
  case class rGame(id: Long, userid: Long = 0L, createTime: Long = 0L, rightResult: Int = 0, totalCnt: Int = 0, gradeCnt: Int = 0, mark: Int = 0)
  /** GetResult implicit for fetching rGame objects using plain SQL queries */
  implicit def GetResultrGame(implicit e0: GR[Long], e1: GR[Int]): GR[rGame] = GR{
    prs => import prs._
    rGame.tupled((<<[Long], <<[Long], <<[Long], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table game. Objects of this class serve as prototypes for rows in queries. */
  class tGame(_tableTag: Tag) extends Table[rGame](_tableTag, "game") {
    def * = (id, userid, createTime, rightResult, totalCnt, gradeCnt, mark) <> (rGame.tupled, rGame.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userid), Rep.Some(createTime), Rep.Some(rightResult), Rep.Some(totalCnt), Rep.Some(gradeCnt), Rep.Some(mark)).shaped.<>({r=>import r._; _1.map(_=> rGame.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column userid SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("userid", O.Default(0L))
    /** Database column create_time SqlType(BIGINT), Default(0) */
    val createTime: Rep[Long] = column[Long]("create_time", O.Default(0L))
    /** Database column right_result SqlType(INT), Default(0) */
    val rightResult: Rep[Int] = column[Int]("right_result", O.Default(0))
    /** Database column total_cnt SqlType(INT), Default(0) */
    val totalCnt: Rep[Int] = column[Int]("total_cnt", O.Default(0))
    /** Database column grade_cnt SqlType(INT), Default(0) */
    val gradeCnt: Rep[Int] = column[Int]("grade_cnt", O.Default(0))
    /** Database column mark SqlType(INT), Default(0) */
    val mark: Rep[Int] = column[Int]("mark", O.Default(0))
  }
  /** Collection-like TableQuery object for table tGame */
  lazy val tGame = new TableQuery(tag => new tGame(tag))

  /** Entity class storing rows of table tImage
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column userid SqlType(BIGINT), Default(0)
   *  @param createTime Database column create_time SqlType(BIGINT), Default(0)
   *  @param total Database column total SqlType(INT), Default(0)
   *  @param rightResult Database column right_result SqlType(INT), Default(0)
   *  @param wrongResult Database column wrong_result SqlType(INT), Default(0)
   *  @param costtime Database column costtime SqlType(INT), Default(0) */
  case class rImage(id: Long, userid: Long = 0L, createTime: Long = 0L, total: Int = 0, rightResult: Int = 0, wrongResult: Int = 0, costtime: Int = 0)
  /** GetResult implicit for fetching rImage objects using plain SQL queries */
  implicit def GetResultrImage(implicit e0: GR[Long], e1: GR[Int]): GR[rImage] = GR{
    prs => import prs._
    rImage.tupled((<<[Long], <<[Long], <<[Long], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table image. Objects of this class serve as prototypes for rows in queries. */
  class tImage(_tableTag: Tag) extends Table[rImage](_tableTag, "image") {
    def * = (id, userid, createTime, total, rightResult, wrongResult, costtime) <> (rImage.tupled, rImage.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userid), Rep.Some(createTime), Rep.Some(total), Rep.Some(rightResult), Rep.Some(wrongResult), Rep.Some(costtime)).shaped.<>({r=>import r._; _1.map(_=> rImage.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column userid SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("userid", O.Default(0L))
    /** Database column create_time SqlType(BIGINT), Default(0) */
    val createTime: Rep[Long] = column[Long]("create_time", O.Default(0L))
    /** Database column total SqlType(INT), Default(0) */
    val total: Rep[Int] = column[Int]("total", O.Default(0))
    /** Database column right_result SqlType(INT), Default(0) */
    val rightResult: Rep[Int] = column[Int]("right_result", O.Default(0))
    /** Database column wrong_result SqlType(INT), Default(0) */
    val wrongResult: Rep[Int] = column[Int]("wrong_result", O.Default(0))
    /** Database column costtime SqlType(INT), Default(0) */
    val costtime: Rep[Int] = column[Int]("costtime", O.Default(0))
  }
  /** Collection-like TableQuery object for table tImage */
  lazy val tImage = new TableQuery(tag => new tImage(tag))

  /** Entity class storing rows of table tTyping
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column userid SqlType(BIGINT), Default(0)
   *  @param createTime Database column create_time SqlType(BIGINT), Default(0)
   *  @param playCnt Database column play_cnt SqlType(INT), Default(0)
   *  @param playIndex Database column play_index SqlType(INT), Default(0)
   *  @param result Database column result SqlType(INT), Default(0)
   *  @param reason Database column reason SqlType(INT), Default(0)
   *  @param cost Database column cost SqlType(INT), Default(0) */
  case class rTyping(id: Long, userid: Long = 0L, createTime: Long = 0L, playCnt: Int = 0, playIndex: Int = 0, result: Int = 0, reason: Int = 0, cost: Int = 0)
  /** GetResult implicit for fetching rTyping objects using plain SQL queries */
  implicit def GetResultrTyping(implicit e0: GR[Long], e1: GR[Int]): GR[rTyping] = GR{
    prs => import prs._
    rTyping.tupled((<<[Long], <<[Long], <<[Long], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table typing. Objects of this class serve as prototypes for rows in queries. */
  class tTyping(_tableTag: Tag) extends Table[rTyping](_tableTag, "typing") {
    def * = (id, userid, createTime, playCnt, playIndex, result, reason, cost) <> (rTyping.tupled, rTyping.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userid), Rep.Some(createTime), Rep.Some(playCnt), Rep.Some(playIndex), Rep.Some(result), Rep.Some(reason), Rep.Some(cost)).shaped.<>({r=>import r._; _1.map(_=> rTyping.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column userid SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("userid", O.Default(0L))
    /** Database column create_time SqlType(BIGINT), Default(0) */
    val createTime: Rep[Long] = column[Long]("create_time", O.Default(0L))
    /** Database column play_cnt SqlType(INT), Default(0) */
    val playCnt: Rep[Int] = column[Int]("play_cnt", O.Default(0))
    /** Database column play_index SqlType(INT), Default(0) */
    val playIndex: Rep[Int] = column[Int]("play_index", O.Default(0))
    /** Database column result SqlType(INT), Default(0) */
    val result: Rep[Int] = column[Int]("result", O.Default(0))
    /** Database column reason SqlType(INT), Default(0) */
    val reason: Rep[Int] = column[Int]("reason", O.Default(0))
    /** Database column cost SqlType(INT), Default(0) */
    val cost: Rep[Int] = column[Int]("cost", O.Default(0))
  }
  /** Collection-like TableQuery object for table tTyping */
  lazy val tTyping = new TableQuery(tag => new tTyping(tag))

  /** Entity class storing rows of table tUser
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default()
   *  @param mobile Database column mobile SqlType(VARCHAR), Length(255,true), Default()
   *  @param email Database column email SqlType(VARCHAR), Length(255,true), Default()
   *  @param password Database column password SqlType(VARCHAR), Length(255,true), Default()
   *  @param sex Database column sex SqlType(VARCHAR), Length(255,true), Default()
   *  @param age Database column age SqlType(INT), Default(0)
   *  @param address Database column address SqlType(VARCHAR), Length(255,true), Default()
   *  @param updateTime Database column update_time SqlType(BIGINT), Default(0) */
  case class rUser(id: Long, name: String = "", mobile: String = "", email: String = "", password: String = "", sex: String = "", age: Int = 0, address: String = "", updateTime: Long = 0L)
  /** GetResult implicit for fetching rUser objects using plain SQL queries */
  implicit def GetResultrUser(implicit e0: GR[Long], e1: GR[String], e2: GR[Int]): GR[rUser] = GR{
    prs => import prs._
    rUser.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[String], <<[Int], <<[String], <<[Long]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class tUser(_tableTag: Tag) extends Table[rUser](_tableTag, "user") {
    def * = (id, name, mobile, email, password, sex, age, address, updateTime) <> (rUser.tupled, rUser.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(mobile), Rep.Some(email), Rep.Some(password), Rep.Some(sex), Rep.Some(age), Rep.Some(address), Rep.Some(updateTime)).shaped.<>({r=>import r._; _1.map(_=> rUser.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true), Default() */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true), O.Default(""))
    /** Database column mobile SqlType(VARCHAR), Length(255,true), Default() */
    val mobile: Rep[String] = column[String]("mobile", O.Length(255,varying=true), O.Default(""))
    /** Database column email SqlType(VARCHAR), Length(255,true), Default() */
    val email: Rep[String] = column[String]("email", O.Length(255,varying=true), O.Default(""))
    /** Database column password SqlType(VARCHAR), Length(255,true), Default() */
    val password: Rep[String] = column[String]("password", O.Length(255,varying=true), O.Default(""))
    /** Database column sex SqlType(VARCHAR), Length(255,true), Default() */
    val sex: Rep[String] = column[String]("sex", O.Length(255,varying=true), O.Default(""))
    /** Database column age SqlType(INT), Default(0) */
    val age: Rep[Int] = column[Int]("age", O.Default(0))
    /** Database column address SqlType(VARCHAR), Length(255,true), Default() */
    val address: Rep[String] = column[String]("address", O.Length(255,varying=true), O.Default(""))
    /** Database column update_time SqlType(BIGINT), Default(0) */
    val updateTime: Rep[Long] = column[Long]("update_time", O.Default(0L))
  }
  /** Collection-like TableQuery object for table tUser */
  lazy val tUser = new TableQuery(tag => new tUser(tag))

  /** Entity class storing rows of table tVoice
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column userid SqlType(BIGINT), Default(0)
   *  @param createTime Database column create_time SqlType(BIGINT), Default(0)
   *  @param playCnt Database column play_cnt SqlType(INT), Default(0)
   *  @param playIndex Database column play_index SqlType(INT), Default(0)
   *  @param result Database column result SqlType(INT), Default(0)
   *  @param reason Database column reason SqlType(INT), Default(0)
   *  @param tryTime Database column try_time SqlType(INT), Default(0)
   *  @param cost Database column cost SqlType(INT), Default(0) */
  case class rVoice(id: Long, userid: Long = 0L, createTime: Long = 0L, playCnt: Int = 0, playIndex: Int = 0, result: Int = 0, reason: Int = 0, tryTime: Int = 0, cost: Int = 0)
  /** GetResult implicit for fetching rVoice objects using plain SQL queries */
  implicit def GetResultrVoice(implicit e0: GR[Long], e1: GR[Int]): GR[rVoice] = GR{
    prs => import prs._
    rVoice.tupled((<<[Long], <<[Long], <<[Long], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table voice. Objects of this class serve as prototypes for rows in queries. */
  class tVoice(_tableTag: Tag) extends Table[rVoice](_tableTag, "voice") {
    def * = (id, userid, createTime, playCnt, playIndex, result, reason, tryTime, cost) <> (rVoice.tupled, rVoice.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userid), Rep.Some(createTime), Rep.Some(playCnt), Rep.Some(playIndex), Rep.Some(result), Rep.Some(reason), Rep.Some(tryTime), Rep.Some(cost)).shaped.<>({r=>import r._; _1.map(_=> rVoice.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column userid SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("userid", O.Default(0L))
    /** Database column create_time SqlType(BIGINT), Default(0) */
    val createTime: Rep[Long] = column[Long]("create_time", O.Default(0L))
    /** Database column play_cnt SqlType(INT), Default(0) */
    val playCnt: Rep[Int] = column[Int]("play_cnt", O.Default(0))
    /** Database column play_index SqlType(INT), Default(0) */
    val playIndex: Rep[Int] = column[Int]("play_index", O.Default(0))
    /** Database column result SqlType(INT), Default(0) */
    val result: Rep[Int] = column[Int]("result", O.Default(0))
    /** Database column reason SqlType(INT), Default(0) */
    val reason: Rep[Int] = column[Int]("reason", O.Default(0))
    /** Database column try_time SqlType(INT), Default(0) */
    val tryTime: Rep[Int] = column[Int]("try_time", O.Default(0))
    /** Database column cost SqlType(INT), Default(0) */
    val cost: Rep[Int] = column[Int]("cost", O.Default(0))
  }
  /** Collection-like TableQuery object for table tVoice */
  lazy val tVoice = new TableQuery(tag => new tVoice(tag))
}
