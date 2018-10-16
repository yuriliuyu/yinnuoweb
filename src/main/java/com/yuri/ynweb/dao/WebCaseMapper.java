package com.yuri.ynweb.dao;

import com.yuri.ynweb.pojo.WebCase;
import java.util.List;

public interface WebCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebCase record);

    WebCase selectByPrimaryKey(Integer id);

    List<WebCase> selectAll();

    int updateByPrimaryKey(WebCase record);
}