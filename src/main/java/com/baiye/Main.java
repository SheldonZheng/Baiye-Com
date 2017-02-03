package com.baiye;


import com.baiye.common.helper.HttpHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by Baiye on 2017/1/17.
 */

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
        /*ExecutorService executorService  = Executors.newFixedThreadPool(4);
        Container container = new SchedulerTaskLocalContainer("com.baiye.test.Task");
        executorService.execute(container);
        container = new SimpleTaskLocalContainer("com.baiye.test.Task");
        executorService.execute(container);
        executorService.shutdown();*/
    }
}
