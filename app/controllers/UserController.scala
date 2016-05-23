package controllers

import com.google.inject.{Inject, Singleton}
import models.JsonProtocols
import models.dao.UserDAO
import models.tables.SlickTables
import org.slf4j.LoggerFactory
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
 * Created by 王春泽 on 2016/4/5.
 */

@Singleton
class UserController @Inject()(
                              userDAO:UserDAO
                              )extends Controller with JsonProtocols{
  private val logger = LoggerFactory.getLogger(this.getClass)

  /**
   * 用户登录
   * @return
   */
  def userLogin=Action.async{implicit request=>
    request.body.asJson match{
      case Some(jsonData)=>
        val name=(jsonData \ "name").as[String]
        val password=(jsonData \ "password").as[String]
        userDAO.findUser(name).flatMap{
          case Some(exist)=>
            userDAO.checkLogin(name,password).map{
              case Some(user)=>
                val timestamp = System.currentTimeMillis()
                Ok(success).withSession(
                  SessionKey.userId -> user.id.toString,
                  SessionKey.username -> user.name
                )
              case None=>
                Ok(ErrorCode.passwordErr)
            }
          case None=>
            Future.successful(Ok(ErrorCode.userNotExist))
        }

      case None=>
        Future.successful(Ok(ErrorCode.requestAsJsonEmpty))
    }
  }

  def gerAllUser=Action.async{ implicit request=>
    userDAO.getAllUser().map{res=>
      Ok(successResult(Json.obj("data"->res)))
    }
  }















}
