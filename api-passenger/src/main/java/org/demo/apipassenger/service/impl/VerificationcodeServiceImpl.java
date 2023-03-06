package org.demo.apipassenger.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.demo.internalcommon.pojo.dto.ResponseResult;
import com.demo.internalcommon.pojo.request.VerificationcodeRequest;
import com.demo.internalcommon.pojo.response.VerifCodeResponse;
import org.demo.apipassenger.remote.NumberCodeApi;
import org.demo.apipassenger.service.VerificationcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationcodeServiceImpl implements VerificationcodeService {
    @Autowired
    private NumberCodeApi numberCodeApi;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String  LOGIN_VERIF_CODE_PREFIX ="login_verif_code_prefix-";

    @Override
    public ResponseResult getVerificationcode(VerificationcodeRequest request) {
        if(StringUtils.isBlank(request.getPhone())){
            throw new RuntimeException("手机号不能为空");
        }
        ResponseResult<VerifCodeResponse> verifCodeResponseResponseResult = numberCodeApi.getVerifCode(10);
        if(verifCodeResponseResponseResult.isSuccess()){
            throw new RuntimeException("获取验证码失败");
        }
//        System.out.println("获取到的验证码："+verifCodeResponseResponseResult.getData().getVerifCode());
        //redis 存起来
        stringRedisTemplate.opsForValue().set(LOGIN_VERIF_CODE_PREFIX+request.getPhone(),
                verifCodeResponseResponseResult.getData().getVerifCode(),
                2,
                TimeUnit.MINUTES
                );

        System.out.println(stringRedisTemplate.opsForValue().get(LOGIN_VERIF_CODE_PREFIX+request.getPhone()));


        return ResponseResult.success();
    }

}
