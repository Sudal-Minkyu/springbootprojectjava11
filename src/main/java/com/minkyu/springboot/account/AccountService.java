//package com.minkyu.springboot.account;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
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
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Optional;
//
///**
// * @author Minkyu
// * Date : 2022-07-15
// * Time :
// * Remark : AccountService
// */
//@Service
//@RequiredArgsConstructor
//public class AccountService implements UserDetailsService {
//
//    AccountRepository accountRepository;
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder){
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
//    // 사용자 저장
//    @Transactional
//    public Account save(Account account){
//        account.setUserPw(passwordEncoder.encode(account.getUserPw()));
//        return accountRepository.save(account);
//    }
//
//    // 사용자명으로 조회
//    public Account findByUserName(String userName){
//        return accountRepository.findByUserName(userName);
//    }
//
//    // 사용자ID로 조회
//    public Optional<Account> findByUserId(String userId){
//        return accountRepository.findByUserId(userId);
//    }
//
//
//}