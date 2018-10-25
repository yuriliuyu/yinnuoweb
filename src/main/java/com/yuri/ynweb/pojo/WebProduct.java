package com.yuri.ynweb.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class WebProduct {
    private Integer id;

    private String name;

    private String picPc;

    private String picMobile;

    private Integer orderId;

    private Integer categoryId;

    private Date createTime;

    private Date updateTime;

    private String description;


}