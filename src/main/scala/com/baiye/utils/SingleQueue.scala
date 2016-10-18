package com.baiye.utils


import com.baiye.entity.Entity

import scala.actors.threadpool.LinkedBlockingQueue

/**
  * Created by Baiye on 2016/9/24.
  */
object SingleQueue {

  val singleQueue = new SingleQueue


    def getWaitExceuteQueue(): LinkedBlockingQueue[Entity] =
    {
      singleQueue.getWaitExceuteQueue()
    }

  def getWaitSendQueue() : LinkedBlockingQueue[Entity] =
  {
    singleQueue.getWaitSendQueue()
  }




}

class SingleQueue private
{
  val waitExceuteQueue : LinkedBlockingQueue[Entity] = new LinkedBlockingQueue[Entity]()

  val waitSendQueue : LinkedBlockingQueue[Entity] = new LinkedBlockingQueue[Entity]()

  def getWaitExceuteQueue(): LinkedBlockingQueue[Entity] =
  {
    waitExceuteQueue
  }

  def getWaitSendQueue() : LinkedBlockingQueue[Entity] =
  {
    waitSendQueue
  }
}