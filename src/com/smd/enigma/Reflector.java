package com.smd.enigma;

public class Reflector {
    private char[] ref;

    public Reflector() {
        String str = "yruhqsldpxngokmiebfzcwvjat";
        ref = str.toCharArray();
    }

    public int convertCharToIndex(char c) {
        return (int) c - 97;
    }

    public char cipherChar(char c) {

        return ref[convertCharToIndex(c)];
    }

    public char[] getRef() {
        return ref;
    }


}
