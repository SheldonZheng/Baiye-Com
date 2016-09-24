package com.baiye.netty.server

import io.netty.buffer.{ByteBuf, Unpooled}
import io.netty.channel.{ChannelFutureListener, ChannelHandlerContext, ChannelInboundHandlerAdapter}
import io.netty.util.CharsetUtil

/**
  * Created by Baiye on2016/9/23.
*/
class EchoServerHandlerScala extends ChannelInboundHandlerAdapter
{
  override def channelRead(ctx: ChannelHandlerContext, msg: scala.Any): Unit =
  {
    var in : ByteBuf =  msg.asInstanceOf[ByteBuf];
    println("Server : " + in.toString(CharsetUtil.UTF_8))
    ctx.write(in);
    ctx.flush();
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
    super.channelRegistered(ctx)
  }
}
