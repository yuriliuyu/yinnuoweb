package com.yuri.ynweb.controller;

import com.yuri.ynweb.pojo.ResponseResult;
import com.yuri.ynweb.pojo.WebBanner;
import com.yuri.ynweb.pojo.WebCase;
import com.yuri.ynweb.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/api"})
public class ApiController extends AbstractController {

    @Autowired
    private WebService webService;

    @RequestMapping(value = {"/banners"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ResponseResult banners() {
        List<WebBanner> banners = webService.getBanners();
        return successJson(banners);
    }

    @RequestMapping(value = {"/cases"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ResponseResult cases() {
        List<WebCase> anlis = webService.getAnlis();
        return successJson(anlis);
    }


}