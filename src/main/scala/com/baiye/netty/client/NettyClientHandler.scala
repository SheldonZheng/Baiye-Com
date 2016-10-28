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




  }


  override def channelRead(ctx: ChannelHandlerContext, msg: scala.Any): Unit =
  {

    if(msg.isInstanceOf[Entity])
      {
        var e = msg.asInstanceOf[Entity]
        waitExcuteQueue.put(e)
      }



  }




}
