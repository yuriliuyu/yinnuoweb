package com.yuri.ynweb.controller;


import com.github.pagehelper.Page;
import com.yuri.ynweb.pojo.WebProduct;
import com.yuri.ynweb.pojo.WebProductParam;
import com.yuri.ynweb.service.ProductService;
import com.yuri.ynweb.utils.EnumResCode;
import com.yuri.ynweb.utils.StringUtils;
import com.yuri.ynweb.vo.BaseJsonResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = {"/productapi"})
public class ProductController {

    private static Logger logger = LoggerFactory.getLogger("product");
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/front/products", method = RequestMethod.POST)
    public BaseJsonResultVO products(@RequestParam(value = "catid") Integer catId, @RequestParam(value = "pagesize") Integer pageSize, @RequestParam(value = "pageno") Integer pageNo) {
        Page productPage = productService.findByPage(catId, pageNo, pageSize);
        BaseJsonResultVO vo = new BaseJsonResultVO();
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setData(productPage);
        vo.setMessage("ok");
        vo.setPageNo(pageNo);
        vo.setTotal(productPage.getTotal());
        return vo;
    }


    @RequestMapping(value = "/backend/add", method = RequestMethod.POST)
    public BaseJsonResultVO addProduct(@RequestParam(value = "picpc") String picPc, @RequestParam(value = "picmobile") String picMobile, @RequestParam(value = "orderid") Integer orderId,
                                       @RequestParam(value = "name") String name, @RequestParam(value = "description") String description, @RequestParam(value = "categoryid") Integer categoryId) {
        BaseJsonResultVO vo = new BaseJsonResultVO();

        WebProduct product = new WebProduct();
        product.setCategoryId(categoryId);
        product.setCreateTime(new Date());
        product.setDescription(description);
        product.setName(name);
        product.setOrderId(orderId);
        product.setPicMobile(picMobile);
        product.setPicPc(picPc);

        if (productService.insertProduct(product) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("新增商品失败");
        return vo;
    }

    @RequestMapping(value = "/backend/edit", method = RequestMethod.POST)
    public BaseJsonResultVO editProduct(@RequestParam(value = "id") Integer id, @RequestParam(value = "picpc", required = false) String picPc, @RequestParam(value = "picmobile", required = false) String picMobile, @RequestParam(value = "orderid", required = false) Integer orderId,
                                        @RequestParam(value = "name", required = false) String name, @RequestParam(value = "description", required = false) String description, @RequestParam(value = "categoryid", required = false) Integer categoryId) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebProduct product = productService.getProductById(id);
        if (!StringUtils.isEmpty(picPc)) {
            product.setPicPc(picPc);
        }
        if (!StringUtils.isEmpty(picMobile)) {
            product.setPicMobile(picMobile);
        }
        if (!StringUtils.isEmpty(String.valueOf(orderId)) && orderId != null) {
            product.setOrderId(orderId);
        }
        if (!StringUtils.isEmpty(name)) {
            product.setName(name);
        }
        if (!StringUtils.isEmpty(description)) {
            product.setDescription(description);
        }
        if (!StringUtils.isEmpty(String.valueOf(categoryId)) && categoryId != null) {
            product.setCategoryId(categoryId);
        }
        if (productService.updateProductById(product) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("更新商品失败");
        return vo;
    }

    @RequestMapping(value = "/backend/delete", method = RequestMethod.POST)
    public BaseJsonResultVO deleteProduct(@RequestParam(value = "id") Integer id) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        try {
            productService.deleteById(id);
            productService.deleteParamsByProductId(id);
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        } catch (Exception e) {
            vo.setCode(EnumResCode.SERVER_ERROR.value());
            vo.setMessage("删除商品失败");
            return vo;
        }
    }

    @RequestMapping(value = "/backend/product/{id}", method = RequestMethod.GET)
    public BaseJsonResultVO banner(@PathVariable Integer id) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebProduct product = productService.getProductById(id);
        vo.setData(product);
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setMessage("ok");
        return vo;
    }

    @RequestMapping(value = "/backend/products", method = RequestMethod.POST)
    public BaseJsonResultVO productPage(@RequestParam(value = "catid") Integer catId, @RequestParam(value = "pagesize") Integer pageSize, @RequestParam(value = "pageno") Integer pageNo) {
        Page<WebProduct> productPage = productService.findByPageBackend(catId, pageNo, pageSize);
        BaseJsonResultVO vo = new BaseJsonResultVO();
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setData(productPage);
        vo.setMessage("ok");
        vo.setPageNo(pageNo);
        vo.setTotal(productPage.getTotal());
        return vo;
    }

    @RequestMapping(value = "/backend/params", method = RequestMethod.POST)
    public BaseJsonResultVO banners(@RequestParam(value = "productid") Integer productId) {
        List<WebProductParam> list = productService.getParamsByProductId(productId);
        BaseJsonResultVO vo = new BaseJsonResultVO();
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setData(list);
        vo.setMessage("ok");
        return vo;
    }

    @RequestMapping(value = "/backend/deleteparam", method = RequestMethod.POST)
    public BaseJsonResultVO deleteProductParam(@RequestParam(value = "id") Integer id) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        if (productService.deleteParamById(id) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("删除商品属性失败");
        return vo;
    }

    @RequestMapping(value = "/backend/editparam", method = RequestMethod.POST)
    public BaseJsonResultVO editProductParam(@RequestParam(value = "id") Integer id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "value", required = false) String value, @RequestParam(value = "orderid", required = false) Integer orderId) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebProductParam productParam = productService.getproductParamById(id);
        if (!StringUtils.isEmpty(name)) {
            productParam.setParmName(name);
        }
        if (!StringUtils.isEmpty(value)) {
            productParam.setParmValue(value);
        }
        if (!StringUtils.isEmpty(String.valueOf(orderId)) && orderId != null) {
            productParam.setOrderId(orderId);
        }

        if (productService.updateProductParamById(productParam) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("更新商品属性失败");
        return vo;
    }

    @RequestMapping(value = "/backend/addParam", method = RequestMethod.POST)
    public BaseJsonResultVO addProductParam(@RequestParam(value = "name") String name, @RequestParam(value = "value") String value, @RequestParam(value = "orderid") Integer orderId,
                                            @RequestParam(value = "productid") Integer productId) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        if(productService.getProductById(productId) != null){
            WebProductParam param = new WebProductParam();
            param.setParmValue(value);
            param.setParmName(name);
            param.setOrderId(orderId);
            param.setProductId(productId);
            param.setCreateTime(new Date());

            if (productService.insertProductParam(param) == 1) {
                vo.setCode(EnumResCode.SUCCESSFUL.value());
                vo.setMessage("ok");
                return vo;
            }
            vo.setCode(EnumResCode.SERVER_ERROR.value());
            vo.setMessage("新增商品属性失败");
            return vo;
        }else{
            vo.setCode(EnumResCode.SERVER_ERROR.value());
            vo.setMessage("无此商品");
            return vo;
        }

    }


}
