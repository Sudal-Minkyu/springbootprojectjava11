//package com.minkyu.springboot.main;
//
//import com.minkyu.springboot.account.Account;
//import com.minkyu.springboot.account.AccountService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.Optional;
//
///**
// * @author Minkyu
// * Date : 2022-07-15
// * Time :
// * Remark : Maincontroller 권한 없음
// */
//@Slf4j
//@Controller
//public class Maincontroller {
//
//    private final AccountService accountService;
//
//    @Autowired
//    public Maincontroller(AccountService accountService) {
//        this.accountService = accountService;
//    }
//
//    //메인화면
//    @RequestMapping(value={"/", "main"})
//    public String main(){
//        return "main";
//    }
//
//    // 로그인 성공시 세션에 데이터 정보저장
//    @RequestMapping("/loginActive")
//    public String loginActive(HttpServletRequest request){
//
//        //Security 로그인정보가져와서 세션에 저장
//        HttpSession session = request.getSession();
//
//        Optional<Account> optionalAccount = accountService.findByUserId(request.getUserPrincipal().getName());
//        if (optionalAccount.isPresent()) {
//            Account account = optionalAccount.get();
//
//            //userid 세션저장
//            session.setAttribute("userId", account.getUserId());
//            session.setAttribute("userName", account.getUserName());
//            session.setAttribute("role", account.getRole().getCode());
//
//            log.info("로그인 아이디 : "+session.getAttribute("userId"));
//            log.info("사용자명 : "+session.getAttribute("userName"));
//            log.info("사용자권한 : "+session.getAttribute("role"));
//        }
//
//        return "redirect:/main";
//    }
//
//    // 로그인 api
//    @RequestMapping("/login")
//    public String login(HttpServletRequest request){
//        String referrer = request.getHeader("Referer");
//        request.getSession().setAttribute("prevPage", referrer);
//        return "login";
//    }
//
//}
