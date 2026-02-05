/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.est.sale.vigenerecipher;

/**
 * @author Younes-Nait-Bakkou
 */
public class VigenereCipher {

    static int ALPHABET_LENGTH = 26; // Number of letters in alphabet
    static int ASCII_LOWERCASE_A = 97; // letter "a" in ASCII
    static int ASCII_CASE_OFFSET = 32; // 97(a) - 32 = 65(A)

    public static boolean isASCIILowerCase(int code) {
        return ASCII_LOWERCASE_A <= code && code < (ASCII_LOWERCASE_A + ALPHABET_LENGTH);
    }

    public static boolean isASCIIUpperCase(int code) {
        return (ASCII_LOWERCASE_A - ASCII_CASE_OFFSET) <= code
                && code < (ASCII_LOWERCASE_A - ASCII_CASE_OFFSET) + ALPHABET_LENGTH;
    }

    public static boolean isASCIILetter(int code) {
        return isASCIIUpperCase(code) || isASCIILowerCase(code);
    }

    // codageASCII
    public static String encrypt(String phrase, String key) {
        String result = "";

        int keyIndex = 0;
        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            int charASCII = (int) c;

            boolean isCharUpperCase = isASCIIUpperCase(charASCII);

            if (!isASCIILetter(charASCII)) {
                result += c;
                continue;
            }

            int charKeyIndex = keyIndex % key.length();
            int charKeyASCII = (int) key.charAt(charKeyIndex);

            boolean isCharKeyUpperCase = isASCIIUpperCase(charKeyASCII);

            if (!isASCIILetter(charKeyASCII)) {
                result += c;
                continue;
            }

            int charKeyOffset = isCharKeyUpperCase ? ASCII_CASE_OFFSET : 0;
            int charKeyIndexInAlphabet = charKeyASCII - (ASCII_LOWERCASE_A - charKeyOffset);

            int n = charKeyIndexInAlphabet;
            int charOffset = isCharUpperCase ? ASCII_CASE_OFFSET : 0;

            int indexInAlphabet = charASCII - (ASCII_LOWERCASE_A - charOffset); // 0 - 25
            int shiftNumFromStart =
                    (indexInAlphabet + n) % ALPHABET_LENGTH; // number to shift from "a"

            int shiftedCharASCII = (ASCII_LOWERCASE_A - charOffset) + shiftNumFromStart;
            char shiftedChar = (char) shiftedCharASCII;

            result += shiftedChar;
            keyIndex += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("BBBCBD", "abc"));
    }
}
