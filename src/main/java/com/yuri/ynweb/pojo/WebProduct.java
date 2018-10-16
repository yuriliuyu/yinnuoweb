package com.yuri.ynweb.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
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