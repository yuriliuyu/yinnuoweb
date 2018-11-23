package com.yuri.ynweb.controller;

import com.github.pagehelper.Page;
import com.yuri.ynweb.pojo.WebCooperation;
import com.yuri.ynweb.pojo.WebCooperationPic;
import com.yuri.ynweb.service.CooperationService;
import com.yuri.ynweb.utils.EnumResCode;
import com.yuri.ynweb.utils.ServletUtils;
import com.yuri.ynweb.utils.StringUtils;
import com.yuri.ynweb.vo.BaseJsonResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = {"/cooperationapi"})
public class CooperationController {
    @Autowired
    private CooperationService coService;

    @RequestMapping(value = "/front/cooperations", method = RequestMethod.POST)
    public BaseJsonResultVO cooperations(@RequestParam(value = "pagesize") Integer pageSize, @RequestParam(value = "pageno") Integer pageNo) {
        Page cooperPage = coService.findByPage(pageNo, pageSize);
        BaseJsonResultVO vo = new BaseJsonResultVO();
        return ServletUtils.pageValue(vo, cooperPage, pageNo);
    }

    @RequestMapping(value = "/backend/add", method = RequestMethod.POST)
    public BaseJsonResultVO addCooperation(@RequestParam(value = "picpc") String picPc, @RequestParam(value = "picmobile") String picMobile, @RequestParam(value = "orderid") Integer orderId,
                                           @RequestParam(value = "text") String text) {
        BaseJsonResultVO vo = new BaseJsonResultVO();

        WebCooperation cooperation = new WebCooperation();
        cooperation.setText(text);
        cooperation.setCreateTime(new Date());
        cooperation.setOrderId(orderId);
        cooperation.setPicMobile(picMobile);
        cooperation.setPicPc(picPc);

        if (coService.insertCooperation(cooperation) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("新增合作失败");
        return vo;
    }

    @RequestMapping(value = "/backend/edit", method = RequestMethod.POST)
    public BaseJsonResultVO editCooperation(@RequestParam(value = "id") Integer id, @RequestParam(value = "picpc", required = false) String picPc, @RequestParam(value = "picmobile", required = false) String picMobile, @RequestParam(value = "orderid", required = false) Integer orderId,
                                            @RequestParam(value = "text", required = false) String text) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebCooperation cooperation = coService.getCooperationById(id);
        if (!StringUtils.isEmpty(picPc)) {
            cooperation.setPicPc(picPc);
        }
        if (!StringUtils.isEmpty(picMobile)) {
            cooperation.setPicMobile(picMobile);
        }
        if (!StringUtils.isEmpty(String.valueOf(orderId)) && orderId != null) {
            cooperation.setOrderId(orderId);
        }
        if (!StringUtils.isEmpty(text)) {
            cooperation.setText(text);
        }
        if (coService.updateCooperationById(cooperation) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("更新合作失败");
        return vo;
    }

    @RequestMapping(value = "/backend/delete", method = RequestMethod.POST)
    public BaseJsonResultVO deleteCooperation(@RequestParam(value = "id") Integer id) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        try {
            coService.deleteById(id);
            coService.deletePicsByCoId(id);
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        } catch (Exception e) {
            vo.setCode(EnumResCode.SERVER_ERROR.value());
            vo.setMessage("删除合作失败");
            return vo;
        }
    }

    @RequestMapping(value = "/backend/co/{id}", method = RequestMethod.GET)
    public BaseJsonResultVO webCooperation(@PathVariable Integer id) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebCooperation cooperation = coService.getCooperationById(id);
        vo.setData(cooperation);
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setMessage("ok");
        return vo;
    }

    @RequestMapping(value = "/backend/coopations", method = RequestMethod.POST)
    public BaseJsonResultVO cooperationPage(@RequestParam(value = "pagesize") Integer pageSize, @RequestParam(value = "pageno") Integer pageNo) {
        Page<WebCooperation> coPage = coService.findByPageBackend(pageNo, pageSize);
        BaseJsonResultVO vo = new BaseJsonResultVO();
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setData(coPage);
        vo.setMessage("ok");
        vo.setPageNo(pageNo);
        vo.setTotal(coPage.getTotal());
        return vo;
    }

    @RequestMapping(value = "/backend/copics", method = RequestMethod.POST)
    public BaseJsonResultVO coPics(@RequestParam(value = "coid") Integer coId) {
        List<WebCooperationPic> list = coService.getPicsByCoId(coId);
        BaseJsonResultVO vo = new BaseJsonResultVO();
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setData(list);
        vo.setMessage("ok");
        return vo;
    }

    @RequestMapping(value = "/backend/deletecopic", method = RequestMethod.POST)
    public BaseJsonResultVO deleteCoPic(@RequestParam(value = "id") Integer id) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        if (coService.deletePicById(id) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("删除合作图片失败");
        return vo;
    }

    @RequestMapping(value = "/backend/editpic", method = RequestMethod.POST)
    public BaseJsonResultVO editCoPic(@RequestParam(value = "id") Integer id, @RequestParam(value = "picpc", required = false) String picPc,
                                      @RequestParam(value = "picmobile", required = false) String picMobile, @RequestParam(value = "orderid", required = false) Integer orderId) {

        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebCooperationPic coPic = coService.getPicById(id);
        if (!StringUtils.isEmpty(picMobile)) {
            coPic.setPicMobile(picMobile);
        }
        if (!StringUtils.isEmpty(picPc)) {
            coPic.setPicPc(picPc);
        }

        if (!StringUtils.isEmpty(String.valueOf(orderId)) && orderId != null) {
            coPic.setOrderId(orderId);
        }

        if (coService.updatePicById(coPic) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("更新合作图片失败");
        return vo;
    }

    @RequestMapping(value = "/backend/addpic", method = RequestMethod.POST)
    public BaseJsonResultVO addCoPic(@RequestParam(value = "picpc") String picPc, @RequestParam(value = "picmobile") String picMobile, @RequestParam(value = "orderid") Integer orderId,
                                     @RequestParam(value = "coid") Integer coId) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        if(coService.getCooperationById(coId) != null){
            WebCooperationPic pic = new WebCooperationPic();
            pic.setPicPc(picPc);
            pic.setPicMobile(picMobile);
            pic.setOrderId(orderId);
            pic.setCoId(coId);
            pic.setCreateTime(new Date());

            if (coService.insertCoPic(pic) == 1) {
                vo.setCode(EnumResCode.SUCCESSFUL.value());
                vo.setMessage("ok");
                return vo;
            }
            vo.setCode(EnumResCode.SERVER_ERROR.value());
            vo.setMessage("新增合作图片失败");
            return vo;
        }else{
            vo.setCode(EnumResCode.SERVER_ERROR.value());
            vo.setMessage("无此合作项");
            return vo;
        }
    }

    @RequestMapping(value = "/backend/copic/{id}", method = RequestMethod.GET)
    public BaseJsonResultVO webCooperationPic(@PathVariable Integer id) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebCooperationPic cooperationPic = coService.getPicById(id);
        vo.setData(cooperationPic);
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setMessage("ok");
        return vo;
    }

}
