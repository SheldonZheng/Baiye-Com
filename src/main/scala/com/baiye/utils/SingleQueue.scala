package com.baiye.utils

import java.util.concurrent.ConcurrentLinkedQueue

import com.baiye.entity.Entity

/**
  * Created by Baiye on 2016/9/24.
  */




object SingleQueue {

  val singleQueue = new SingleQueue


    def getInstance(): ConcurrentLinkedQueue[Entity] =
    {
      singleQueue.queue()
    }



}

class SingleQueue private
{
  val concurrentLinkedQueue = new ConcurrentLinkedQueue[Entity]()
  def queue(): ConcurrentLinkedQueue[Entity] =
  {
    concurrentLinkedQueue
  }
}