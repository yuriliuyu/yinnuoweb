package com.yuri.ynweb.dao;

import com.github.pagehelper.Page;
import com.yuri.ynweb.pojo.WebCase;

import java.util.List;

public interface WebCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebCase record);

    WebCase selectByPrimaryKey(Integer id);

    List<WebCase> selectAll();

    int updateByPrimaryKey(WebCase record);

    Page getCasePage();

    Page<WebCase> getCasePageBackend();
}