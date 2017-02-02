package com.baiye;

import com.baiye.container.Container;
import com.baiye.container.SchedulerTaskLocalContainer;
import com.baiye.container.SimpleTaskLocalContainer;
import com.baiye.controller.TestController;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Baiye on 2017/1/17.
 */
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(TestController.class,args);
        /*ExecutorService executorService  = Executors.newFixedThreadPool(4);
        Container container = new SchedulerTaskLocalContainer("com.baiye.test.Task");
        executorService.execute(container);
        container = new SimpleTaskLocalContainer("com.baiye.test.Task");
        executorService.execute(container);
        executorService.shutdown();*/
    }
}
