package com.baiye.test.helper;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Baiye on 2017/2/3.
 */
public class ClassTestHelper {

    public static void testClass(Class cls)
    {
        Result result = JUnitCore.runClasses(cls);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
