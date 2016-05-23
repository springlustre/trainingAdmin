package models

import java.io.Writer

import play.api.libs.json._
import models.tables.SlickTables._
/**
 * User: Taoz
 * Date: 8/18/2015
 * Time: 12:10 PM
 */
trait JsonProtocols {

  object ErrorCode {
    val signatureError = 1000101
    val jsonFormatError = 1000102
    val requestAsJsonEmpty = jsonResult(1000103, "receive empty request body")

    val userNotExist = jsonResult(1000201,"user does not exist!")
    val passwordErr  = jsonResult(1000202,"the password error!")
    val registerErr  = jsonResult(1000203,"user register failed!")
    val userNotLogin = jsonResult(1000204,"user does not login!")
    val userEditErr  = jsonResult(1000205,"edit the info failed!")
    val newsNotExist = jsonResult(1000301,"the news does not exist!")


    val commentCreateFailed=jsonResult(1000401,"create comments failed!")
  }



  def jsonResult(errorCode: Int, errorMsg: String) = {
    Json.obj("errCode" -> errorCode, "msg" -> errorMsg)
  }

  def jsonResult(errorCode: Int, errorMsg: String, data: JsObject) = {
    Json.obj("errCode" -> errorCode, "msg" -> errorMsg) ++ data
  }

  def successResult(data: JsObject) = success ++ data

  val success = jsonResult(0, "ok")

  implicit val rUser:Writes[rUser] = new Writes[rUser]{
    override def writes(obj:rUser):JsValue={
      Json.obj(
      "id"->obj.id,
      "name"->obj.name,
      "mobile"->obj.mobile,
      "email"->obj.email,
      "password"->obj.password,
      "sex"->obj.sex,
      "age"->obj.age,
      "address"->obj.address,
      "updateTime"->obj.updateTime
      )
    }
  }


  implicit val rImage:Writes[rImage] = new Writes[rImage]{
    override def writes(obj:rImage):JsValue={
      Json.obj(
        "id"->obj.id,
        "userid"->obj.userid,
        "createTime"->obj.createTime,
        "total"->obj.total,
        "rightResult"->obj.rightResult,
        "wrongResult"->obj.wrongResult,
        "costtime"->obj.costtime
      )
    }
  }


  implicit val rGame:Writes[rGame] = new Writes[rGame]{
    override def writes(obj:rGame):JsValue={
      Json.obj(
        "id"->obj.id,
        "userid"->obj.userid,
        "createTime"->obj.createTime,
        "total"->obj.totalCnt,
        "rightResult"->obj.rightResult,
        "gradeCnt"->obj.gradeCnt,
        "mark"->obj.mark
      )
    }
  }


}