package org.demo.apipassenger.controller;

import com.demo.internalcommon.pojo.dto.ResponseResult;
import com.demo.internalcommon.pojo.request.VerificationcodeRequest;
import org.demo.apipassenger.service.VerificationcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationcodeController {
    @Autowired
    private VerificationcodeService verificationcodeService;

    @PostMapping("/get/verificationcode")
    public ResponseResult getVerificationcode(@RequestBody VerificationcodeRequest request){
        verificationcodeService.getVerificationcode(request);
        return ResponseResult.success();
    }
}
