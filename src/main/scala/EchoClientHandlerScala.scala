import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter}

/**
  * Created by Baiye on 2016/9/23.
  */
class EchoClientHandlerScala(var messgae:String) extends ChannelInboundHandlerAdapter{
  override def channelRead(ctx: ChannelHandlerContext, msg: scala.Any): Unit =
  {
    println(messgae)
  }

  override def channelReadComplete(ctx: ChannelHandlerContext): Unit =
  {
    ctx.flush()
  }

  override def channelActive(ctx: ChannelHandlerContext): Unit =
  {
    println(messgae)
    ctx.writeAndFlush(messgae)

  }

  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit =
  {
    println("ERROR!");
  }
}
