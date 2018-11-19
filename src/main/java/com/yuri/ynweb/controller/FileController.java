package com.yuri.ynweb.controller;


import com.yuri.ynweb.utils.EnumResCode;
import com.yuri.ynweb.utils.FileUtils;
import com.yuri.ynweb.vo.BaseJsonResultVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping(value = {"/fileapi"})
public class FileController {

    @Value("${web.upload-path}")
    private String uploadPath;
    @Value("${web.server-url}")
    private String webServerUrl;


    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public BaseJsonResultVO uploadFile(@RequestParam MultipartFile file, HttpSession session, HttpServletRequest request, Map<Object, Object> map) {
        BaseJsonResultVO vo = new BaseJsonResultVO();
        map.put("webServer", webServerUrl);
        //String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
//        System.out.println("fileName-->" + fileName);
//        System.out.println("getContentType-->" + contentType);
        String result = null;
        try {
            result = FileUtils.uploadFile(file.getBytes(), uploadPath, webServerUrl, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        vo.setCode(EnumResCode.SUCCESSFUL.value());
        vo.setMessage("ok");
        vo.setData(result);
        return vo;
    }




}
