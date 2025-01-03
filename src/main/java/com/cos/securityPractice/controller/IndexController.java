package com.cos.securityPractice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //View를 리턴하겠다.
public class IndexController {

    //localhost:8080/
    @GetMapping({"","/"})
    public String index(){
        //mustache 기본폴더 src/main/resources
        //뷰 리졸버 설정 : templates(prefix), .mustache(suffix)로 설정되게 되어있음
        return "index"; // src/main/resources/templates/index.mustache를 찾을 것임
    }

    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    //스프링 시큐리티가 해당 주소를 낚아챈다!
    // -> SecurityConfig 파일 생성후 낚아채는것 비활성화
    @GetMapping("/login")
    public @ResponseBody String login(){
        return "login";
    }

    @GetMapping("/join")
    public @ResponseBody String join(){
        return "join";
    }

    @GetMapping("/joinProc")
    public @ResponseBody String joinProc(){
        return "회원가입 완료됨!";
    }
}
