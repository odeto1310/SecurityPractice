package com.cos.securityPractice.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //mustache를 사용할건데, templates에서 .html 형식을 이용해서 개발을 진행할거라,
    // .mustache 확장자를 찾는 경로 문제를 해결하기 위한 부분


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MustacheViewResolver resolver = new MustacheViewResolver();
        resolver.setCharset("UTF-8");
        resolver.setContentType("text/html; charset=UTF-8");
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");

        registry.viewResolver(resolver);
    }
}
