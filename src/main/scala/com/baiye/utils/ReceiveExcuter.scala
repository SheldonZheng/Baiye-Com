package com.baiye.utils

import com.baiye.entity.Entity

/**
  * Created by Baiye on 2016/10/25.
  */
class ReceiveExcuter extends Runnable{

  val waitExcuteQueue = SingleQueue.getWaitExceuteQueue()
  override def run(): Unit =
  {
    while(true)
    {
      var e : Entity = null
      e = waitExcuteQueue.take()
      println(e.name)
    }
  }
}
