package com.yuri.ynweb.dao;

import com.yuri.ynweb.pojo.WebBanner;
import java.util.List;

public interface WebBannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebBanner record);

    WebBanner selectByPrimaryKey(Integer id);

    List<WebBanner> selectAll();

    int updateByPrimaryKey(WebBanner record);
}