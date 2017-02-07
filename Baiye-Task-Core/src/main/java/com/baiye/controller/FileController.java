package com.baiye.controller;

import java.io.*;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Baiye on 2017/2/7.
 */

@Controller
public class FileController {

    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    //,produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    @RequestMapping(value = "/downloadJarFile",method = RequestMethod.GET)
    public void downloadJarFile(@RequestParam(value = "jarFilePath") String jarFilePath, HttpServletResponse response)
    {
        File jarFile = null;
        jarFile = new File(jarFilePath);
        if (jarFile.exists())
        {
            try {
                InputStream is = new FileInputStream(jarFile);
                response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
                response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(jarFile.getName(), "UTF-8"));
                IOUtils.copy(is,response.getOutputStream());
                response.flushBuffer();
            } catch (FileNotFoundException e) {
                logger.error("file to fileInputStream error!{}",e);
            } catch (IOException e) {
                logger.error("IOUtils.copy error!{}",e);
            }

        }
    }
}
