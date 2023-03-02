package com.demo.internalcommon.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author xujiahao
 * @date 2023/3/2 10:00
 */

public class NumberUtils {
    //生成六位随机数
    public static String generateSixRandomNumber(){
        return String.valueOf((int)((Math.random()*9+1)*100000));
    }
}
