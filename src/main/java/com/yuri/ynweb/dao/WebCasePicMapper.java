package com.yuri.ynweb.dao;

import com.yuri.ynweb.pojo.WebCasePic;

import java.util.List;

public interface WebCasePicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebCasePic record);

    WebCasePic selectByPrimaryKey(Integer id);

    List<WebCasePic> selectAll();

    int updateByPrimaryKey(WebCasePic record);

    int deletePicsByCaseId(Integer caseId);

    List<WebCasePic> getListByCaseId(Integer caseId);
}