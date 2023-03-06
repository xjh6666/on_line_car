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
    //根据位数生成随机数
    public static String generateSixRandomNumber(int size){
        String str = "0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char ch = str.charAt((int) (Math.random() * 10));
            sb.append(ch);
        }
        return sb.toString();
    }
}
