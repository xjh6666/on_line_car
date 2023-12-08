package org.demo.apipassenger.controller;

import com.demo.internalcommon.pojo.dto.ResponseResult;
import com.demo.internalcommon.pojo.request.VerificationCodeRequest;
import org.demo.apipassenger.service.VerificationcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class VerificationcodeController {
    @Autowired
    private VerificationcodeService verificationcodeService;

    /**
     * 获取验证码
     * @param request
     * @return
     */
    @PostMapping("/get/verificationcode")
    public ResponseResult getVerificationcode(@RequestBody VerificationCodeRequest request){
        verificationcodeService.getVerificationcode(request);
        return ResponseResult.success();
    }

    /**
     * 校验验证码
     * @param request
     * @return
     */
    @PostMapping("/check/verificationcode")
    public ResponseResult checkVerificationcode(@RequestBody VerificationCodeRequest request){
        return ResponseResult.success(verificationcodeService.checkVerificationcode(request));
    }
}
