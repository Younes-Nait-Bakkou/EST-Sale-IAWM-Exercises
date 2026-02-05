/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.est.sale.caesarcipher;

/**
 * @author Younes-Nait-Bakkou
 */
public class CaesarCipher {

    static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // decalage
    public static String shiftAlphabetBy(int n) {

        return ALPHABET.substring(0 + n, ALPHABET.length()) + ALPHABET.substring(0, 0 + n);
    }

    // codage
    public static String encrypt(int n, String phrase) {
        String shiftedAlphabet = shiftAlphabetBy(n);
        String result = "";

        for (char c : phrase.toCharArray()) {
            int indexInAlphabet = ALPHABET.indexOf(Character.toLowerCase(c));

            if (indexInAlphabet == -1) {
                result = result + c;
                continue;
            }

            char shiftedChar = shiftedAlphabet.charAt(indexInAlphabet);

            if (Character.isUpperCase(c)) {
                result = result + Character.toUpperCase(shiftedChar);
                continue;
            }

            result = result + shiftedChar;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(shiftAlphabetBy(1));
        System.out.println(encrypt(1, "Hello World!"));
    }
}
