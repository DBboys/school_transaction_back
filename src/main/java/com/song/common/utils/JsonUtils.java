package com.song.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author shizuku
 * @date 2020/2/6 12:01
 */
public class JsonUtils {

    /**
     * 处理前段请求的字符问题
     *
     * @param jsonStr
     * @return
     */
    public static String handleJson(String jsonStr) {
        if (StringUtils.isEmpty(jsonStr)) {
            return "";
        }
        if (!jsonStr.contains("&quot;")) {
            return jsonStr;
        }
        jsonStr = jsonStr.replaceAll("&quot;", "\"");
        return jsonStr;
    }

}
