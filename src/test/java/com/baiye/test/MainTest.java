package com.baiye.test;

import com.baiye.test.Task.SimpleLocalContainerTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Baiye on 2017/1/19.
 */
public class MainTest {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SimpleLocalContainerTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
