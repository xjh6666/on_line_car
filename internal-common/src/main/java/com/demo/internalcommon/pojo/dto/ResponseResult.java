package com.demo.internalcommon.pojo.dto;

import com.demo.internalcommon.constant.CommonConstantEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ResponseResult<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResponseResult success(){
        return new ResponseResult(CommonConstantEnum.SUCCESS.getCode(),CommonConstantEnum.SUCCESS.getDesc(),null);
    }

    public static ResponseResult success(Object data){
        return new ResponseResult(CommonConstantEnum.SUCCESS.getCode(),CommonConstantEnum.SUCCESS.getDesc(),data);
    }

    public static ResponseResult fail(Integer code,String message,Object data){
        return new ResponseResult(code,message,data);
    }

    public static ResponseResult fail(Integer code,String message){
        return fail(code,message,null);
    }

    public Boolean isSuccess(){
        if(code==0){
            return true;
        }
        return false;
    }
}
