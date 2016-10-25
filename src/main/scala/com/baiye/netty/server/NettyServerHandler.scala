package com.baiye.netty.server

import com.baiye.entity.Entity
import com.baiye.utils.SingleQueue
import io.netty.buffer.{ByteBuf, Unpooled}
import io.netty.channel.{ChannelFutureListener, ChannelHandlerContext, ChannelInboundHandlerAdapter}
import io.netty.util.CharsetUtil

/**
  * Created by Baiye on2016/9/23.
*/
class NettyServerHandler extends ChannelInboundHandlerAdapter
{

  val waitSendQueue = SingleQueue.getWaitSendQueue()

  val waitExcuteQueue = SingleQueue.getWaitExceuteQueue()

  var count = 0
  override def channelRead(ctx: ChannelHandlerContext, msg: scala.Any): Unit =
  {
 /*   var in : ByteBuf =  msg.asInstanceOf[ByteBuf];
    println("Server : " + in.toString(CharsetUtil.UTF_8))*/

    if(msg.isInstanceOf[Entity])
      {
        var in : Entity = msg.asInstanceOf[Entity]
        /*println(2)
        println(in.name)*/
        count += 1
        println(count)
       // ctx.writeAndFlush(in)


      }
    if(msg.isInstanceOf[String])
      {
        var in : String = msg.asInstanceOf[String]
        println(in)
        ctx.write(in)
        ctx.flush()
      }


  }

  override def channelReadComplete(ctx: ChannelHandlerContext): Unit =
  {
    ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE)
  }

  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit =
  {
    cause.printStackTrace()
    ctx.close()
  }

  override def channelRegistered(ctx: ChannelHandlerContext): Unit =
  {
    println("Connected")
   /* var entityTest : Entity = new Entity("test3","value1")
    waitSendQueue.put(entityTest)
    println(entityTest.name)
    ctx.writeAndFlush(entityTest)*/
   /* while(true)
    {
      println("Server send started")
     // var entity = waitSendQueue.take()

    }*/
    super.channelRegistered(ctx)
  }

  override def channelActive(ctx: ChannelHandlerContext): Unit =
  {


  }


}
