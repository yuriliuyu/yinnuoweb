package com.yuri.ynweb.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseResult {
    private int status;
    private String msg;
    private Object result;
}