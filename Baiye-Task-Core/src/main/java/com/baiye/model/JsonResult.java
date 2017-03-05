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

    private T data;

    public static JsonResult buildSuccessResult(Object data)
    {
        return JsonResult.builder()
                .msg("success")
                .code("0")
                .data(data)
                .build();
    }

    public static JsonResult buildErrorResult(Object data,String msg,String code)
    {
        return JsonResult.builder()
                .msg(msg)
                .code(code)
                .data(data)
                .build();
    }

    public static JsonResult buildErrorResult(Object data) {
        return JsonResult.builder()
                .msg("error")
                .code("1")
                .data(data)
                .build();
    }



}
