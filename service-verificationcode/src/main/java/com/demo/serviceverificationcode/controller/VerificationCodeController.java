package com.demo.serviceverificationcode.controller;

import com.demo.internalcommon.pojo.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VerificationCodeController {

    @GetMapping("/getVerifCode")
    public ResponseResult getVerifCode(){
        Map<String,String > result=new HashMap<>();
        result.put("id","1");
        return ResponseResult.success(result);
    }
}
