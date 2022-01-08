package com.dms.DmsUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TranMD5 {
    /**
     * md5加密的方法 32位字符串
     * @param str
     * @return
     */
    public static String md5(String str){
        //生成一个Md5加密摘要
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            //将string类型数据加密转为int类型 再返回成16位的字符串
            String string = new BigInteger(1, md5.digest(str.getBytes())).toString(16);
            //BigInteger会省略0 补零补32位
            return fillMd5(string);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String fillMd5(String md5){
        return md5.length() == 32 ? md5 : fillMd5("0" + md5);
    }

    public static void main(String[] args) {
        System.out.println(md5("admin"));
    }
}