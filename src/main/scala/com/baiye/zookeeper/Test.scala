package com.baiye.zookeeper

import org.apache.zookeeper.ZooDefs.Ids
import org.apache.zookeeper.{CreateMode, WatchedEvent, Watcher, ZooKeeper}

/**
  * Created by Baiye on 2016/11/23.
  */
class Test extends Watcher{

  override def process(event: WatchedEvent): Unit =
  {
    println(event.getPath + event.getState + event.getType)
  }
}

object Test
{
  def main(args: Array[String]) {
    var zk: ZooKeeper = new ZooKeeper("192.168.15.98:2181",600,new Test)


    var data:Array[Byte] = "dsfafasddsfaasfd".getBytes();




    zk.create("/test1",data,Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT)


  }
}
