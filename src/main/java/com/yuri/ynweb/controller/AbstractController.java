package com.yuri.ynweb.controller;

import com.yuri.ynweb.pojo.ResponseResult;
import com.yuri.ynweb.utils.EnumResCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController {

    private static Logger logger = LoggerFactory.getLogger("web_log");

    private final static String SUCCESS_MSG = "ok";

    protected ResponseResult successJson(Object data) {
        ResponseResult result = new ResponseResult();
        result.setStatus(EnumResCode.SUCCESSFUL.value());
        result.setMsg(SUCCESS_MSG);
        result.setResult(data);
        return result;
    }

    protected ResponseResult successJson() throws Exception {
        return successJson(null);
    }

    protected ResponseResult errorJson(int status, String message) {
        ResponseResult result = new ResponseResult();
        result.setStatus(status);
        result.setMsg(message);
        return result;
    }
}
