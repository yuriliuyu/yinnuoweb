package com.yuri.ynweb.dao;

import com.yuri.ynweb.pojo.WebProduct;
import java.util.List;

public interface WebProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebProduct record);

    WebProduct selectByPrimaryKey(Integer id);

    List<WebProduct> selectAll();

    int updateByPrimaryKey(WebProduct record);
}