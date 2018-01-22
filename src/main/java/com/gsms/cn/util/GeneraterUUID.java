package com.gsms.cn.util;

import java.util.UUID;

/**
 * Created by likun on 2018/1/22 0022.
 */
public class GeneraterUUID {
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }
}
