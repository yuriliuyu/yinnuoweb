package com.yuri.ynweb.vo;


public class BaseJsonResultVO<ResultDataType> {

    //-1 失败，1 成功
    private Integer code;
    private String message;
    private ResultDataType data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultDataType getData() {
        return data;
    }

    public void setData(ResultDataType data) {
        this.data = data;
    }
}
