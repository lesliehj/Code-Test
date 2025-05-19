package com.code.test;

import com.code.test.enums.StringStrategyType;
import com.code.test.factory.StringHandlerFactory;
import com.code.test.handler.StringHandler;

public class Main {
    public static void main(String[] args) {

        String delInput = "aabcccbbad";
        StringHandler delHandler = StringHandlerFactory.createStringHandler(new StringStrategyType[]{StringStrategyType.DEL_MULTI});
        delHandler.handle(delInput);

        String replaceInput = "abcccbad";
        StringHandler replaceHandler = StringHandlerFactory.createStringHandler(new StringStrategyType[]{StringStrategyType.REPLACE_MULTI, StringStrategyType.DEL_MULTI});
        replaceHandler.handle(replaceInput, "ccc->b", "bbb->a");

    }
}