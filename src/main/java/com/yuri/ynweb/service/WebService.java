package com.yuri.ynweb.service;

import com.yuri.ynweb.dao.WebBannerMapper;
import com.yuri.ynweb.dao.WebCaseMapper;
import com.yuri.ynweb.pojo.WebBanner;
import com.yuri.ynweb.pojo.WebCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebService {

    @Autowired
    private WebBannerMapper bannerDao;

    @Autowired
    private WebCaseMapper caseDao;

    public List<WebBanner> getBanners() {
        return bannerDao.selectAll();
    }

    public List<WebCase> getAnlis(){
        return caseDao.selectAll();
    }

    public WebBanner getBannerById(Integer id){
        return bannerDao.selectByPrimaryKey(id);
    }
}
