package com.yuri.ynweb.controller;

import com.github.pagehelper.Page;
import com.yuri.ynweb.pojo.WebCase;
import com.yuri.ynweb.pojo.WebCasePic;
import com.yuri.ynweb.service.CaseService;
import com.yuri.ynweb.utils.EnumResCode;
import com.yuri.ynweb.utils.ServletUtils;
import com.yuri.ynweb.utils.StringUtils;
import com.yuri.ynweb.vo.BaseJsonResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = {"/caseapi"})
public class CaseController {
    @Autowired
    private CaseService caseService;

    @RequestMapping(value = "/front/cases", method = RequestMethod.POST)
    public BaseJsonResultVO cases(@RequestParam(value = "pagesize") Integer pageSize, @RequestParam(value = "pageno") Integer pageNo) {
        Page casePage = caseService.findByPage(pageNo, pageSize);
        BaseJsonResultVO vo = new BaseJsonResultVO();
        return ServletUtils.pageValue(vo,casePage,pageNo);
    }

    @RequestMapping(value = "/backend/add", method = RequestMethod.POST)
    public BaseJsonResultVO addCase(@RequestParam(value = "picpc") String picPc, @RequestParam(value = "picmobile") String picMobile, @RequestParam(value = "orderid") Integer orderId,
                                    @RequestParam(value = "text") String text) {
        BaseJsonResultVO vo = new BaseJsonResultVO();

        WebCase webCase = new WebCase();
        webCase.setText(text);
        webCase.setCreateTime(new Date());
        webCase.setOrderId(orderId);
        webCase.setPicMobile(picMobile);
        webCase.setPicPc(picPc);

        if (caseService.insertCase(webCase) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("新增案例失败");
        return vo;
    }

    @RequestMapping(value = "/backend/edit", method = RequestMethod.POST)
    public BaseJsonResultVO editCase(@RequestParam(value = "id") Integer id, @RequestParam(value = "picpc", required = false) String picPc, @RequestParam(value = "picmobile", required = false) String picMobile, @RequestParam(value = "orderid", required = false) Integer orderId,
                                     @RequestParam(value = "text", required = false) String text) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebCase webCase = caseService.getCaseById(id);
        if (!StringUtils.isEmpty(picPc)) {
            webCase.setPicPc(picPc);
        }
        if (!StringUtils.isEmpty(picMobile)) {
            webCase.setPicMobile(picMobile);
        }
        if (!StringUtils.isEmpty(String.valueOf(orderId)) && orderId != null) {
            webCase.setOrderId(orderId);
        }
        if (!StringUtils.isEmpty(text)) {
            webCase.setText(text);
        }
        if (caseService.updateCaseById(webCase) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("更新案例失败");
        return vo;
    }

    @RequestMapping(value = "/backend/delete", method = RequestMethod.POST)
    public BaseJsonResultVO deleteCase(@RequestParam(value = "id") Integer id) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        if (caseService.deleteById(id) == 1 && caseService.deletePicsByCaseId(id) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("删除案例失败");
        return vo;
    }

    @RequestMapping(value = "/backend/case/{id}", method = RequestMethod.GET)
    public BaseJsonResultVO webCase(@PathVariable Integer id) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebCase webCase = caseService.getCaseById(id);
        vo.setData(webCase);
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setMessage("ok");
        return vo;
    }

    @RequestMapping(value = "/backend/cases", method = RequestMethod.POST)
    public BaseJsonResultVO productPage(@RequestParam(value = "pagesize") Integer pageSize, @RequestParam(value = "pageno") Integer pageNo) {
        Page<WebCase> casePage = caseService.findByPageBackend(pageNo, pageSize);
        BaseJsonResultVO vo = new BaseJsonResultVO();
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setData(casePage);
        vo.setMessage("ok");
        vo.setPageNo(pageNo);
        vo.setTotal(casePage.getTotal());
        return vo;
    }

    @RequestMapping(value = "/backend/casepics", method = RequestMethod.POST)
    public BaseJsonResultVO banners(@RequestParam(value = "caseid") Integer caseId) {
        List<WebCasePic> list = caseService.getPicsByCaseId(caseId);
        BaseJsonResultVO vo = new BaseJsonResultVO();
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setData(list);
        vo.setMessage("ok");
        return vo;
    }

    @RequestMapping(value = "/backend/deletecasepic", method = RequestMethod.POST)
    public BaseJsonResultVO deleteCasePic(@RequestParam(value = "id") Integer id) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        if (caseService.deletePicById(id) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("删除案例图片失败");
        return vo;
    }

    @RequestMapping(value = "/backend/editpic", method = RequestMethod.POST)
    public BaseJsonResultVO editCasePic(@RequestParam(value = "id") Integer id, @RequestParam(value = "picpc", required = false) String picPc, @RequestParam(value = "picmobile", required = false) String picMobile, @RequestParam(value = "orderid", required = false) Integer orderId,
        @RequestParam(value = "caseid") Integer caseId){

        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebCasePic casePic = caseService.getPicById(id);
        if (!StringUtils.isEmpty(picMobile)) {
            casePic.setPicMobile(picMobile);
        }
        if (!StringUtils.isEmpty(picPc)) {
            casePic.setPicPc(picPc);
        }
        if (!StringUtils.isEmpty(String.valueOf(caseId)) && caseId != null) {
            casePic.setCaseId(caseId);
        }
        if (!StringUtils.isEmpty(String.valueOf(orderId)) && orderId != null) {
            casePic.setOrderId(orderId);
        }

        if (caseService.updatePicById(casePic) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("更新案例图片失败");
        return vo;
    }

    @RequestMapping(value = "/backend/addpic", method = RequestMethod.POST)
    public BaseJsonResultVO addCaesPic(@RequestParam(value = "picpc") String picPc, @RequestParam(value = "picmobile") String picMobile, @RequestParam(value = "orderid") Integer orderId,
                                       @RequestParam(value = "caseid") Integer caseId) {

        BaseJsonResultVO vo = new BaseJsonResultVO();
        WebCasePic pic = new WebCasePic();
        pic.setPicPc(picPc);
        pic.setPicMobile(picMobile);
        pic.setOrderId(orderId);
        pic.setCaseId(caseId);
        pic.setCreateTime(new Date());

        if (caseService.insertCasePic(pic) == 1) {
            vo.setCode(EnumResCode.SUCCESSFUL.value());
            vo.setMessage("ok");
            return vo;
        }
        vo.setCode(EnumResCode.SERVER_ERROR.value());
        vo.setMessage("新增案例图片失败");
        return vo;
    }
}
