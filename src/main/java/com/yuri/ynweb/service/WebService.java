package com.yuri.ynweb.service;

import com.yuri.ynweb.dao.WebCaseMapper;
import com.yuri.ynweb.dao.WebProductMapper;
import com.yuri.ynweb.dao.WebProductParamMapper;
import com.yuri.ynweb.pojo.WebCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebService {



    @Autowired
    private WebCaseMapper caseDao;

    @Autowired
    private WebProductMapper productDao;

    @Autowired
    private WebProductParamMapper productParamDao;



    public List<WebCase> getAnlis() {
        return caseDao.selectAll();
    }



//    public Page<WebProductDto> findByPage(Integer catId, Integer pageNo, Integer pageSize) {
//        PageHelper.startPage(pageNo, pageSize);
//        Page page = productDao.getProductPage(catId);
//        return page;
//    }


}
