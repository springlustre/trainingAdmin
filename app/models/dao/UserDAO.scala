package models.dao

import com.google.inject.{Inject, Singleton}
import models.tables.SlickTables
import org.slf4j.LoggerFactory
import play.api.db.slick.{HasDatabaseConfigProvider, DatabaseConfigProvider}
import slick.driver.JdbcProfile

/**
 * Created by 王春泽 on 2016/4/5.
 */
@Singleton
class UserDAO @Inject()(
                       protected val dbConfigProvider:DatabaseConfigProvider
                       )extends HasDatabaseConfigProvider[JdbcProfile] {
  import slick.driver.MySQLDriver.api._
  private val log=LoggerFactory.getLogger(this.getClass)
  private val admin=SlickTables.tAdmin
  private val user =SlickTables.tUser

  def getAllUser()={
    db.run(user.result)
  }

  /**
   * 根据登录输入查找用户
   * @param login
   * @return
   */
  def findUser(login:String)={
    db.run(admin.filter(t=>t.name===login).result.headOption)
  }


  /**
   * 验证用户登录
   * @param login
   * @param password
   * @return
   */
  def checkLogin(login:String,password:String)={
    db.run(admin.filter(t=>(t.name===login)
                          &&(t.password===password)).result.headOption)
  }


  /**
   * 用户名注册
   * @param username
   * @param password
   * @return
   */
  def registerByUsername(username:String,password:String)={
    db.run(admin.map(t=>(t.name,t.password)).returning(admin.map(_.id))+=(username,password)).mapTo[Long]
  }

  /**
   * 根据id获取用户信息
   * @param userId
   * @return
   */
  def getUserById(userId:Long)={
    db.run(admin.filter(_.id===userId).result.headOption)
  }

  def modifyUserInfo(adminInfo:SlickTables.rAdmin)={
    db.run(admin.insertOrUpdate(adminInfo).asTry)
  }

}
