package com.yuri.ynweb.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckLoginInterceptor implements HandlerInterceptor {

    private static final String SESSION_KEY_SYSTEM_USER = "SYSTEM_USER";

    public static final String LOGIN_URL = "/web/login";

    private Logger logger = LoggerFactory.getLogger(CheckLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String user = (String) session.getAttribute(SESSION_KEY_SYSTEM_USER);
        logger.info("user:---" + user);
        String path = httpServletRequest.getRequestURI();

        if(user == null){
            httpServletResponse.sendRedirect(LOGIN_URL);
            logger.info("redirect");
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("afterHandle");
    }
}
