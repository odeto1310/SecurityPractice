package com.cos.securityPractice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //View를 리턴하겠다.
public class IndexController {

    //localhost:8080/
    @GetMapping({"","/"})
    public String index(){
        //mustache 기본폴더 src/main/resources
        //뷰 리졸버 설정 : templates(prefix), .mustache(suffix)로 설정되게 되어있음
        return "index"; // src/main/resources/templates/index.mustache를 찾을 것임
    }
}
