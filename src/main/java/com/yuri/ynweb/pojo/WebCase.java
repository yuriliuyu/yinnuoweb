package com.yuri.ynweb.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class WebCase {
    private Integer id;

    private String picPc;

    private String picMobile;

    private Integer orderId;

    private String picSmall1;

    private String picSmall2;

    private String picSmall3;

    private String picSmall4;

    private Date createTime;

    private Date updateTime;

    private String text;


}