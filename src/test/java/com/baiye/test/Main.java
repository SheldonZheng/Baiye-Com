package com.baiye.test;

import com.baiye.container.Container;
import com.baiye.container.SchedulerTaskLocalContainer;
import com.baiye.container.SimpleTaskLocalContainer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Baiye on 28/01/2017.
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService executorService  = Executors.newFixedThreadPool(4);
        Container container = new SchedulerTaskLocalContainer("com.baiye.testPackage.Task");
        executorService.execute(container);
        container = new SimpleTaskLocalContainer("com.baiye.testPackage.Task");
        executorService.execute(container);
        executorService.shutdown();
    }
}
