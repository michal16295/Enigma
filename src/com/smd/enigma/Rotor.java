package com.smd.enigma;

import java.util.Arrays;

public class Rotor {
    private final int size = 26;
    private char[] rotor;
    private char[] rotorReverse;
    private int ringPosition;
    private int ringSetting;
    private char notch;
    private char[] alphabet= "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String I = "ekmflgdqvzntowyhxuspaibrcj";
    private String II = "ajdksiruxblhwtmcqgznpyfvoe";
    private String III = "bdfhjlcprtxvznyeiwgakmusqo";
    private String IV = "esovpzjayquirhxlnftgkdcmwb";
    private String V = "vzbrgityupsdnhlxawmjqofeck";

    private String RI = "uwygadfpvzbeckmthxslrinqoj";
    private String RII = "ajpczwrlfbdkotyuqgenhxmivs";
    private String RIII = "tagbpcsdqeufvnzhyixjwlrkom";
    private String RIV = "hzwvartnlgupxqcejmbskdyoif";
    private String RV = "qcylxwenftzosmvjudkgiarphb";

    public Rotor(String type, char ringPosition, char ringSetting) {
        this.setRotor(type);
        this.ringSetting = convertCharToIndex(ringSetting);
        this.ringPosition = convertCharToIndex(ringPosition);
    }

    public int convertCharToIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return (int) c - 'a';
        }
        return (int) c - 'A';
    }

    public char cipherChar(char c) {
        int offset = getOffset();
        int chcode = (convertCharToIndex(c) + offset + size) % size;
        return (char)((convertCharToIndex(rotor[chcode]) + size - offset) % size + 'a');
    }

    public char cipherCharReverse(char c) {
        int offset = getOffset();
        int chcode = (convertCharToIndex(c) + offset + size) % size;
        return (char)((convertCharToIndex(rotorReverse[chcode]) + size - offset) % size + 'a');
    }

    private int getOffset() {
        return ringPosition - ringSetting;
    }

    public char[] getRotor() {
        return rotor;
    }

    public void setRotor(String type) {
        switch (type) {
            case "I":
                rotor = I.toCharArray();
                rotorReverse = RI.toCharArray();
                this.notch = 'q';
                break;
            case "II":
                rotor = II.toCharArray();
                rotorReverse = RII.toCharArray();
                this.notch = 'e';
                break;
            case "III":
                rotor = III.toCharArray();
                rotorReverse = RIII.toCharArray();
                this.notch = 'v';
                break;
            case "IV":
                rotor = IV.toCharArray();
                rotorReverse = RIV.toCharArray();
                this.notch = 'j';
                break;
            case "V":
                rotor = V.toCharArray();
                rotorReverse = RV.toCharArray();
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
        ringPosition = (ringPosition + 1) % size;
    }

    public boolean isNotch() {
        return alphabet[this.ringPosition] == this.notch;
    }

    public int getRingSetting() {
        return this.ringSetting;
    }

    @Override
    public String toString() {
        return ringPosition + " " + ringSetting + " " + Arrays.toString(rotor);
    }

    public void setRingSettings(int ringSettings) {
        this.ringSetting = ringSettings;
    }
}

