package com.baiye.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Baiye on 2017/3/5.
 */
@Data
@Builder
@AllArgsConstructor
public class JsonResult<T> implements Serializable{

    private String msg;

    private String code;

    private T t;

    public static JsonResult buildSuccessResult(Object data)
    {
        return new JsonResult("success","0",data);
    }

}
