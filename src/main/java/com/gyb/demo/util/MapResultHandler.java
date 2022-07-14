package com.gyb.demo.util;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author GB
 * @date 2022/5/31 14:51
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
public class MapResultHandler implements ResultHandler {

    @SuppressWarnings("rawtypes")
    private final Map mappedResults = new HashMap();

    @SuppressWarnings("unchecked")
    @Override
    public void handleResult(ResultContext context) {
        @SuppressWarnings("rawtypes")
        Map map = (Map) context.getResultObject();
        // xml配置里面的property的值，对应的列
        mappedResults.put(map.get("key"), map.get("value"));
    }

    @SuppressWarnings("rawtypes")
    public Map getMappedResults() {
        return mappedResults;
    }

}
