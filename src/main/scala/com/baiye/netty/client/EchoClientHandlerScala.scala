package com.baiye.netty.client

import io.netty.buffer.{ByteBuf, Unpooled}
import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter}
import io.netty.util.CharsetUtil

/**
  * Created by Baiye on 2016/9/23.
  */
class EchoClientHandlerScala(var messgae:String) extends ChannelInboundHandlerAdapter{


  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit =
  {
    cause.printStackTrace();
    ctx.close();
  }

  override def channelActive(ctx: ChannelHandlerContext): Unit =
  {
    ctx.writeAndFlush(Unpooled.copiedBuffer("fdasfdsasdaf",CharsetUtil.UTF_8))
  }

  override def channelRead(ctx: ChannelHandlerContext, msg: scala.Any): Unit =
  {
    var in : ByteBuf = msg.asInstanceOf[ByteBuf]
    println("Client : " + in.toString(CharsetUtil.UTF_8))
  }

  override def channelReadComplete(ctx: ChannelHandlerContext): Unit = ctx.flush()

}
