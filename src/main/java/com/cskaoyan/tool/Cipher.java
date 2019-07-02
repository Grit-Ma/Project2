package com.cskaoyan.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cipher {

    private static final String SALT = "cskaoyan";

    //数据库密码字段最长32位
    public static String encode(String str){
        String sha1 = encode(str + SALT, "SHA1");
        String md5 = encode(sha1, "MD5");
        return md5;
    }

    private static String encode(String pwd,String algorithm){
        String md5Value="";
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            StringBuffer sb= new StringBuffer();
            byte[] digest1 = digest.digest(pwd.getBytes());
            for (byte b:digest1) {
                int i= b&0x000000FF;
                String s = Integer.toHexString(i);
                if (s.length()==1) {
                    sb.append("0");
                }
                sb.append(s);
                md5Value = sb.toString();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  md5Value;
    }

}
