package com.example.util;

public class StringUtil {

    /**
     * 判空
     * @param str 字符串
     * @return boolean
     */
    public static boolean isNullOrEmpty(String str) {
        // 使用Objects.equals处理str为null的情况
        return str == null || str.trim().isEmpty();
    }

    /**
     * 非空
     * @param str
     * @return
     */
    public static boolean isNotNullOrEmpty(String str) {
        // 使用Objects.equals处理str为null的情况
        return str != null && !str.trim().isEmpty();
    }
}

