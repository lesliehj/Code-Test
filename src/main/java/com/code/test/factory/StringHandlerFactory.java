package com.code.test.factory;

import com.code.test.enums.StringStrategyType;
import com.code.test.handler.StringHandler;
import com.code.test.strategy.DelMultiStringStrategy;
import com.code.test.strategy.ReplaceMultiStringStrategy;
import com.code.test.strategy.StringStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hj
 * @description: 字符串处理器工厂
 * @date 2025/5/19
 */
public class StringHandlerFactory {

    /**
     * @return com.code.test.handler.StringHandler
     * @Author hj
     * @Date 2025/5/19
     * @Description 创建字符串处理器
     * @Param [types] 策略类型列表
     **/
    public static StringHandler createStringHandler(StringStrategyType[] types) {

        List<StringStrategy> strategyList = new ArrayList<>();
        for (StringStrategyType stringStrategyType : types) {
            switch (stringStrategyType) {
                case DEL_MULTI -> strategyList.add(new DelMultiStringStrategy());
                case REPLACE_MULTI -> strategyList.add(new ReplaceMultiStringStrategy());
            }
        }

        return new StringHandler(strategyList);
    }
}
