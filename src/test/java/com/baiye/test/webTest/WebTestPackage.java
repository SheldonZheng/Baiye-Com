package com.baiye.test.webTest;

import com.baiye.Main;
import com.baiye.test.TestPackage;
import com.baiye.test.helper.ClassTestHelper;
import com.baiye.test.taskTest.SimpleTaskLocalContainerTest;
import org.springframework.boot.SpringApplication;

/**
 * Created by Baiye on 2017/2/3.
 */
public class WebTestPackage implements TestPackage{

    public static void main(String[] args) {
        Main.main(args);
        TestPackage testPackage = new WebTestPackage();
        testPackage.runTests();
        System.exit(0);
    }


    @Override
    public void runTests() {
        ClassTestHelper.testClass(InterfaceTest.class);
    }
}
