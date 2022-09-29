package com.rarestzhou.codewars.september;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/29 4:44 PM
 * @description: https://www.codewars.com/kata/583203e6eb35d7980400002a/train/java
 * <p>
 * Given an array (arr) as an argument complete the function countSmileys that should return
 * the total number of smiling faces.
 * <p>
 * Rules for a smiling face:
 * <p>
 * 1. Each smiley face must contain a valid pair of eyes.Eyes can be marked as : or ;
 * 2. A smiley face can have a nose but it does not have to.Valid characters for a nose are - or ~
 * 3. Every smiling face must have a smiling mouth that should be marked with either ) or D
 * No additional characters are allowed except for those mentioned.
 * <p>
 * Valid smiley face examples: :) :D ;-D :~)
 * Invalid smiley faces: ;( :> :} :]
 * <p>
 * Example
 * countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
 * countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
 * countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;
 * <p>
 * Note
 * In case of an empty array return 0. You will not be tested with invalid input (input will always
 * be an array). Order of the face (eyes, nose, mouth) elements will always be the same.
 */
public class SmileFaces {

    private static final Set<String> smileyFaces = new HashSet<>(16);

    static {
        smileyFaces.add(":)");
        smileyFaces.add(":D");
        smileyFaces.add(";)");
        smileyFaces.add(";D");

        smileyFaces.add(":-D");
        smileyFaces.add(":-)");
        smileyFaces.add(":~D");
        smileyFaces.add(":~)");

        smileyFaces.add(";-D");
        smileyFaces.add(";-)");
        smileyFaces.add(";~D");
        smileyFaces.add(";~)");
    }

    public static int countSmileys(List<String> arr) {
        // Just Smile :)
        return (int) (arr.stream().filter(smileyFaces::contains).count());
    }

    public static int countSmileysCleverSolution(List<String> arr) {
        return (int)arr.stream().filter( x -> x.matches("[:;][-~]?[)D]")).count();
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add(":)");
        a.add(":D");
        a.add(":-}");
        a.add(":-()");
        // expected:2, actual:2
        System.out.println(countSmileys(a));

        List<String> b = new ArrayList<>();
        b.add(":)");
        b.add("XD");
        b.add(":0}");
        b.add("x:-");
        b.add("):-");
        b.add("D:");
        // expected:1, actual:1
        System.out.println(countSmileys(b));

        List<String> c = new ArrayList<>();
        c.add(":)");
        c.add(":D");
        c.add("X-}");
        c.add("xo)");
        c.add(":X");
        c.add(":-3");
        c.add(":3");
        // expected:2, actual:2
        System.out.println(countSmileys(c));

        List<String> d = new ArrayList<>();
        d.add(":)");
        d.add(":)");
        d.add("x-]");
        d.add(":ox");
        d.add(";-(");
        d.add(";-)");
        d.add(";~(");
        d.add(":~D");
        // expected:4, actual:4
        System.out.println(countSmileys(d));
    }
}
