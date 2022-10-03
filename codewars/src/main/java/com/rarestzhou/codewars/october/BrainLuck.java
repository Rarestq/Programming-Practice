package com.rarestzhou.codewars.october;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/10/3 8:32 PM
 * @description: https://www.codewars.com/kata/526156943dfe7ce06200063e/train/java
 * <p>
 * Inspired from real-world (Brainf**k)[https://en.wikipedia.org/wiki/Brainfuck], we want to create an
 * interpreter of that language which will support the following instructions:
 * <p>
 * > increment the data pointer (to point to the next cell to the right).
 * < decrement the data pointer (to point to the next cell to the left).
 * + increment (increase by one, truncate overflow: 255 + 1 = 0) the byte at the data pointer.
 * - decrement (decrease by one, treat as unsigned byte: 0 - 1 = 255 ) the byte at the data pointer.
 * . output the byte at the data pointer.
 * , accept one byte of input, storing its value in the byte at the data pointer.
 * [ if the byte at the data pointer is zero, then instead of moving the instruction pointer forward to
 * the next command, jump it forward to the command after the matching ] command.
 * ] if the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward
 * to the next command, jump it back to the command after the matching [ command.
 * The function will take in input...
 * <p>
 * the program code, a string with the sequence of machine instructions,
 * the program input, a string, possibly empty, that will be interpreted as an array of bytes using
 * each character's ASCII code and will be consumed by the , instruction
 * ... and will return ...
 * <p>
 * the output of the interpreted code (always as a string), produced by the . instruction.
 * Implementation-specific details for this Kata:
 * <p>
 * Your memory tape should be large enough - the original implementation had 30,000 cells but a few
 * thousand should suffice for this Kata
 * Each cell should hold an unsigned byte with wrapping behavior (i.e. 255 + 1 = 0, 0 - 1 = 255),
 * initialized to 0
 * The memory pointer should initially point to a cell in the tape with a sufficient number (e.g. a few
 * thousand or more) of cells to its right. For convenience, you may want to have it point to the
 * leftmost cell initially
 * You may assume that the , command will never be invoked when the input stream is exhausted
 * Error-handling, e.g. unmatched square brackets and/or memory pointer going past the leftmost cell is
 * not required in this Kata. If you see test cases that require you to perform error-handling then
 * please open an Issue in the Discourse for this Kata (don't forget to state which programming language
 * you are attempting this Kata in).
 */
public class BrainLuck {

    private String code;
    private ArrayList<Byte> memory;

    public BrainLuck(String code) {
        this.code = code;
        memory = new ArrayList<>();
    }

    // TODO by wuxiu 2022/10/3 this method has sth unreasonable
    public String process(String input) {
        int inputPointer = 0, memoryPointer = 0;
        StringBuilder result = new StringBuilder();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = code.charAt(i);
            switch (c) {
                case '>':
                    // move the pointer to the next cell to the right
                    memoryPointer++;
                    break;
                case '<':
                    // move the pointer to the next cell to the left
                    memoryPointer--;
                    break;
                case '+':
                    // increment (increase by one, truncate overflow: 255 + 1 = 0) the byte at the data
                    // pointer.
                    saveToMemory(memoryPointer, (char) (getFromMemory(memoryPointer) + 1));
                    break;
                case '-':
                    // decrement (decrease by one, treat as unsigned byte: 0 - 1 = 255 ) the byte at
                    // the data pointer.
                    saveToMemory(memoryPointer, (char) (getFromMemory(memoryPointer) - 1));
                    break;
                case '.':
                    // output the byte at the data pointer.
                    result.append(getFromMemory(memoryPointer));
                    break;
                case ',':
                    // accept one byte of input, storing its value in the byte at the data pointer.
                    saveToMemory(memoryPointer, input.charAt(inputPointer));
                    inputPointer++;
                    break;
                case '[':
                    // if the byte at the data pointer is zero, then instead of moving the instruction
                    // pointer forward to the next command, jump it forward to the command after the
                    // matching ] command
                    if (getFromMemory(memoryPointer) == 0) {
                        i = getMatching('[', ']', i, 1);
                    }
                    break;
                case ']':
                    // if the byte at the data pointer is nonzero, then instead of moving the
                    // instruction pointer forward to the next command, jump it back to the command
                    // after the matching [ command.
                    if (getFromMemory(memoryPointer) != 0) {
                        i = getMatching(']', '[', i, -1);
                    }
                    break;
                default:
                    // should never be reached here
            }
        }
        return result.toString();
    }

    public String processV1(String input) {
        System.out.println(code);
        Stack<Integer> brack = new Stack<>();
        List<Byte> bytes = new ArrayList<>();
        int pointer = 0;
        StringBuilder out = new StringBuilder();
        bytes.add((byte) 0);
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            switch (c) {
                case '>':
                    // move the pointer to the next cell to the right
                    pointer++;
                    if (pointer == bytes.size()) {
                        bytes.add((byte) 0);
                    }
                    break;
                case '<':
                    // move the pointer to the next cell to the left
                    pointer--;
                    if (pointer == -1) {
                        bytes.add(0, (byte) 0);
                        pointer = 0;
                    }
                    break;
                case '+':
                    // increment (increase by one, truncate overflow: 255 + 1 = 0) the byte at the data
                    // pointer.
                    bytes.set(pointer, (byte) (bytes.get(pointer) + 1));
                    break;
                case '-':
                    // decrement (decrease by one, treat as unsigned byte: 0 - 1 = 255 ) the byte at
                    // the data pointer.
                    bytes.set(pointer, (byte) (bytes.get(pointer) - 1));
                    break;
                case '.':
                    // output the byte at the data pointer.
                    out.append((char) (int) bytes.get(pointer));
                    break;
                case ',':
                    // accept one byte of input, storing its value in the byte at the data pointer.
                    if (!input.isEmpty()) {
                        bytes.set(pointer, (byte) (int) input.charAt(0));
                        input = input.substring(1);
                    }
                    break;
                case '[':
                    // if the byte at the data pointer is zero, then instead of moving the instruction
                    // pointer forward to the next command, jump it forward to the command after the
                    // matching ] command
                    if (bytes.get(pointer) == 0) {
                        int left = 1, k = i;
                        while (left != 0) {
                            k++;
                            if (code.charAt(k) == '[') {
                                left++;
                            } else if (code.charAt(k) == ']') {
                                left--;
                            }
                        }
                        i = k;
                    } else {
                        brack.push(i);
                    }
                    break;
                case ']':
                    // if the byte at the data pointer is nonzero, then instead of moving the
                    // instruction pointer forward to the next command, jump it back to the command
                    // after the matching [ command.
                    if (bytes.get(pointer) != 0) {
                        i = brack.peek();
                    } else {
                        brack.pop();
                    }
                    break;
                default:
                    // should never be reached here
            }
        }
        return out.toString();
    }

    private int getMatching(char input, char match, int index, int dir) {
        int count = 0;
        while (index > 0 && index <= code.length()) {
            if (code.charAt(index) == input) {
                count++;
            } else if (code.charAt(index) == match) {
                count--;
            }
            if (count == 0) {
                break;
            }
            index += dir;
        }
        return index;
    }

    private int getFromMemory(int memoryPointer) {
        if (memoryPointer >= memory.size()) {
            return 0;
        }
        return (int) memory.get(memoryPointer);
    }

    private void saveToMemory(int index, char input) {
        if (input > 255) {
            // truncate overflow: 255 + 1 = 0
            input = 0;
        }
        if (input < 0) {
            // treat as unsigned byte: 0 - 1 = 255
            input = 255;
        }
        // initialize the memory list
        for (int i = memory.size(); i <= index; i++) {
            memory.add((byte) 0);
        }
        memory.set(index, (byte) input);
    }

    public static void main(String[] args) {
        final char[] input = {8, 9};
        // Hello World!
        System.out.println(new BrainLuck("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+" +
                ".+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.")
                .processV1(String.valueOf(input[0]) + String.valueOf(input[1])));
    }
}
