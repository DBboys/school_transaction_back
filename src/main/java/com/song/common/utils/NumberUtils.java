package com.song.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author : dongliwen
 * @date : 2021-03-14
 **/
@Slf4j
public class NumberUtils {

    private static HashMap<Character,Integer> numMap = new HashMap<>();

    static {
        numMap.put('零', 0);
        numMap.put('一', 1);
        numMap.put('二', 2);
        numMap.put('三', 3);
        numMap.put('四', 4);
        numMap.put('五', 5);
        numMap.put('六', 6);
        numMap.put('七', 7);
        numMap.put('八', 8);
        numMap.put('九', 9);
        numMap.put('十', 10);
    }

    public static void main(String[] args) {
        String s = "07十班";
        long l = strConverNumByClass(s);
        System.out.println(l);
    }

    public static long strConverNumByClass(String str){

        String className = str.substring(2,str.length() - 1);
        long result = 0;
        if ((result = strConverNum(className)) != -1) {
            return result;
        }

        result = 0;
        Stack<Integer> stack = new Stack<>();
        log.error("班级信息-----：", str);
        for (char c : className.toCharArray()) {
            Integer num = numMap.get(c);
            log.error("栈信息：-----:" + stack);
            if (stack.isEmpty() || num < stack.peek()) {
                stack.push(num);
            } else {
                int temp = 0;
                while (!stack.isEmpty() && num > stack.peek()) {
                    temp += stack.pop();
                }
                temp = (temp == 0 ? 1 : temp);
                stack.push(temp * num);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private static long strConverNum(String str) {

        for (char c : str.toCharArray()) {
            if (numMap.get(c) >= 10) {
                return -1;
            }
        }

        long result = 0;
        int temp = 1;
        boolean f = false;
        for (int i = str.length() - 1;i >= 0;i--) {
            Integer num = numMap.get(str.charAt(i));
            // 如果没有找到说明班级不是数字名，直接跳出
            if (null == num) {
                f = true;
                break;
            }
            result += num * temp;
            temp++;
        }
        // 用毫秒值排序放到最后
        if (f) {
            result = System.currentTimeMillis();
        }
        return result;
    }
}
