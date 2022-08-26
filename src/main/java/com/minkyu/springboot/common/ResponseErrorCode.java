package com.minkyu.springboot.common;

/**
 * @author Minkyu
 * Date : 2022-07-15
 * Time :
 * Remark : RestController 응답코드
 */
public enum ResponseErrorCode {
    ECO001("ECO001", "입력해주세요."),
    ECO002("ECO002", "사용중입니다.."),


    ;

    private String code;
    private String desc;

    ResponseErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
