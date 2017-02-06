package com.baiye.common.helper;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by Baiye on 2017/2/6.
 */
public class ControllerHelper {
    public static String getRealPath(HttpServletRequest request,String path)
    {
        path = request.getServletContext().getRealPath(path);
        if(path.endsWith("/"))
            path = path.substring(0,path.length() - 1);

        File file = new File(path);
        if(!file.exists())
            file.mkdirs();
        return path;
    }
}
