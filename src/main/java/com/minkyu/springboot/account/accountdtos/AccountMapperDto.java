package com.minkyu.springboot.account.accountdtos;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Minkyu
 * Date : 2022-07-22
 * Time :
 * Remark : 유저 AccountMapperDto
 */
@Data
@NoArgsConstructor
public class AccountMapperDto {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String userPw;

    @NotBlank(message = "이름을 입력해주세요.")
    private String userName;

    @NotBlank(message = "이름을 입력해주세요.")
    private String userPhone;

    @Builder
    public AccountMapperDto(String userId, String userPw, String userName, String userPhone) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userPhone = userPhone;
    }

}
