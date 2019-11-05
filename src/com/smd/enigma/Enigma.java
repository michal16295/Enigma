package com.smd.enigma;

public class Enigma {
    private Rotor rotor1;
    private Rotor rotor2;
    private Rotor rotor3;
    private Board plugBoard;
    private Reflector reflector;


    public Enigma(Rotor r1, Rotor r2, Rotor r3, Board plugBoard, Reflector reflector) {
        this.rotor1 = r1;
        this.rotor2 = r2;
        this.rotor3 = r3;
        this.plugBoard = plugBoard;
        this.reflector = reflector;
    }

    public char cipher(char c) {
        char newChar = c;
        rotor1.incRingPosition();
 //       if (rotor1.isNotch()) {
  //          rotor2.incRingPosition();
   //         if (rotor2.isNotch()) {
   //             rotor3.incRingPosition();
          //  }
 //       }
        newChar = plugBoard.cipherChar(c);
        newChar = rotor1.cipherChar(newChar);
 //       newChar = rotor2.cipherChar(newChar);
 //       newChar = rotor3.cipherChar(newChar);
       newChar = reflector.cipherChar(newChar);
  //      newChar = rotor3.cipherChar(newChar);
  //      newChar = rotor2.cipherChar(newChar);
        newChar = rotor1.cipherCharReverse(newChar);
        newChar = plugBoard.cipherChar(newChar);
        return newChar;

    }

    public Rotor getRotor1() {
        return rotor1;
    }

    public void setRotor1(Rotor rotor1) {
        this.rotor1 = rotor1;
    }

    public Rotor getRotor2() {
        return rotor2;
    }

    public void setRotor2(Rotor rotor2) {
        this.rotor2 = rotor2;
    }

    public Rotor getRotor3() {
        return rotor3;
    }

    public void setRotor3(Rotor rotor3) {
        this.rotor3 = rotor3;
    }

    public Board getPlugBoard() {
        return plugBoard;
    }

    public void setPlugBoard(Board plugBoard) {
        this.plugBoard = plugBoard;
    }

    public Reflector getReflector() {
        return reflector;
    }

    public void setReflector(Reflector reflector) {
        this.reflector = reflector;
    }
}