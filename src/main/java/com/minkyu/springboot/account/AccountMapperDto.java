package com.minkyu.springboot.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Minkyu
 * Date : 2022-07-22
 * Time :
 * Remark : 유저 AccountMapperDto
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountMapperDto {

    private String userId;
    private String userPw;
    private String userName;

}
