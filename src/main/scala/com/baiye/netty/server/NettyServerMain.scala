package com.baiye.netty.server

/**
  * Created by Baiye on 2016/9/23.
  */
object NettyServerMain
{
  def main(args: Array[String]) {
    var server = new NettyServer(9999)
    server.run()
  }
}
