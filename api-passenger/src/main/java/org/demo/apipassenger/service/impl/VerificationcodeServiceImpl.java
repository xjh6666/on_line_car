package org.demo.apipassenger.service.impl;

import com.demo.internalcommon.pojo.dto.ResponseResult;
import com.demo.internalcommon.pojo.response.VerifCodeResponse;
import org.demo.apipassenger.remote.NumberCodeApi;
import org.demo.apipassenger.service.VerificationcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationcodeServiceImpl implements VerificationcodeService {
    @Autowired
    private NumberCodeApi numberCodeApi;

    @Override
    public Object getVerificationcode() {
        ResponseResult<VerifCodeResponse> verifCode = numberCodeApi.getVerifCode(6);
        System.out.println("获取到的验证码："+verifCode.getData().getVerifCode());
        return "ok";
    }

}
