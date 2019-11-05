package com.smd.enigma;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        //board.defaultBoard();


        Rotor rotor1 = new Rotor(3, 0, 0);
        Rotor rotor2 = new Rotor(2, 0, 0);
        Rotor rotor3 = new Rotor(1, 0, 0);
        Reflector ref = new Reflector();


        Enigma enigma = new Enigma(rotor1, rotor2, rotor3, board, ref);
        System.out.print(enigma.cipher('e'));
        System.out.print(enigma.cipher('n'));
        System.out.print(enigma.cipher('i'));
        System.out.print(enigma.cipher('g'));
        System.out.print(enigma.cipher('m'));
        System.out.print(enigma.cipher('a'));
        System.out.println();


    }
}