package com.code.test.handler;

import com.code.test.enums.StringStrategyType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author hj
 * @description: 字符串处理测试类
 * @date 2025/5/19
 */
public class StringHandlerTest {

    private final static StringHandler delHandler = com.code.test.factory.StringHandlerFactory.createStringHandler(new StringStrategyType[]{StringStrategyType.DEL_MULTI});
    private final static StringHandler replaceHandler = com.code.test.factory.StringHandlerFactory.createStringHandler(new StringStrategyType[]{StringStrategyType.REPLACE_MULTI, StringStrategyType.DEL_MULTI});

    @Test
    void testDelMultiString() {
        assertEquals("d", delHandler.handle("aabcccbbad"));
        assertEquals("", delHandler.handle("aaaa"));
        assertEquals("", delHandler.handle("aaabbb"));
        assertEquals("abba", delHandler.handle("abba"));
        assertEquals("a", delHandler.handle("a"));
        assertEquals("", delHandler.handle("aaa"));
        assertEquals("bba", delHandler.handle("aaabba"));
    }

    @Test
    void testReplaceMultiString() {
        assertEquals("d", replaceHandler.handle("abcccbad", "ccc->b", "bbb->a"));
        assertEquals("abcczzcbbad", replaceHandler.handle("abcczzcbrrrad", "rrr->b"));
        assertEquals("abbzzcbbad", replaceHandler.handle("abccczzcbrrrad", "ccc->b", "rrr->b"));
    }
}
