package com.yuri.ynweb.service;


import com.yuri.ynweb.dao.WebBannerMapper;
import com.yuri.ynweb.pojo.WebBanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    private WebBannerMapper bannerDao;

    public List<WebBanner> getBanners() {
        return bannerDao.selectAll();
    }
    public WebBanner getBannerById(Integer id) {
        return bannerDao.selectByPrimaryKey(id);
    }

    public Integer insertBanner(WebBanner banner){
        return bannerDao.insert(banner);
    }

    public Integer updateBannerById(WebBanner banner){
        return bannerDao.updateByPrimaryKey(banner);
    }

    public Integer deleteById(Integer id){
        return bannerDao.deleteByPrimaryKey(id);
    }

}
