package com.baiye.test;

import com.baiye.annotation.BaiyeTaskClass;
import com.baiye.annotation.BaiyeTaskMethod;

/**
 * Created by Baiye on 2017/1/17.
 */
@BaiyeTaskClass
public class TestTask {

    @BaiyeTaskMethod
    public void test()
    {
        System.out.println(1111);
    }
}
