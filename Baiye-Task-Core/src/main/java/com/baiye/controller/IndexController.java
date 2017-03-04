package com.baiye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Baiye on 2017/2/6.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index()
    {
        return "uploadJar";
    }
}
