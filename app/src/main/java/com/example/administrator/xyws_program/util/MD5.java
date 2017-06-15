package com.example.administrator.xyws_program.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 黑明阳 on 2017/6/12.
 */

public class MD5 {
    public static String md5s(String plainText) throws Exception {
        String str = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw e;
        }
        return str;
    }

}
