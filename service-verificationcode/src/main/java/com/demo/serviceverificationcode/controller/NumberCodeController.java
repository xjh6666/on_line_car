package com.demo.serviceverificationcode.controller;

import com.demo.internalcommon.pojo.dto.ResponseResult;
import com.demo.internalcommon.pojo.response.VerifCodeResponse;
import com.demo.internalcommon.util.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NumberCodeController {

    @GetMapping("/getVerifCode/{size}")
    public ResponseResult getVerifCode(@PathVariable("size") Integer size){
        String verifCode = NumberUtils.generateSixRandomNumber(size);
        VerifCodeResponse result = new VerifCodeResponse();
        result.setVerifCode(verifCode);
        return ResponseResult.success(result);
    }
}
