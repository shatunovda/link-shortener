package org.example.tinurl.backend;

import com.google.common.collect.Maps;
import com.google.common.primitives.Longs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Base63 {

    public static final char[] toBase63 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_'
    };

    public static final long MAX_LONG_VALUE_FOR_BASE_63 = 984_930_291_881_790_848L;

    public static final int NUMBER_OF_CHARACTERS = 10;

    public static final Map<Character, Integer> charToIndex = IntStream
            .range(0, toBase63.length)
            .mapToObj(i -> Maps.immutableEntry(toBase63[i], i))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static String longToBase63(long base10) {
        if (base10 > MAX_LONG_VALUE_FOR_BASE_63) {
            throw new IllegalArgumentException("Input value cannot be more than " + MAX_LONG_VALUE_FOR_BASE_63);
        }

        StringBuilder invertBase63 = new StringBuilder();
        while (base10 > 0L) {
            invertBase63.append(toBase63[(int) (base10 % 63L)]);
            base10 = base10 / 63L;
        }
        if (invertBase63.length() < NUMBER_OF_CHARACTERS) {
            int i = NUMBER_OF_CHARACTERS - invertBase63.length();
            while (i > 0) {
                invertBase63.append(toBase63[0]);
                i--;
            }
        }

        return invertBase63.reverse().toString();
    }

    public static long base63ToLong(String s){
        if (s.length() > NUMBER_OF_CHARACTERS) {
            throw new IllegalArgumentException("Length of string can not br more 10");
        }

        long sum = 0L;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer index = charToIndex.get(ch);
            if (index == null) throw new IllegalArgumentException("Base63 unsupported " + ch);
            int pose = s.length() - 1 - i;
            sum = sum + index * pow(63, pose);
        }

        return sum;
    }

    public static long pow(int base, int degree) {
        long res = 1L;

        while (degree > 0) {
            res = res * base;
            degree--;
        }

        return res;
    }

    //TODO remove
    public static String format(long l) {
        byte[] bytesL = Longs.toByteArray(l);

        //byte[] byte64 = Base64.getDecoder().decode(bytesL);
        StringJoiner stringJoiner = new StringJoiner("_", String.valueOf(l), "");
        stringJoiner.add(" = ");
        for (int i = 0; i < bytesL.length; i++ ) {
            byte b = bytesL[i];
            stringJoiner.add(String.format(
                    "%8s",
                    Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
        }
        return stringJoiner.toString();
    }
}
