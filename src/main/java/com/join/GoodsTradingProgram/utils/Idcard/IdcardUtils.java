package com.join.GoodsTradingProgram.utils.Idcard;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 15:05 2020/8/10
 */
public class IdcardUtils {

    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
            .toCharArray();

    private static final char last2byte = (char) Integer
            .parseInt("00000011", 2);
    private static final char last4byte = (char) Integer
            .parseInt("00001111", 2);
    private static final char last6byte = (char) Integer
            .parseInt("00111111", 2);
    private static final char lead6byte = (char) Integer
            .parseInt("11111100", 2);
    private static final char lead4byte = (char) Integer
            .parseInt("11110000", 2);
    private static final char lead2byte = (char) Integer
            .parseInt("11000000", 2);
    private static final char[] encodeTable = new char[] { 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/' };

    private static int[]  toInt   = new int[128];

    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            toInt[ALPHABET[i]] = i;
        }
    }

    /**
     将basic64码转为二进制数组
     * @param idcardString
     * @return
     */
    public static byte[] decode(String idcardString) {
        int delta = idcardString.endsWith( "==" ) ? 2 : idcardString.endsWith( "=" ) ? 1 : 0;
        byte[] buffer = new byte[idcardString.length() * 3 / 4 - delta];
        int mask = 0xFF;
        int index = 0;
        for (int i = 0; i < idcardString.length(); i += 4) {
            int c0 = toInt[idcardString.charAt( i )];
            int c1 = toInt[idcardString.charAt( i + 1)];
            buffer[index++] = (byte)(((c0 << 2) | (c1 >> 4)) & mask);
            if (index >= buffer.length) {
                return buffer;
            }
            int c2 = toInt[idcardString.charAt( i + 2)];
            buffer[index++] = (byte)(((c1 << 4) | (c2 >> 2)) & mask);
            if (index >= buffer.length) {
                return buffer;
            }
            int c3 = toInt[idcardString.charAt( i + 3 )];
            buffer[index++] = (byte)(((c2 << 6) | c3) & mask);
        }
        return buffer;
    }
}
