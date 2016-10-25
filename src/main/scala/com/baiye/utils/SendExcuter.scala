package com.baiye.utils

import com.baiye.entity.Entity
import io.netty.channel.ChannelHandlerContext

/**
  * Created by Baiye on 2016/10/25.
  */
class SendExcuter(ctx : ChannelHandlerContext) extends Runnable{

  val waitSendQueue = SingleQueue.getWaitSendQueue()

  override def run(): Unit =
  {
    while(true)
      {
        var e : Entity = null
        e = waitSendQueue.take()
        ctx.writeAndFlush(e)
      }
  }
}
