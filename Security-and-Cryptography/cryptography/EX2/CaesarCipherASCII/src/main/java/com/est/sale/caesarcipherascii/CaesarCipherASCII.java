/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.est.sale.caesarcipherascii;

/**
 * @author Younes-Nait-Bakkou
 */
public class CaesarCipherASCII {
    static int ALPHABET_LENGTH = 26; // Number of letters in alphabet
    static int ASCII_LOWERCASE_A = 97; // letter "a" in ASCII
    static int ASCII_CASE_OFFSET = 32; // 97(a) - 32 = 65(A)

    // codageASCII
    public static String encrypt(int n, String phrase) {
        String result = "";

        for (char c : phrase.toCharArray()) {
            int charASCII = (int) c;

            boolean isLowerCase =
                    ASCII_LOWERCASE_A <= charASCII
                            && charASCII < (ASCII_LOWERCASE_A + ALPHABET_LENGTH);

            boolean isUpperCase =
                    (ASCII_LOWERCASE_A - ASCII_CASE_OFFSET) <= charASCII
                            && charASCII
                                    < (ASCII_LOWERCASE_A - ASCII_CASE_OFFSET) + ALPHABET_LENGTH;

            boolean isLetter = isLowerCase || isUpperCase;

            if (!isLetter) {
                result += c;
                continue;
            }

            int offset = isUpperCase ? ASCII_CASE_OFFSET : 0;
            int indexInAlphabet = charASCII - (ASCII_LOWERCASE_A - offset); // 0 - 25
            int shiftNumFromStart =
                    (indexInAlphabet + n) % ALPHABET_LENGTH; // number to shift from "a"

            int shiftedCharASCII = (ASCII_LOWERCASE_A - offset) + shiftNumFromStart;
            char shiftedChar = (char) shiftedCharASCII;

            result += shiftedChar;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(encrypt(3, "BCZ"));
    }
}
