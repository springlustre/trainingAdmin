package controllers

import com.google.inject.{Inject, Singleton}
import models.JsonProtocols
import models.dao.DataDAO
import org.slf4j.LoggerFactory
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by springlustre on 2016/5/15.
 */

@Singleton
class DataController@Inject()(
  val dataDAO:DataDAO
  ) extends Controller with JsonProtocols{

  private val logger = LoggerFactory.getLogger(this.getClass)
  private val pageSize=20  //每页显示的数量


  def getVoiceByUser(userId:Long)=Action.async{implicit request=>
    dataDAO.getVoiceByUser(userId).map{seq=>
      val data=seq.groupBy(_.createTime).map{res=>
        val row=res._2
        val time=res._1
        val times=row.length
        val right=row.filter(_.result==1).length
        val cost = row.map(_.cost).sum
        val info=row.map{t=>
          val result=if(t.result==1)"正确" else "错误"
          val reason = if(t.result==1) "无" else (if(t.reason==1) "操作错误" else "超时")
          Json.obj("playCnt"->(t.playCnt+1),"playIndex"->t.playIndex,"result"->result,
          "reason"->reason,"times"->t.tryTime,"cost"->t.cost
          )
        }
        Json.obj(
        "time"->time,
        "times"->times,
        "right"->right,
        "cost"->cost,
        "info"->info
        )
      }
      Ok(successResult(Json.obj("data"->data)))
    }
  }


   def getImageData(userId:Long)=Action.async{implicit request=>
     dataDAO.getImageByUser(userId).map{seq=>
       Ok(successResult(Json.obj("data"->seq)))
     }
   }

  def getTypingData(userId:Long)=Action.async{implicit request=>
    dataDAO.getTypingByUser(userId).map{seq=>
      val data=seq.groupBy(_.createTime).map{res=>
        val row=res._2
        val time=res._1
        val times=row.length
        val right=row.filter(_.result==1).length
        val cost = row.map(_.cost).sum
        val info=row.map{t=>
          val result=if(t.result==1)"正确" else "错误"
          val reason = if(t.result==1) "无" else (if(t.reason==1) "操作错误" else "超时")
          Json.obj("playCnt"->(t.playCnt+1),"playIndex"->t.playIndex,"result"->result,
            "reason"->reason,"cost"->t.cost
          )
        }
        Json.obj(
          "time"->time,
          "times"->times,
          "right"->right,
          "cost"->cost,
          "info"->info
        )
      }
      Ok(successResult(Json.obj("data"->data)))
    }
  }

  def getGameData(userId:Long)=Action.async{implicit request=>
    dataDAO.getGameByUser(userId).map{seq=>
      Ok(successResult(Json.obj("data"->seq)))
    }
  }




}
