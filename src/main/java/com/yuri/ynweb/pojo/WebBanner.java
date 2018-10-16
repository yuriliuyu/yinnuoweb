package com.yuri.ynweb.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class WebBanner {
    private Integer id;

    private String picPc;

    private String picMobile;

    private Integer orderId;

    private Date createTime;

    private Date updateTime;


}