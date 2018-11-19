package com.yuri.ynweb.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyContextConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
        registry.addResourceHandler("/files/**").addResourceLocations(ResourceUtils.FILE_URL_PREFIX + "/usr/local/uploadFile/");
        //System.out.println("===================静态文件映射路径配置成功");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludes = new String[]{"/web/login", "/static/**", "/web/loginVerify", "/templates/**", "/files/**"};
        registry.addInterceptor(new CheckLoginInterceptor()).excludePathPatterns(excludes);
        //System.out.println("===================静态文件权限配置成功");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}