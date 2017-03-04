package com.baiye.test.webTest;

import com.baiye.Bootstrap;
import com.baiye.test.TestPackage;
import com.baiye.test.helper.ClassTestHelper;

/**
 * Created by Baiye on 2017/2/3.
 */
public class WebTestPackage implements TestPackage{

    public static void main(String[] args) {
        TestPackage testPackage = new WebTestPackage();
        testPackage.runTests();
        System.exit(0);
    }


    @Override
    public void runTests() {
        Bootstrap.main(new String[]{});
        ClassTestHelper.testClass(InterfaceTest.class);
    }
}
