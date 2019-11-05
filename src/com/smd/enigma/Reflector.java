package com.smd.enigma;

public class Reflector {
    private final int size = 26;
    private char[] ref;
    private String str = "yruhqsldpxngokmiebfzcwvjat";
    private int ringPosition;

    public Reflector() {
        this.ref = new char[26];
        ref = str.toCharArray();
        this.ringPosition = 0;
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
