package com.baiye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Baiye on 01/02/2017.
 */

@Controller
public class SystemController {

    @RequestMapping("/healthCheck")
    @ResponseBody
    public String healthCheck(){
        return "ok";
    }
}
