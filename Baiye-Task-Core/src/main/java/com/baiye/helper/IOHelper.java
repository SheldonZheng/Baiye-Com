package com.baiye.helper;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Baiye on 2017/2/4.
 */
public class IOHelper {

    public static void writeFile(String fileName, byte[] bytes) throws IOException {
        if (fileName != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        }
    }
}
