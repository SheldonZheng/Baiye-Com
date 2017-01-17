package com.baiye.zookeeper

import org.apache.curator.framework.{CuratorFramework, CuratorFrameworkFactory}
import org.apache.curator.retry.RetryNTimes

/**
  * Created by Baiye on 2016/11/23.
  */

class Test
{

}
object Test {

  def main(args: Array[String]) {

    var client:CuratorFramework = CuratorFrameworkFactory.newClient("192.168.15.98:2181",new RetryNTimes(10,5000))

    client.start()

    println("started.")

    var data : String = "adsfadfdsafffff"

    client.create().creatingParentsIfNeeded().forPath("/zktest",data.getBytes())



  }
}
