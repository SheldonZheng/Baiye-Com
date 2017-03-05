package com.baiye.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Baiye on 2017/3/5.
 */
@Data
@Builder
public class JsonResult<T> {

    private String msg;

    private String code;

    private T t;

}
