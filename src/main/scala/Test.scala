import com.baiye.entity.Entity
import com.baiye.utils.SingleQueue

/**
  * Created by Baiye on 9/11/16.
  */
object Test {
  def main(args: Array[String]): Unit = {
    var queue = SingleQueue.getWaitExceuteQueue()
    queue.add(new Entity("test"))


    var test = new Test2
    test.getQueue()


  }

  class Test2 {
    def getQueue(): Unit =
    {
      var queue = SingleQueue.getWaitExceuteQueue()
      println(queue.poll().name)
    }
  }
}

