package com.yuri.ynweb.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class WebProductParam {
    private Integer id;

    private Integer productId;

    private String parmName;

    private String parmValue;

    private Integer orderId;

    private Date createTime;

    private Date updateTime;


}