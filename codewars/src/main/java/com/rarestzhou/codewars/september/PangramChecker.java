package com.rarestzhou.codewars.september;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/25 2:38 PM
 * @description: https://www.codewars.com/kata/545cedaa9943f7fe7b000048/train/java
 * <p>
 * A pangram is a sentence that contains every single letter of the alphabet at least once.
 * For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram,
 * because it uses the letters A-Z at least once (case is irrelevant).
 * <p>
 * Given a string, detect whether or not it is a pangram. Return True if it is, False if not.
 * Ignore numbers and punctuation.
 */
public class PangramChecker {

    private static int size = 26;

    // Function to check if ch is a letter
    public static boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    public static boolean allLetter(String str, int len) {
        // Convert the given string
        // into lowercase
        str = str.toLowerCase();

        // Create a frequency array to
        // mark the present letters
        boolean[] present = new boolean[size];

        // Traverse for each character
        // of the string
        for (int i = 0; i < len; i++) {

            // If the current character
            // is a letter
            if (isLetter(str.charAt(i))) {
                // Mark current letter as present
                int letter = str.charAt(i) - 'a';
                present[letter] = true;
            }
        }

        // Traverse for every letter
        // from a to z
        for (int i = 0; i < size; i++) {

            // If the current character
            // is not present in string
            // then return false,
            // otherwise return true
            if (!present[i])
                return false;
        }
        return true;
    }

    public static boolean check(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return false;
        }
        return allLetter(sentence, sentence.length());
    }

    public static boolean checkV2(String sentence) {
        for (char c = 'a'; c <= 'z'; c++) {
            if (!sentence.toLowerCase().contains("" + c)) {
                return false;
            }
        }
        return true;

    }

    public boolean checkCleverVersion(String sentence) {
        return sentence.chars().map(Character::toLowerCase)
                .filter(Character::isAlphabetic).distinct().count() == 26;
    }

    public static void main(String[] args) {
        String blankPangram = " ";
        System.out.println(check(blankPangram));
        String nullPangram = null;
        System.out.println(check(nullPangram));
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        System.out.println(check(pangram1));
        String pangram2 = "You shall not pass!";
        System.out.println(check(pangram2));
    }
}
