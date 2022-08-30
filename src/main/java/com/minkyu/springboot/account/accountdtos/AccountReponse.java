package com.minkyu.springboot.account.accountdtos;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AccountReponse {

    private final Long id;
    private final String userId;
    private final String userPw;
    private final String userName;
    private final String userPhone;
    private final AccountRole role;
    private final String insert_id;
    private final LocalDateTime insert_date;

    @Builder
    public AccountReponse(Long id, String userId, String userPw, String userName, String userPhone, AccountRole role, String insert_id, LocalDateTime insert_date) {
        this.id = id;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userPhone = userPhone;
        this.role = role;
        this.insert_id = insert_id;
        this.insert_date = insert_date;
    }
}
