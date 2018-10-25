package com.yuri.ynweb.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuri.ynweb.dao.WebCooperationMapper;
import com.yuri.ynweb.dao.WebCooperationPicMapper;
import com.yuri.ynweb.pojo.WebCooperation;
import com.yuri.ynweb.pojo.WebCooperationPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CooperationService {
    @Autowired
    private WebCooperationMapper cooperationDao;
    @Autowired
    private WebCooperationPicMapper cooperationPicDao;

    public int insertCoPic(WebCooperationPic pic) {
        return cooperationPicDao.insert(pic);
    }

    public Page findByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page page = cooperationDao.getCooperationPage();
        return page;
    }

    public int insertCooperation(WebCooperation webCooperation) {
        return cooperationDao.insert(webCooperation);
    }

    public WebCooperation getCooperationById(Integer id) {
        return cooperationDao.selectByPrimaryKey(id);
    }

    public int updateCooperationById(WebCooperation cooperation) {
        return cooperationDao.updateByPrimaryKey(cooperation);
    }

    public int deleteById(Integer id) {
        return cooperationDao.deleteByPrimaryKey(id);
    }

    public int deletePicsByCoId(Integer coId) {
        return cooperationPicDao.deleteByCoId(coId);
    }

    public Page<WebCooperation> findByPageBackend(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<WebCooperation> page = cooperationDao.getCooperationPageBackend();
        return page;
    }

    public List<WebCooperationPic> getPicsByCoId(Integer coId) {
        return cooperationPicDao.getPicsByCoId(coId);
    }

    public int deletePicById(Integer id) {
        return cooperationPicDao.deleteByPrimaryKey(id);
    }

    public WebCooperationPic getPicById(Integer id) {
        return cooperationPicDao.selectByPrimaryKey(id);
    }

    public int updatePicById(WebCooperationPic coPic) {
        return cooperationPicDao.updateByPrimaryKey(coPic);
    }
}
