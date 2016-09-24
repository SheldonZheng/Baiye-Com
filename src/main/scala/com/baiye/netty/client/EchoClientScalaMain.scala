package com.baiye.netty.client

/**
  * Created by Baiye on 2016/9/23.
  */
object EchoClientScalaMain {

  def main(args: Array[String]) {
    var client = new EchoClientScala(9999,"127.0.0.1","afdssfdasfda")
    client.run()
  }

}
