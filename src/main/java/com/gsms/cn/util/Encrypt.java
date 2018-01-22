package com.gsms.cn.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by likun on 2018/1/22 0022.
 */
public class Encrypt {
    public static String toEncrypt(String username,String password){
        Md5Hash hash = new Md5Hash(password,"("+username+")",2);
        return hash.toString();
    }

}
