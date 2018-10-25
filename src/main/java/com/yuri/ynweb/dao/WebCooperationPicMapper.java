package com.yuri.ynweb.dao;

import com.yuri.ynweb.pojo.WebCooperationPic;

import java.util.List;

public interface WebCooperationPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebCooperationPic record);

    WebCooperationPic selectByPrimaryKey(Integer id);

    List<WebCooperationPic> selectAll();

    int updateByPrimaryKey(WebCooperationPic record);

    int deleteByCoId(Integer coId);

    List<WebCooperationPic> getPicsByCoId(Integer coId);

}