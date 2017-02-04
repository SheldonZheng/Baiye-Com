package com.baiye.test;

import com.baiye.test.taskTest.SchedulerTaskLocalContainerTest;
import com.baiye.test.taskTest.SimpleTaskLocalContainerTest;
import com.baiye.test.helper.ClassTestHelper;
import com.baiye.test.taskTest.TaskTestPackage;
import com.baiye.test.webTest.WebTestPackage;

/**
 * Created by Baiye on 2017/1/19.
 */
public class MainTest {

    public static void main(String[] args) {
        TestPackage taskTestPackage = new TaskTestPackage();
        TestPackage webTestPackage = new WebTestPackage();
        taskTestPackage.runTests();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webTestPackage.runTests();
        System.exit(0);
    }



}
