//package com.minkyu.springboot.account;
//
//import com.broadwave.ecodeltacity.account.accountdtos.AccountReponse;
//import com.broadwave.ecodeltacity.account.accountdtos.AccountRole;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//
//import java.time.LocalDateTime;
//
//@TestPropertySource(locations="classpath:application-test.properties") // 테스트용 db 설정
//@AutoConfigureMockMvc
//@SpringBootTest
//class AccountServiceTest {
//
//    @Autowired
//    private AccountService accountService;
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Test
//    @DisplayName("사용자 저장 성공 테스트")
//    void save1() {
//
//        // given
//        Account request = Account.builder()
//                .userId("testUser")
//                .userPw("1234")
//                .userName("testName")
//                .userPhone("01011112222")
//                .role(AccountRole.ROLE_USER)
//                .insert_id("system")
//                .insert_date(LocalDateTime.now())
//                .build();
//
//        // when
//        accountService.save(request);
//
//        // than
//        Account account = accountRepository.findByUserName(request.getUserName());
//        assertEquals("testUser", account.getUserId());
//        assertEquals("testName", account.getUserName());
//    }
//
//    @Test
//    @DisplayName("사용자명 조회 성공 테스트")
//    void findByUserName1() {
//        // when
//        Account account = accountService.findByUserName("관리자");
//
//        // than
//        assertEquals("admin", account.getUserId());
//        assertEquals("관리자", account.getUserName());
//    }
//
//    @Test
//    @DisplayName("사용자ID로 조회 성공 테스트")
//    void findByUserId1() {
//        // when
//        AccountReponse accountReponse = accountService.findByUserId("admin");
//
//        // than
//        assertEquals("admin", accountReponse.getUserId());
//        assertEquals("관리자", accountReponse.getUserName());
//    }
//
//
//
//
//
//}