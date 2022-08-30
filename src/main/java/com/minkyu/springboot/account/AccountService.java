//package com.minkyu.springboot.account;
//
//import com.broadwave.ecodeltacity.account.accountdtos.AccountMapperDto;
//import com.broadwave.ecodeltacity.account.accountdtos.AccountReponse;
//import com.broadwave.ecodeltacity.account.accountdtos.AccountRole;
//import com.broadwave.ecodeltacity.common.AjaxResponse;
//import com.broadwave.ecodeltacity.common.ResponseErrorCode;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.servlet.http.HttpServletRequest;
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Map;
//import java.util.Optional;
//
///**
// * @author Minkyu
// * Date : 2022-07-15
// * Time :
// * Remark : AccountService
// */
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class AccountService implements UserDetailsService {
//
//    ModelMapper modelMapper;
//    AccountRepository accountRepository;
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public AccountService(ModelMapper modelMapper, AccountRepository accountRepository, PasswordEncoder passwordEncoder){
//        this.modelMapper = modelMapper;
//        this.accountRepository = accountRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    // 로그인 서비스
//    @Override
//    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
//        Optional<Account> account = accountRepository.findByUserId(userid);
//        return new User(account.get().getUserId(),account.get().getUserPw(),true,true,true,true,getAuthorities(account));
//    }
//    private Collection<? extends GrantedAuthority> getAuthorities(Optional<Account> account) {
//        return Arrays.asList(new SimpleGrantedAuthority(account.get().getRole().getCode()));
//    }
//
//    // @@@@@@@@@@@@@@@@@@ RestController @@@@@@@@@@@@@@@@@@@@@
//    // 사용자 저장호출(RestController)
//    @Transactional
//    public ResponseEntity<Map<String,Object>> accountSave(AccountMapperDto accountMapperDto, HttpServletRequest request){
//        AjaxResponse res = new AjaxResponse();
//
//        log.info("accountMapperDto : "+accountMapperDto);
//
//        Account account;
//
//        AccountReponse accountReponse = findByUserId(accountMapperDto.getUserId());
//
//        String userId = request.getUserPrincipal().getName();
//        log.info("로그인한 ID : "+userId);
//
//        //userid 중복체크
//        if (accountReponse != null) {
//            // 수정
//            account = modelMapper.map(accountReponse, Account.class);
//            account.setUserName(accountMapperDto.getUserName());
//            account.setUserPhone(accountMapperDto.getUserPhone());
//            account.setModify_id(userId);
//            account.setModify_date(LocalDateTime.now());
//        }else{
//            // 신규
//            account = modelMapper.map(accountMapperDto, Account.class);
//            account.setRole(AccountRole.ROLE_USER);
//            account.setInsert_id(userId);
//            account.setInsert_date(LocalDateTime.now());
//        }
//
//        Account accountSave =  save(account);
//
//        log.info("사용자 저장 성공 : '" + accountSave.getUserId() +"'" );
//        return ResponseEntity.ok(res.success());
//    }
//
//    // 사용자ID 중복체크(RestController)
//    public ResponseEntity<Map<String, Object>> saveOverlap(String userId) {
//
//        AjaxResponse res = new AjaxResponse();
//
//        log.info("userId : "+userId);
//
//        AccountReponse accountReponse = findByUserId(userId);
//
//        if (accountReponse != null) {
//            log.info("사용자아이디중복 - 사용자아이디: '" + userId + "'");
//            return ResponseEntity.ok(res.fail(ResponseErrorCode.ECO002.getCode(), "해당 아이디는 "+ResponseErrorCode.ECO002.getDesc(),null, null));
//        }
//
//        return ResponseEntity.ok(res.success());
//    }
//
//    // @@@@@@@@@@@@@@@@@@ Service @@@@@@@@@@@@@@@@@@@@@
//    // 사용자 저장(Service)
//    public Account save(Account account){
//        account.setUserPw(passwordEncoder.encode(account.getUserPw()));
//        return accountRepository.save(account);
//    }
//
//    // 사용자명으로 조회(Service)
//    public Account findByUserName(String userName){
//        return accountRepository.findByUserName(userName);
//    }
//
//    // 사용자ID로 조회(Service)
//    public AccountReponse findByUserId(String userId){
//        Optional<Account> optionalAccount = accountRepository.findByUserId(userId);
//
//        AccountReponse accountReponse = null;
//        if(optionalAccount.isPresent()){
//            accountReponse =  AccountReponse.builder()
//                    .id(optionalAccount.get().getId())
//                    .userId(optionalAccount.get().getUserId())
//                    .userPw(optionalAccount.get().getUserPw())
//                    .userName(optionalAccount.get().getUserName())
//                    .userPhone(optionalAccount.get().getUserPhone())
//                    .role(optionalAccount.get().getRole())
//                    .insert_id(optionalAccount.get().getInsert_id())
//                    .insert_date(optionalAccount.get().getInsert_date())
//                    .build();
//        }
//        return accountReponse;
//    }
//
//}