package com.code.test.strategy;

import com.code.test.utils.MyStringUtils;

import java.util.Map;
import java.util.Set;

/**
 * @author hj
 * @description: 替换连续重复的字符串策略
 * @date 2025/5/19
 */
public class ReplaceMultiStringStrategy implements StringStrategy {

    /**
     * @return java.lang.String
     * @Author hj
     * @Date 2025/5/19
     * @Description 替换连续重复的字符串
     * @Param [input, params] input:输入字符串 params:参数列表
     **/
    @Override
    public String execute(String input, String... params) {
        //将字符串数组转换为有序的Map
        Map<String, String> stringMap = MyStringUtils.convertToOrderedMap(params);
        //需要被替换的字符串集合
        Set<String> keySet = stringMap.keySet();
        do {
            for (Map.Entry<String, String> entry : stringMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (input.contains(key)) {
                    input = input.replaceAll(key, value);
                    System.out.println("-> " + input + ", " + key + " is replaced by " + value);
                }
            }
        } while (keySet.stream().anyMatch(input::contains));

        return input;
    }

}
