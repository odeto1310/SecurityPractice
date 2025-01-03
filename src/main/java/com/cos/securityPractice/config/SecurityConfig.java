package com.cos.securityPractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
//@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록이 됨
public class SecurityConfig {
    //Spring Security 5.7 이상에서 WebSecurityConfigurerAdapter는 사용중단되고,
    //SecurityFilterChain이 권장됨
    //그래서 클래스의 @EnableWebSecurity 어노테이션도 더이상 사용하지 않는다..!

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 비활성화
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").authenticated()
                        .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )

                // 특정 경로(user, manager, admin의 경우 인증이 필요한데,
                // 인증되지 않은 사용자는 로그인 페이지로 리다이렉트되도록 만든 것임
                .formLogin(form -> form
                        .loginPage("/login") // 사용자 정의 로그인 페이지
                                .permitAll() // 로그인 페이지는 누구나 접근 가능
                );



        //옛날 코드
//        http.csrf().disable();
//        http.authorizeRequests()
//                .antMatchers("/user/**").authenticated()
//                .antMatchers("/manager/**").access("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')")
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .anyRequest().permitAll();
//
        return http.build();
    }


}
