package com.baiye.utils

import java.util.concurrent.ConcurrentLinkedQueue

import com.baiye.entity.Entity

/**
  * Created by Baiye on 2016/9/24.
  */

class SingleQueue private
{
  def queue(): ConcurrentLinkedQueue[Entity] =
  {
    new ConcurrentLinkedQueue[Entity]()
  }
}


object SingleQueue {

  val singleQueue = new SingleQueue


    def getInstance(): ConcurrentLinkedQueue[Entity] =
    {
      singleQueue.queue()
    }


}
