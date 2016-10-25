package com.baiye.netty.client

import io.netty.bootstrap.Bootstrap
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.channel.{ChannelInitializer, ChannelOption}
import io.netty.handler.codec.serialization.{ClassResolvers, ObjectDecoder, ObjectEncoder}

/**
  * Created by Baiye on 2016/9/23.
  */
class NettyClient(val port: Int, val host:String) extends Runnable{

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
                ch.pipeline().addLast(
                  new ObjectEncoder,
                  new ObjectDecoder(Integer.MAX_VALUE,ClassResolvers.cacheDisabled(this.getClass.getClassLoader)),
                  new NettyClientHandler()
                )
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
