package com.yuri.ynweb.dao;

import com.github.pagehelper.Page;
import com.yuri.ynweb.pojo.WebCooperation;

import java.util.List;

public interface WebCooperationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebCooperation record);

    WebCooperation selectByPrimaryKey(Integer id);

    List<WebCooperation> selectAll();

    int updateByPrimaryKey(WebCooperation record);

    Page getCooperationPage();

    Page<WebCooperation> getCooperationPageBackend();
}