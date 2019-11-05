package com.smd.enigma;

public class Rotor {
    private final int size = 26;
    private char[] rotor;
    private char[] rotorReverse;
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
        return (int) c - 'a';
    }

    public char cipherChar(char c) {
        int chcode = (convertCharToIndex(c) + getOffset() + size) % size;
        return (char)((convertCharToIndex(rotor[chcode]) + size - getOffset()) % size + 'a');
    }

    public char cipherCharReverse(char c) {
        int chcode = (convertCharToIndex(c) + getOffset() + size) % size;
        return (char)((convertCharToIndex(rotorReverse[chcode]) + size - getOffset()) % size + 'a');
    }

    private int getOffset() {
        return ringPosition - ringSetting;
    }

    public char[] getRotor() {
        return rotor;
    }

    public void setRotor(int type) {
        switch (type) {
            case 1:
                rotor = I.toCharArray();
                this.notch = 'q';
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
        this.rotorReverse = new char[this.rotor.length];
        for (int i = 0; i < 26; i++) {
            this.rotorReverse[(this.rotor[i] - 'a')] = (char) (i + 'a');
        }
    }

    public int getRingPosition() {
        return this.ringPosition;
    }

    public void setRingPosition(int ringPosition) {
        this.ringPosition = ringPosition;
    }

    public void incRingPosition() {
        ringPosition = (ringPosition + 1) % size;
    }

    public boolean isNotch() {
        return rotor[this.ringPosition] == this.notch;
    }

    public int getRingSetting() {
        return this.ringSetting;
    }

}

