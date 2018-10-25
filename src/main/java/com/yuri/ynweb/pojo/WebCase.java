package com.yuri.ynweb.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class WebCase {
    private Integer id;

    private String picPc;

    private String picMobile;

    private Integer orderId;

    private Date createTime;

    private Date updateTime;

    private String text;


}