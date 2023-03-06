package org.demo.apipassenger.service;

import com.demo.internalcommon.pojo.dto.ResponseResult;
import com.demo.internalcommon.pojo.request.VerificationcodeRequest;

public interface VerificationcodeService {
    /**
     * 获取验证码
     * @return
     * @param request
     */
    ResponseResult getVerificationcode(VerificationcodeRequest request);
}
