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

    public Rotor(String type, String ringPosition, String ringSetting) {
        this.rotor = new char[this.size];
        this.setRotor(type);
        this.ringSetting = convertCharToIndex(Character.toLowerCase(ringSetting.toCharArray()[0]));
        this.ringPosition = convertCharToIndex(Character.toLowerCase(ringPosition.toCharArray()[0]));
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

    public void setRotor(String type) {
        switch (type) {
            case "I":
                rotor = I.toCharArray();
                this.notch = 'q';
                break;
            case "II":
                rotor = II.toCharArray();
                this.notch = 'e';
                break;
            case "III":
                rotor = III.toCharArray();
                this.notch = 'v';
                break;
            case "IV":
                rotor = IV.toCharArray();
                this.notch = 'j';
                break;
            case "V":
                rotor = V.toCharArray();
                this.notch = 'z';
                break;
        }
        this.rotorReverse = new char[this.rotor.length];
        for (int i = 0; i < this.size; i++) {
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



    @Override
    public String toString() {
        return ringPosition + " " + ringSetting + " " + rotor.toString();
    }
}

