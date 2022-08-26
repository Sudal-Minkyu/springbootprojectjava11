//package com.minkyu.springboot.account;
//
//import com.minkyu.springboot.common.AjaxResponse;
//import com.minkyu.springboot.common.ResponseErrorCode;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.time.LocalDateTime;
//import java.util.Map;
//import java.util.Optional;
//
///**
// * @author Minkyu
// * Date : 2022-07-22
// * Time :
// * Remark : Account RestController 관리자권한
// */
//@Slf4j
//@RestController
//@RequestMapping("/api/account")
//public class AccountRestController {
//
//    private final ModelMapper modelMapper;
//    private final AccountService accountService;
//
//    @Autowired
//    public AccountRestController(AccountService accountService, ModelMapper modelMapper) {
//        this.accountService = accountService;
//        this.modelMapper = modelMapper;
//    }
//
//    @PostMapping("reg")
//    public ResponseEntity<Map<String,Object>> accountSave(@ModelAttribute AccountMapperDto accountMapperDto, HttpServletRequest request){
//
//        AjaxResponse res = new AjaxResponse();
//
//        Account account = modelMapper.map(accountMapperDto, Account.class);
//
//        //패스워드를 입력하세요.
//        if (accountMapperDto.getUserPw() == null || accountMapperDto.getUserPw().equals("")){
//            return ResponseEntity.ok(res.fail(ResponseErrorCode.ECO001.getCode(), "비밀번호를 "+ ResponseErrorCode.ECO001.getDesc(), null, null));
//        }
//
//        Optional<Account> optionalAccount = accountService.findByUserId(account.getUserId());
//
//        String userId = request.getUserPrincipal().getName();
//        log.info("로그인한 ID : "+userId);
//
//        //userid 중복체크
//        if (optionalAccount.isPresent()) {
//            log.info("사용자아이디중복 - 사용자아이디: '" + account.getUserId() + "'");
//            return ResponseEntity.ok(res.fail(ResponseErrorCode.ECO002.getCode(), "해당 아이디는 "+ResponseErrorCode.ECO002.getDesc(),null, null));
//        }else{
//            account.setInsert_id(userId);
//            account.setInsert_date(LocalDateTime.now());
//        }
//
//
////        Account accountSave =  accountService.save(account);
//
////        log.info("사용자 저장 성공 : '" + accountSave.getUserId() +"'" );
//        return ResponseEntity.ok(res.success());
//
//    }
//
//}
