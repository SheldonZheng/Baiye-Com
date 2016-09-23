import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter}

/**
  * Created by Baiye on 2016/9/23.
  */
class EchoServerHandlerScala extends ChannelInboundHandlerAdapter
{
  override def channelRead(ctx: ChannelHandlerContext, msg: scala.Any): Unit =
  {
    println(msg);
  }

  override def channelRegistered(ctx: ChannelHandlerContext): Unit = super.channelRegistered(ctx)

  override def channelReadComplete(ctx: ChannelHandlerContext): Unit = super.channelReadComplete(ctx)
}
