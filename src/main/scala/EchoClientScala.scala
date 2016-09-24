import io.netty.channel.nio.NioEventLoopGroup
import io.netty.bootstrap.Bootstrap
import io.netty.channel.socket.SocketChannel
import io.netty.channel.{ChannelInitializer, ChannelOption}
import io.netty.channel.socket.nio.NioSocketChannel

/**
  * Created by Baiye on 2016/9/23.
  */
class EchoClientScala(val port: Int,val host:String,val firstMessage:String = "1") {

  def run() : Unit =
  {
    var group = new NioEventLoopGroup();

    try
    {
      var b = new Bootstrap()

      b.group(group)
        .channel(classOf[NioSocketChannel])
        .option[java.lang.Boolean](ChannelOption.TCP_NODELAY,true)
          .handler(new ChannelInitializer[SocketChannel] {
            override def initChannel(ch: SocketChannel): Unit =
            {
                ch.pipeline().addLast(new EchoClientHandlerScala(firstMessage))
            }
          })

      var f = b.connect(host,port).sync();

      f.channel().closeFuture().sync();
    }
    finally
    {
      group.shutdownGracefully();
    }
  }

}
