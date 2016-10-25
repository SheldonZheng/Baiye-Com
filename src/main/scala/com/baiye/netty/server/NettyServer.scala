package com.baiye.netty.server

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel._
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.serialization.{ClassResolvers, ObjectDecoder, ObjectEncoder}
import io.netty.handler.logging.{LogLevel, LoggingHandler}

/**
  * Created by Baiye on 2016/9/19.
  */
class NettyServer(val port : Int) extends Runnable{

  def run(): Unit =
  {
    var bossGroup : EventLoopGroup = new NioEventLoopGroup()
    var workerGroup : EventLoopGroup = new NioEventLoopGroup()

    var b : ServerBootstrap = new ServerBootstrap()

    try
    {

      b.group(bossGroup,workerGroup)
        .channel(classOf[NioServerSocketChannel])
        .option[Integer](ChannelOption.SO_BACKLOG,100)
        .handler(new LoggingHandler(LogLevel.INFO))
        .childHandler(new ChannelInitializer[SocketChannel]() {
          @throws[Exception]
          override protected def initChannel(ch: SocketChannel) {
            ch.pipeline.addLast(
              new ObjectEncoder,
              new ObjectDecoder(Integer.MAX_VALUE,ClassResolvers.cacheDisabled(this.getClass.getClassLoader)),
              new NettyServerHandler
            )
          }
        })

      var f = b.bind(port).sync()

      f.channel().closeFuture().sync()
    }
    finally
    {
      bossGroup.shutdownGracefully()
      workerGroup.shutdownGracefully()
    }

  }

}





