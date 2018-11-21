package com.yuri.ynweb.controller;


import com.yuri.ynweb.pojo.WebBanner;
import com.yuri.ynweb.service.BannerService;
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
@RequestMapping(value = {"/bannerapi"})
public class BannerController {

    private static Logger logger = LoggerFactory.getLogger("banner");
    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/front/banners", method = RequestMethod.GET)
    public BaseJsonResultVO banners() {
        List<WebBanner> list = bannerService.getBanners();
        BaseJsonResultVO vo = new BaseJsonResultVO();
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setData(list);
        vo.setMessage("ok");
        return vo;
    }

    @RequestMapping(value = "/backend/add", method = RequestMethod.POST)
    public BaseJsonResultVO addBanner(@RequestParam(value = "picpc") String picPc, @RequestParam(value = "picmobile") String picMobile, @RequestParam(value = "orderid") String orderId) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        if (!StringUtils.isNumeric(orderId)) {
            vo.setCode(EnumResCode.SERVER_ERROR.value());
            vo.setMessage("参数不正确");
            return vo;
        }
        WebBanner banner = new WebBanner();
        banner.setOrderId(Integer.valueOf(orderId));
        banner.setPicMobile(picMobile);
        banner.setPicPc(picPc);
        banner.setCreateTime(new Date());

        if (bannerService.insertBanner(banner) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("新增banner失败");
        return vo;
    }

    @RequestMapping(value = "/backend/edit", method = RequestMethod.POST)
    public BaseJsonResultVO editBanner(@RequestParam(value = "id") Integer id, @RequestParam(value = "picpc", required=false) String picPc, @RequestParam(value = "picmobile", required=false) String picMobile, @RequestParam(value = "orderid", required=false) Integer orderId) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebBanner banner =  bannerService.getBannerById(id);
        if(!StringUtils.isEmpty(picPc)){
            banner.setPicPc(picPc);
        }
        if(!StringUtils.isEmpty(picMobile)){
            banner.setPicMobile(picMobile);
        }
        if(!StringUtils.isEmpty(String.valueOf(orderId)) && orderId != null){
            banner.setOrderId(orderId);
        }
        if (bannerService.updateBannerById(banner) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("更新banner失败");
        return vo;
    }

    @RequestMapping(value = "/backend/delete", method = RequestMethod.POST)
    public BaseJsonResultVO deleteBanner(@RequestParam(value = "id") Integer id){
        BaseJsonResultVO vo = new BaseJsonResultVO();
        if (bannerService.deleteById(id) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("删除banner失败");
        return vo;
    }

    @RequestMapping(value = "/backend/banner/{id}", method = RequestMethod.GET)
    public BaseJsonResultVO banner(@PathVariable Integer id){
        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebBanner banner = bannerService.getBannerById(id);
        vo.setData(banner);
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setMessage("ok");
        return vo;
    }
}
