package com.demo.internalcommon.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResponseResult success(Object data){
        return new ResponseResult(200,"成功",data);
    }

    public static ResponseResult fail(Integer code,String message,Object data){
        return new ResponseResult(code,message,data);
    }

    public static ResponseResult fail(Integer code,String message){
        return fail(code,message,null);
    }
}
