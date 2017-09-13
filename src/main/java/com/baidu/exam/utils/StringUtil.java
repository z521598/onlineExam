package com.baidu.exam.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by langshiquan on 17/9/13.
 */
public class StringUtil {
    public static String md5(String value){
        return DigestUtils.md5Hex(value);
    }
}
