package com.baiye.controller;

import com.baiye.common.helper.ControllerHelper;
import com.baiye.exception.BaiyeTaskException;
import com.baiye.helper.IOHelper;
import com.baiye.service.TaskService;
import com.baiye.single.SingleMapEnum;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

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
