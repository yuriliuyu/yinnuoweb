package com.yuri.ynweb.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class WebProductParam {
    private Integer id;

    private Integer productId;

    private String parmName;

    private String parmValue;

    private Integer orderId;

    private Date createTime;

    private Date updateTime;


}