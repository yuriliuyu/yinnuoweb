package com.yuri.ynweb.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuri.ynweb.dao.WebProductMapper;
import com.yuri.ynweb.dao.WebProductParamMapper;
import com.yuri.ynweb.pojo.WebProduct;
import com.yuri.ynweb.pojo.WebProductParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private WebProductMapper productDao;
    @Autowired
    private WebProductParamMapper productParamDao;

    public WebProduct getProductById(Integer id) {
        return productDao.selectByPrimaryKey(id);
    }

    public Integer insertProduct(WebProduct product) {
        return productDao.insert(product);
    }

    public Integer updateProductById(WebProduct product) {
        return productDao.updateByPrimaryKey(product);
    }

    public Integer deleteById(Integer id) {
        return productDao.deleteByPrimaryKey(id);
    }

    public Page findByPage(Integer catId, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page page = productDao.getProductPage(catId);
        return page;
    }

    public Page<WebProduct> findByPageBackend(Integer catId, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<WebProduct> page = productDao.getProductPageBackend(catId);
        return page;
    }

    public Integer deleteParamsByProductId(Integer productId) {
        return productParamDao.deleteParamsByProductId(productId);
    }

    public List<WebProductParam> getParamsByProductId(Integer productId) {
        return productParamDao.getListByProductId(productId);
    }

    public int deleteParamById(Integer id) {
        return productParamDao.deleteByPrimaryKey(id);
    }

    public WebProductParam getproductParamById(Integer id) {
        return productParamDao.selectByPrimaryKey(id);
    }

    public int updateProductParamById(WebProductParam param) {
        return productParamDao.updateByPrimaryKey(param);
    }

    public int insertProductParam(WebProductParam param){
        return productParamDao.insert(param);
    }

}
