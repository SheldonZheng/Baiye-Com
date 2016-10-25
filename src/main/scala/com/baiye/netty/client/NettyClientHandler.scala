package com.baiye.netty.client

import com.baiye.entity.Entity
import com.baiye.utils.{SendExcuter, SingleQueue}
import io.netty.buffer.{ByteBuf, Unpooled}
import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter}
import io.netty.util.CharsetUtil

/**
  * Created by Baiye on 2016/9/23.
  */
class NettyClientHandler() extends ChannelInboundHandlerAdapter{

  val waitSendQueue = SingleQueue.getWaitSendQueue()

  val waitExcuteQueue = SingleQueue.getWaitExceuteQueue()

  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit =
  {
    cause.printStackTrace();
    ctx.close();
  }

  override def channelActive(ctx: ChannelHandlerContext): Unit = {
    //ctx.writeAndFlush(Unpooled.copiedBuffer("fdasfdsasdaf",CharsetUtil.UTF_8))
    /*var entity : Entity = new Entity("test","value1");
    ctx.writeAndFlush(entity)

    var str : String = "fdafffff"
    ctx.writeAndFlush(str);
    println(1)*/


    val sendQueueExcuterThread = new SendExcuter(ctx)
    new Thread(sendQueueExcuterThread).start()


   /* var before = System.currentTimeMillis()
    println(before)
    for(i <- 1 to 10000000)
      {
        var entityTest: Entity = new Entity("test2", i.toString)
        println(i)
        //  ctx.writeAndFlush(entityTest)
        //  waitSendQueue.put(entityTest)
      }

    var after = System.currentTimeMillis()
    println(after)*/





   /* while(true)
      {
        println(5)
      //  var entity = waitSendQueue.take()

      }*/



  }


  override def channelRead(ctx: ChannelHandlerContext, msg: scala.Any): Unit =
  {

    if(msg.isInstanceOf[Entity])
      {
        var e = msg.asInstanceOf[Entity]
        waitExcuteQueue.put(e)
      }
    /*println(2)
    var in : Entity = msg.asInstanceOf[Entity]
    println(in.name)
    /*var in : ByteBuf = msg.asInstanceOf[ByteBuf]
    println("Client : " + in.toString(CharsetUtil.UTF_8))*/*/

    /*println(1)
    println(msg.asInstanceOf[Entity].name)*/

  /*  println(2)

    if(msg.isInstanceOf[Entity])
    {
      println(1)
      waitExcuteQueue.put(msg.asInstanceOf[Entity])
    }*/



  }




}
