/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.est.sale.rsacipher;

import java.math.BigInteger;

/**
 * @author Younes-Nait-Bakkou
 */
public class RSACipher {
    // PGCD (Plus Grand Commun Diviseur)
    public static BigInteger calculateGCD(BigInteger a, BigInteger b) {
        return b.equals(BigInteger.ZERO) ? a : calculateGCD(b, a.remainder(b));
    }

    // Le module: N
    public static BigInteger calculateModulus(BigInteger p, BigInteger q) {
        return p.multiply(q);
    }

    // L'indicatrice d'Euler: φ(N)
    public static BigInteger calculateEulerTotient(BigInteger p, BigInteger q) {
        BigInteger newP = p.subtract(BigInteger.ONE);
        BigInteger newQ = q.subtract(BigInteger.ONE);

        BigInteger phi = newP.multiply(newQ);

        return phi;
    }

    // Exposant public ()
    public static BigInteger calculatePublicExponent(BigInteger phi) {
        BigInteger coprime = BigInteger.valueOf(2);

        while (true) {
            BigInteger gcd = calculateGCD(phi, coprime);

            if (gcd.equals(BigInteger.ONE)) return coprime;

            coprime.add(BigInteger.ONE);
        }
    }

    // Exposant private ()
    public static BigInteger calculatePrivateExponent(BigInteger phi, BigInteger publicExponent) {}

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
