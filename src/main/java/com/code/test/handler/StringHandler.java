package com.code.test.handler;

import com.code.test.strategy.StringStrategy;
import com.code.test.utils.MyStringUtils;

import java.util.List;

/**
 * @author hj
 * @description: 字符串处理器
 * @date 2025/5/19
 */
public class StringHandler {

    // 策略列表顺序执行
    private final List<StringStrategy> strategyList;

    public StringHandler(List<StringStrategy> strategyList) {
        this.strategyList = strategyList;
    }

    /**
     * @return java.lang.String
     * @Author hj
     * @Date 2025/5/19
     * @Description 处理字符串并返回结果
     * @Param [input, params] input:输入字符串 params:参数列表
     **/
    public String handle(String input, String... params) {

        if (!MyStringUtils.isAllLowerCase(input)) {
            throw new IllegalArgumentException("Input string must be in lowercase.");
        }

        System.out.println("Input: " + input);
        System.out.println("Output:");
        // 顺序执行策略列表中的策略
        for (StringStrategy strategy : strategyList) {
            input = strategy.execute(input, params);
        }
        return input;
    }
}
