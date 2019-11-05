package com.smd.enigma;

public class Rotor {
    private final int size = 26;
    private char[] rotor;
    private int ringPosition;
    private int ringSetting;
    private char notch;
    private String alph = "abcdefghijklmnopqrstuvwxyz";
    private String I = "ekmflgdqvzntowyhxuspaibrcj";
    private String II = "ajdksiruxblhwtmcqgznpyfvoe";
    private String III = "bdfhjlcprtxvznyeiwgakmusqo";
    private String IV = "esovpzjayquirhxlnftgkdcmwb";
    private String V = "vzbrgityupsdnhlxawmjqofeck";

    public Rotor(int type, int ringPosition, int ringSetting) {
        this.rotor = new char[this.size];
        this.setRotor(type);
        this.ringSetting = ringSetting;
        this.ringPosition = ringPosition;
    }

    public int convertCharToIndex(char c) {
        return (int) c - 97;
    }

    public char cipherChar(char c) {
        return rotor[(convertCharToIndex(c) + ringPosition) % 26];
    }

    public char cipherCharReverse(char c) {
        int i;
        for (i = 0; i < rotor.length; i++) {
            if (rotor[i] == c)
                break;
        }
        return alph.charAt(i);
    }

    public char[] getRotor() {
        return rotor;
    }

    public void setRotor(int type) {
        switch (type) {
            case 1:
                rotor = I.toCharArray();
                this.notch = 'g';
                break;
            case 2:
                rotor = II.toCharArray();
                this.notch = 'e';
                break;
            case 3:
                rotor = III.toCharArray();
                this.notch = 'v';
                break;
            case 4:
                rotor = IV.toCharArray();
                this.notch = 'j';
                break;
            case 5:
                rotor = V.toCharArray();
                this.notch = 'z';
                break;
        }
    }

    public int getRingPosition() {
        return this.ringPosition;
    }

    public void setRingPosition(int ringPosition) {
        this.ringPosition = ringPosition;
    }

    public void incRingPosition() {
        this.ringPosition++;
        if (ringPosition > 25) {
            this.ringPosition = 0;
        }
    }

    public boolean isNotch() {
        return rotor[this.ringPosition] == this.notch;
    }

    public int getRingSetting() {
        return this.ringSetting;
    }

}

