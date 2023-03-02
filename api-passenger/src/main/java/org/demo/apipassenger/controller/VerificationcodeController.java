package org.demo.apipassenger.controller;

import com.demo.internalcommon.pojo.dto.ResponseResult;
import org.demo.apipassenger.service.VerificationcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationcodeController {
    @Autowired
    private VerificationcodeService verificationcodeService;

    @GetMapping("/get/verificationcode")
    public Object getVerificationcode(){
        return ResponseResult.success(verificationcodeService.getVerificationcode());
    }
}
