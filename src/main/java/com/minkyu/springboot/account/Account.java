//package com.minkyu.springboot.account;
//
//import com.minkyu.springboot.account.accountdtos.AccountRole;
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
///**
// * @author Minkyu
// * Date : 2022-07-15
// * Time :
// * Remark : 유저테이블 도메인
// */
//@Entity
//@Data
//@EqualsAndHashCode(of = "id")
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Table(name="bs_account")
//public class Account {
//
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @Column(name="id")
//    private Long id;
//
//    @Column(unique = true, name="user_id")
//    private String userId;
//
//    @Column(name="user_pw")
//    private String userPw;
//
//    @Column(name="user_name")
//    private String userName;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name="user_role")
//    private AccountRole role;
//
//    @Column(name="insert_id")
//    private String insert_id;
//
//    @Column(name="insert_date")
//    private LocalDateTime insert_date;
//
//    @Column(name="modify_id")
//    private String modify_id;
//
//    @Column(name="modify_date")
//    private LocalDateTime modify_date;
//
//}
