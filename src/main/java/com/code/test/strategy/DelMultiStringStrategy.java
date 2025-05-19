package com.code.test.strategy;

import com.code.test.utils.MyStringUtils;

/**
 * @author hj
 * @description: 删除连续重复的字符串策略
 * @date 2025/5/19
 */
public class DelMultiStringStrategy implements StringStrategy {

    /**
     * @return java.lang.String
     * @Author hj
     * @Date 2025/5/19
     * @Description 删除连续重复的字符串
     * @Param [input, params] input:输入字符串 params:参数列表
     **/
    @Override
    public String execute(String input, String... params) {
        String multiString;
        int repeatCount = 3;
        do {
            // 查找连续重复repeatCount次的字符串
            multiString = MyStringUtils.findMultiString(input, repeatCount);
            if (multiString != null) {
                // 删除连续重复的字符串
                input = input.replaceAll(multiString, "");
                System.out.println("-> " + input);
            }
        } while (multiString != null);
        return input;
    }

}
