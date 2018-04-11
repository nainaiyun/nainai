package com.nainai.util;

import java.util.UUID;

/**
 * Created by haopeng yan on 2018/1/10 16:31.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public class UUIDGenerator {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        /*去掉"-"符号*/
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
        return temp;
    }

    /**
     * 获得指定数量的UUID
     *
     * @param number
     * @return
     */
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }
}