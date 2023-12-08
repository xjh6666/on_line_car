package com.demo.internalcommon.pojo.request;

import lombok.Data;

@Data
public class VerificationCodeRequest {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码
     */
    private String verificationCode;
}
