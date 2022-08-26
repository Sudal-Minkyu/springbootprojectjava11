//package com.minkyu.springboot.config;
//
//import com.minkyu.springboot.account.Account;
//import com.minkyu.springboot.account.AccountService;
//import com.minkyu.springboot.account.accountdtos.AccountRole;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
///**
// * @author Minkyu
// * Date : 2022-07-15
// * Time :
// * Remark : 최초 유저 생성
// */
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class AppRunner implements ApplicationRunner {
//
//    private final AccountService accountService;
//
//    @Override
//    public void run(ApplicationArguments args) {
//        //사용자저장
//        Account saveAccount = Account.builder()
//                .userId("admin")
//                .userName("관리자")
//                .userPw("123789")
//                .role(AccountRole.ROLE_ADMIN)
//                .insert_id("system")
//                .insert_date(LocalDateTime.now())
//                .build();
//        log.info("saveAccount : " + saveAccount);
//
//        Optional<Account> optionalAccount = accountService.findByUserId(saveAccount.getUserId());
//        if (optionalAccount.isPresent()) {
//            log.info("이미 존재하는 계정");
//        } else {
//            accountService.save(saveAccount);
//        }
//
//    }
//
//}