package com.baiye.annotation;

import java.lang.annotation.*;

/**
* Created by Baiye on 2017/1/17.
        */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TaskMethod {

}
