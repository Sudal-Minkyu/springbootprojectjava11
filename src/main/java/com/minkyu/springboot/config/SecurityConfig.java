//package com.minkyu.springboot.config;
//
//import com.minkyu.springboot.handler.LoginFailureHandler;
//import com.minkyu.springboot.handler.LoginSuccessHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
///**
// * @author Minkyu
// * Date : 2022-07-15
// * Time :
// * Remark : 기본 시큐리티셋팅
// */
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
////                .csrf().disable() // csrf 인증을 하기위해 적용
//                .authorizeRequests()
////                ,"/assets/img/**"
//                .antMatchers("/","/js/**","/css/**","/login","/logout","/img/favicon.ico").permitAll()
//                .antMatchers("/admin/**","/api/account/**").hasRole("ADMIN")
//                .antMatchers("/franchise/**").hasAnyRole("ADMIN","USER")
//                .anyRequest()
//                .authenticated()
//
//                .and()
//                .formLogin() // 로그인하는 경우에 대해 설정
//                .loginPage("/login") // 로그인 페이지 URL 설정
//                .successHandler(successHandler()) // 로그인 성공 후 설정
//                .failureHandler(failureHandler()) // 로그인 실패시 설정
//                .and()
//
//                .logout() // 로그아웃 관련 처리
//                .logoutSuccessUrl("/login") // 로그아웃 성공 후 이동할 URL 설정
//                .deleteCookies("JSESSIONID") // 로그아웃 후 쿠기 삭제 설정
//                .invalidateHttpSession(true) // 세션 날리기
//        ;
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler successHandler() {
//        return new LoginSuccessHandler("/loginActive");
//    }
//
//    @Bean
//    public AuthenticationFailureHandler failureHandler() {
//        return new LoginFailureHandler();
//    }
//
//}
