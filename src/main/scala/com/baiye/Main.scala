package com.baiye

import com.baiye.netty.client.NettyClient
import com.baiye.netty.server.NettyServer

import scala.actors.threadpool.{ExecutorService, Executors}

/**
  * Created by Baiye on 2016/10/24.
  */
object Main {

  def main(args: Array[String]) {

    var executorService : ExecutorService  = Executors.newFixedThreadPool(4);

    var server : NettyServer = new NettyServer(9999)

    var client : NettyClient = new NettyClient(9999,"127.0.0.1")


    executorService.execute(server)
    executorService.execute(client)


  }

}
