//package com.minkyu.springboot.account;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface AccountRepository extends JpaRepository<Account, Long> {
//
//    Account findByUserName(String userName);
//
//    @Query("SELECT a FROM Account a where a.userId = :userId")
//    Optional<Account> findByUserId(String userId);
//}