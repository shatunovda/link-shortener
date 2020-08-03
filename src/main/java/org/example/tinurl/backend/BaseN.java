package org.example.tinurl.backend;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseN {

    private final char[] charsOfNumeralSystem;
    private final int bitCount;
    private final long maxLongValueInBase10;
    private final int sizeOfNumeralSystem;
    private final Map<Character, Integer> charToIndex;

    public BaseN(char[] charsOfNumeralSystem, int bitCount) {
        this.charsOfNumeralSystem = charsOfNumeralSystem;
        this.bitCount = bitCount;
        this.sizeOfNumeralSystem = charsOfNumeralSystem.length;
        this.maxLongValueInBase10 = pow(sizeOfNumeralSystem, bitCount) - 1;
        this.charToIndex = IntStream
                .range(0, sizeOfNumeralSystem)
                .mapToObj(i -> Maps.immutableEntry(charsOfNumeralSystem[i], i))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public long getMaxLongValueInBase10() {
        return maxLongValueInBase10;
    }

    public int getSizeOfNumeralSystem() {
        return sizeOfNumeralSystem;
    }

    public String longToBaseN(long base10) {
        if (base10 > maxLongValueInBase10) {
            throw new IllegalArgumentException("Input value cannot be more than " + maxLongValueInBase10);
        }

        StringBuilder invertBaseN = new StringBuilder();
        while (base10 > 0L) {
            invertBaseN.append(charsOfNumeralSystem[(int) (base10 % sizeOfNumeralSystem)]);
            base10 = base10 / sizeOfNumeralSystem;
        }
        if (invertBaseN.length() < bitCount) {
            int i = bitCount - invertBaseN.length();
            while (i > 0) {
                invertBaseN.append(charsOfNumeralSystem[0]);
                i--;
            }
        }

        return invertBaseN.reverse().toString();
    }

    public long baseNToLong(String s){
        if (s.length() > bitCount) {
            throw new IllegalArgumentException("Length of string can not br more" + bitCount);
        }

        long sum = 0L;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer index = charToIndex.get(ch);
            if (index == null) throw new IllegalArgumentException("BaseN unsupported " + ch);
            int pose = s.length() - 1 - i;
            sum = sum + index * pow(sizeOfNumeralSystem, pose);
        }

        return sum;
    }

    public static long pow(int base, int degree) {
        long res = 1L;
        while (degree > 0) {
            res = res * base;
            if(res < 0) throw new IllegalArgumentException("Overflow long " + base + "^" + degree);
            degree--;
        }
        return res;
    }
}
