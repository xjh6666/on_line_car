package org.demo.apipassenger.remote;

import com.demo.internalcommon.pojo.dto.ResponseResult;
import com.demo.internalcommon.pojo.response.VerifCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-verificationcode")
public interface NumberCodeApi {

    @RequestMapping(method = RequestMethod.GET,value = "/getVerifCode/{size}")
    ResponseResult<VerifCodeResponse> getVerifCode(@PathVariable("size")Integer size);
}
