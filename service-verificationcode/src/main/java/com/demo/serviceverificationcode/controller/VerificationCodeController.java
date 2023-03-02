package com.demo.serviceverificationcode.controller;

import com.demo.internalcommon.pojo.dto.ResponseResult;
import com.demo.internalcommon.pojo.response.VerifCodeResponse;
import com.demo.internalcommon.util.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VerificationCodeController {

    @GetMapping("/getVerifCode")
    public ResponseResult getVerifCode(){
        String verifCode = NumberUtils.generateSixRandomNumber();
        VerifCodeResponse result = new VerifCodeResponse();
        result.setVerifCode(verifCode);
        return ResponseResult.success(result);
    }
}
