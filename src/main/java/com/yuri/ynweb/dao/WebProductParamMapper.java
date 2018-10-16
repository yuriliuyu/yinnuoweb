package com.yuri.ynweb.dao;

import com.yuri.ynweb.pojo.WebProductParam;
import java.util.List;

public interface WebProductParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebProductParam record);

    WebProductParam selectByPrimaryKey(Integer id);

    List<WebProductParam> selectAll();

    int updateByPrimaryKey(WebProductParam record);
}