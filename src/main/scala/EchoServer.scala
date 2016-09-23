import com.baiye.NettyTest.EchoServerHandler
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.{ChannelInitializer, ChannelOption, EventLoopGroup}
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.logging.{LogLevel, LoggingHandler}

/**
  * Created by Baiye on 2016/9/19.
  */
class EchoServer {

  def run(): Unit =
  {
    var bossGroup = new NioEventLoopGroup()
    var workerGroup = new NioEventLoopGroup()

    var b = new ServerBootstrap()

    try
    {
      b.group(bossGroup,workerGroup)
        .channel(classOf[NioServerSocketChannel])
        .handler(new LoggingHandler(LogLevel.INFO))
        .childHandler(new ChannelInitializer[SocketChannel]() {
          @throws[Exception]
          protected def initChannel(ch: SocketChannel) {
            ch.pipeline.addLast(new EchoServerHandler)
          }
        })

      var f = b.bind(9999).sync()

      f.channel().closeFuture().sync()
    }
    finally
    {
      bossGroup.shutdownGracefully()
      workerGroup.shutdownGracefully()
    }

  }

}

object EchoServerMain
{
  def main(args: Array[String]) {
    var server = new EchoServer
    server.run()
  }
}
