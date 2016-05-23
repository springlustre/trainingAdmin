package models.dao

import com.google.inject.Inject
import models.tables.SlickTables
import org.slf4j.LoggerFactory
import play.api.db.slick.{HasDatabaseConfigProvider, DatabaseConfigProvider}
import slick.driver.JdbcProfile

/**
 * Created by springlustre on 2016/5/15.
 */
class DataDAO  @Inject()(
  protected val dbConfigProvider:DatabaseConfigProvider
  )extends HasDatabaseConfigProvider[JdbcProfile]{
  import slick.driver.MySQLDriver.api._
  private val log=LoggerFactory.getLogger(this.getClass)

  val voice=SlickTables.tVoice
  val image=SlickTables.tImage
  val typing=SlickTables.tTyping
  val game=SlickTables.tGame

  def getVoiceByUser(userId:Long)={
    db.run(voice.filter(_.userid===userId).result)
  }

  def getImageByUser(userId:Long)={
    db.run(image.filter(_.userid===userId).result)
  }

  def getTypingByUser(userId:Long)={
    db.run(typing.filter(_.userid===userId).result)
  }

  def getGameByUser(userId:Long)={
    db.run(game.filter(_.userid===userId).result)
  }

}
