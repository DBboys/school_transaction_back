package com.song.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MD5加密工具类
 */
public class MD5Util {

    private static Logger logger = LoggerFactory.getLogger(MD5Util.class);

    private static final String MD5_ALGORITHM = "MD5";

    protected static MessageDigest messagedigest = null;

    private final static char[] hexDigits = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's','t', 'u', 'v',
            'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z' };


    /**
     * 初始化以获取Md5
     */
    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsaex) {
            logger.error("{}",nsaex);
        }
    }

    /**
     * MD5加密算法
     * @param data
     * @return
     */
    public static String encryptMD5(String data){
        String result = "";
        try {
            messagedigest = MessageDigest.getInstance(MD5_ALGORITHM);
            messagedigest.update(data.getBytes());
            byte[] digest = messagedigest.digest();
            result = new BigInteger(1, digest).toString(16);// 16进制数字
            // 如果生成数字未满32位，需要前面补0
            for (int i = 0; i < 32 - result.length(); i++) {
                result = "0" + result;
            }
        } catch (NoSuchAlgorithmException e) {
            logger.error("{}",e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        String nowtime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println("当前时间戳"+nowtime);
        String s = "{\"telephoneList\":[\"15122067232\"],\"message\":\"测试短信1\",\"sendTime\":\""+nowtime+"\"}"+"5affa0a8e5e5d77f7f4ad2f1d93b9822";
        System.out.println(encryptMD5(s));
    }
}
