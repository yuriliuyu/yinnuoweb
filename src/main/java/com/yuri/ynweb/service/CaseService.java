package com.yuri.ynweb.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuri.ynweb.dao.WebCaseMapper;
import com.yuri.ynweb.dao.WebCasePicMapper;
import com.yuri.ynweb.pojo.WebCase;
import com.yuri.ynweb.pojo.WebCasePic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {

    @Autowired
    private WebCaseMapper caseDao;
    @Autowired
    private WebCasePicMapper casePicDao;

    public Page findByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page page = caseDao.getCasePage();
        return page;
    }

    public int insertCase(WebCase webCase){
        return caseDao.insert(webCase);
    }

    public WebCase getCaseById(Integer id){
        return caseDao.selectByPrimaryKey(id);
    }

    public int updateCaseById(WebCase webCase){
        return caseDao.updateByPrimaryKey(webCase);
    }

    public int deleteById(Integer id){
        return caseDao.deleteByPrimaryKey(id);
    }

    public int deletePicsByCaseId(Integer caseId){
        return casePicDao.deletePicsByCaseId(caseId);
    }

    public Page<WebCase> findByPageBackend(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<WebCase> page = caseDao.getCasePageBackend();
        return page;
    }

    public List<WebCasePic> getPicsByCaseId(Integer caseId) {
        return casePicDao.getListByCaseId(caseId);
    }

    public int deletePicById(Integer id) {
        return casePicDao.deleteByPrimaryKey(id);
    }

    public WebCasePic getPicById(Integer id) {
        return casePicDao.selectByPrimaryKey(id);
    }

    public int updatePicById(WebCasePic casePic) {
        return casePicDao.updateByPrimaryKey(casePic);
    }

    public int insertCasePic(WebCasePic pic) {
        return casePicDao.insert(pic);
    }
}
