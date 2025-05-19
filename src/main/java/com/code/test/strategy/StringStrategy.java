package com.code.test.strategy;

/**
 * @Author hj
 * @Date 2025/5/19
 * @Description 字符串处理策略接口
 **/
public interface StringStrategy {

    /**
     * @return java.lang.String
     * @Author hj
     * @Date 2025/5/19
     * @Description 处理字符串并返回结果
     * @Param [input, args] input:输入字符串 params:参数列表
     **/
    String execute(String input, String... params);
}
