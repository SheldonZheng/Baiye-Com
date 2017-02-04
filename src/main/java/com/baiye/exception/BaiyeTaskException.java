package com.baiye.exception;

/**
 * Created by Baiye on 2017/2/4.
 */
public class BaiyeTaskException extends RuntimeException{
    public BaiyeTaskException(Throwable cause) {
        super(cause);
    }

    public BaiyeTaskException(String message) {
        super(message);
    }

    public BaiyeTaskException(String message, Throwable cause) {
        super(message, cause);
    }
}
