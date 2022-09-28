package com.rarestzhou.codewars.september;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/27 12:01 AM
 * @description: https://www.codewars.com/kata/54b724efac3d5402db00065e/solutions/java
 */
public class MorseCodeDecoder {

    public static final String WORD_DELIMITER = "   ";
    public static final String CHAR_DELIMITER = " ";

    public static String decode(String morseCode) {
        StringBuilder result = new StringBuilder();
        // split 3 space first
        for(String word : morseCode.trim().split("   ")) {
            // split space, two spaces then
            for(String letter : word.split("\\s+")) {
//                result.append(MorseCode.get(letter));
            }
            result.append(' ');
        }
        return result.toString().trim();
    }



    public static String decodeCleverVersion(String morseCode) {
        return Arrays.stream(morseCode.trim().split(WORD_DELIMITER))
                .map(MorseCodeDecoder::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private static String decodeWord(String morseWord) {
        return Arrays.stream(morseWord.trim().split(CHAR_DELIMITER))
//                .map(MorseCode::get)
                .collect(Collectors.joining());
    }
}
