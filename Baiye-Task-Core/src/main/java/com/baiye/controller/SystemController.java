package com.baiye.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
