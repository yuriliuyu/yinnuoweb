package com.yuri.ynweb.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yuri.ynweb.pojo.WebProductParam;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
@Data
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class WebProductDto {
    private Integer id;

    private String name;

    private String picPc;

    private String picMobile;

    private Integer orderId;

    private Integer categoryId;

    private Date createTime;

    private Date updateTime;

    private String description;

    private List<WebProductParam> params;


}