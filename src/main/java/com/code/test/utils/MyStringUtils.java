package com.code.test.utils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author hj
 * @description: 字符串工具类
 * @date 2025/5/19
 */
public class MyStringUtils {

    /**
     * @return java.lang.String
     * @Author hj
     * @Date 2025/5/19
     * @Description 找到连续重复的字符串
     * @Param [str, repeatCount] 字符串，重复次数
     **/
    public static String findMultiString(String str, int repeatCount) {

        //字符串为空或者长度小于重复次数，返回null
        if (str == null || str.length() < repeatCount) return null;

        // 构建正则表达式，匹配重复次数大于等于指定次数的字符
        String regex = "(.)\\1{" + (repeatCount - 1) + ",}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /**
     * @return boolean
     * @Author hj
     * @Date 2025/5/19
     * @Description 判断字符串是否全是小写字母
     * @Param [str]
     **/
    public static boolean isAllLowerCase(String str) {
        return str != null &&
                !str.isEmpty() &&
                str.chars().allMatch(c -> c >= 'a' && c <= 'z');
    }

    /**
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @Author hj
     * @Date 2025/5/19
     * @Description 将字符串数组转换为有序的Map
     * 例如：
     * 输入：["ccc->b", "aaa->z", "111->2", "333->4"]
     * 输出：{"ccc": "b", "aaa": "z", "111": "2", "333": "4"}
     * @Param [params]
     **/
    public static Map<String, String> convertToOrderedMap(String... params) {
        return Arrays.stream(params)
                .map(param -> param.split("->", 2))
                .filter(parts -> parts.length == 2)
                .collect(Collectors.toMap(
                        parts -> parts[0].trim(),
                        parts -> parts[1].trim(),
                        (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new
                ));
    }
}
