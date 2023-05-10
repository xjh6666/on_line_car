package com.demo.internalcommon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonConstantEnum{
    SUCCESS(0,"成功"),
    FAIL(500,"失败");

    private Integer code;
    private String desc;


}
