package org.demo.apipassenger.service;

import com.demo.internalcommon.pojo.request.VerificationCodeRequest;
import com.demo.internalcommon.pojo.response.VerificationCodeResponse;

public interface VerificationcodeService {
    /**
     * 获取验证码
     * @return
     * @param request
     */
     void getVerificationcode(VerificationCodeRequest request);

    /**
     * z
     * @paravoid request
     * @return
     */
    VerificationCodeResponse checkVerificationcode(VerificationCodeRequest request);
}
