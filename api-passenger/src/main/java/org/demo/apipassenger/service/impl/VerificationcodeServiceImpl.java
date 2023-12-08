package org.demo.apipassenger.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.demo.internalcommon.pojo.dto.ResponseResult;
import com.demo.internalcommon.pojo.request.VerificationCodeRequest;
import com.demo.internalcommon.pojo.response.VerifCodeResponse;
import com.demo.internalcommon.pojo.response.VerificationCodeResponse;
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
    public void getVerificationcode(VerificationCodeRequest request) {
        if(StringUtils.isBlank(request.getPhone())){
            throw new RuntimeException("手机号不能为空");
        }
        ResponseResult<VerifCodeResponse> verifCodeResponseResponseResult = numberCodeApi.getVerifCode(10);
        if(!verifCodeResponseResponseResult.isSuccess()){
            throw new RuntimeException("获取验证码失败");
        }
//        System.out.println("获取到的验证码："+verifCodeResponseResponseResult.getData().getVerifCode());
        //redis 存起来
        stringRedisTemplate.opsForValue().set(getVerifCodeKey(request.getPhone()),
                verifCodeResponseResponseResult.getData().getVerifCode(),
                2,
                TimeUnit.MINUTES
        );

        System.out.println(stringRedisTemplate.opsForValue().get(LOGIN_VERIF_CODE_PREFIX+request.getPhone()));
    }

    /**
     * 校验验证码
     * @param request
     * @return
     */
    @Override
    public VerificationCodeResponse checkVerificationcode(VerificationCodeRequest request) {
        //1、校验验证码是否正确
        String verifCode = stringRedisTemplate.opsForValue().get(getVerifCodeKey(request.getPhone()));

        if(StringUtils.isBlank(verifCode)){
            //todo 全局异常处理
            throw new RuntimeException("请重新获取验证码");
        }
        if (!verifCode.equals(request.getVerificationCode())) {
            throw new RuntimeException("验证码错误");
        }

        //2、校验通过后，删除redis中的验证码
        stringRedisTemplate.delete(getVerifCodeKey(request.getPhone()));
        return VerificationCodeResponse.builder()
                .token("token")
                .build();
    }

    /**
     * 获取验证码key
     * @param phone
     * @return
     */
    private String getVerifCodeKey(String phone){
        return LOGIN_VERIF_CODE_PREFIX+phone;
    }
}
