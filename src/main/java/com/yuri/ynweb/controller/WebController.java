package com.yuri.ynweb.controller;


import com.yuri.ynweb.pojo.WebBanner;
import com.yuri.ynweb.service.WebService;
import com.yuri.ynweb.utils.EnumResCode;
import com.yuri.ynweb.utils.FileUtils;
import com.yuri.ynweb.vo.BaseJsonResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/web"})
public class WebController {

    private static final String SESSION_KEY_SYSTEM_USER = "SYSTEM_USER";
    @Autowired
    private WebService webService;
    @Value("${web.upload-path}")
    private String uploadPath;
    @Value("${web.server-url}")
    private String webServerUrl;


    @RequestMapping(value = {"/login"})
    public String login(Map<Object,Object> map){
        map.put("webServer", webServerUrl);
        return "login";
    }

    @RequestMapping(value = {"/loginVerify"})
    @ResponseBody
    public BaseJsonResultVO loginVerify(@RequestParam String userAccount, @RequestParam String password, HttpSession session, Map<Object, Object> map){
        map.put("webServer", webServerUrl);

        BaseJsonResultVO<Map<String, String>> jsonResultVO = new BaseJsonResultVO();

        if(!"admin".equals(userAccount) || !"admin".equals(password)){
            jsonResultVO.setMessage("账户错误");
            jsonResultVO.setCode(EnumResCode.SERVER_ERROR.value());
            return jsonResultVO;
        }

        session.setAttribute(SESSION_KEY_SYSTEM_USER, "admin");
        session.setMaxInactiveInterval(3600);

        jsonResultVO.setMessage("登录成功");
        jsonResultVO.setCode(EnumResCode.SUCCESSFUL.value());
        Map<String, String> cookieMap = new HashMap<>();
        cookieMap.put("userAccount", "admin");
        jsonResultVO.setData(cookieMap);
        return jsonResultVO;
    }


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Map<Object,Object> map,HttpSession session) {
        map.put("webServer", webServerUrl);
        //判断用户是否登陆，如果没有登陆，返回登录页面
        if (session == null || session.getAttribute(SESSION_KEY_SYSTEM_USER) == null) {
            return "redirect:login";
        }
        return "index";
    }

    @RequestMapping(value = "/banners", method = RequestMethod.GET)
    public String banners(Map<Object,Object> map,ModelMap resultMap){
        map.put("webServer", webServerUrl);
        List<WebBanner> banners = webService.getBanners();
        resultMap.addAttribute("banners", banners);
        return "banner/banners";
    }

    @RequestMapping(value = "/banner/add", method = RequestMethod.GET)
    public String addBanner(Map<Object,Object> map,ModelMap resultMap){
        map.put("webServer", webServerUrl);
        List<WebBanner> banners = webService.getBanners();
        resultMap.addAttribute("banners", banners);
        return "organizationDetail";
    }

    @RequestMapping(value = "/banner/detail/{bannerId}", method = RequestMethod.GET)
    public String bannerDetail(@PathVariable Integer bannerId, Map<Object,Object> map, ModelMap resultMap){
        map.put("webServer", webServerUrl);
        WebBanner banner = webService.getBannerById(bannerId);
        resultMap.addAttribute("banner", banner);
        return "banner/bannerDetail";
    }

    @RequestMapping(value = "/banner/save", method = RequestMethod.POST)
    public String bannerSave(WebBanner banner, Map<Object,Object> map, ModelMap resultMap){
        map.put("webServer", webServerUrl);
        System.out.println(banner);
        return "redirect:/web/banners";
    }

    @RequestMapping(value = "/banner/uploadPc", method = RequestMethod.POST)
    public String bannerUploadPc(@RequestParam Integer bannerId, @RequestParam MultipartFile picFile, HttpSession session, HttpServletRequest request, Map<Object, Object> map){
        map.put("webServer", webServerUrl);
        String contentType = picFile.getContentType();
        String fileName = picFile.getOriginalFilename();
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);
        try {
            FileUtils.uploadFile(picFile.getBytes(), uploadPath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/web/banner/detail/"+bannerId;
    }
}
