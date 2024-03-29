package com.smd.enigma;

public class Board {
    private char[] plugs;

    public Board() {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        plugs = alph.toCharArray();
    }

    public Board(String chars) throws Exception {
        setBoard(chars);
    }

    public void setBoard(String chars) throws Exception {
        chars = chars.replaceAll("\\s+", "").toLowerCase();
        String alph = "abcdefghijklmnopqrstuvwxyz";
        plugs = alph.toCharArray();
        if (!chars.equals("")) {
            for (int i = 0; i + 1 < chars.length(); i += 2) {
                if (isPlugTaken(chars.charAt(i)) || isPlugTaken(chars.charAt(i + 1))) {
                    throw new Exception("Plug already taken");
                } else if (chars.charAt(i) == chars.charAt(i + 1)) {
                    throw new IllegalArgumentException("Same character plug");
                }
                if (i + 1 < chars.length()) {
                    setPlugs(chars.charAt(i), chars.charAt(i + 1));
                }
            }
        }
    }

    public void defaultBoard() {
        String def = "swaqnpfovyuxmkclhtzj";
        for (int i = 0; i < def.length(); i += 2) {
            setPlugs(def.charAt(i), def.charAt(i + 1));
        }
    }

    public int convertCharToIndex(char c) {
        return (int) c - 97;
    }

    public char convertIdexToChar(int num) {
        num += 97;
        return (char) num;
    }

    public void setPlugs(char plugA, char plugB) {
        disconnectPlugs(plugA);
        disconnectPlugs(plugB);
        plugs[convertCharToIndex(plugA)] = plugB;
        plugs[convertCharToIndex(plugB)] = plugA;
    }

    public char[] getPlugs() {
        return plugs;
    }

    public String cipher(String text) {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            newText.append(plugs[convertCharToIndex(text.charAt(i))]);
        }
        return newText.toString();
    }

    public boolean isPlugTaken(char plug) {
        return plugs[convertCharToIndex(plug)] != plug;
    }

    public void disconnectPlugs(char plugA) {
        if (plugs[convertCharToIndex(plugA)] != 0) {
            char a = plugs[convertCharToIndex(plugA)];
            plugs[convertCharToIndex(a)] = a;
        }

    }

    public char cipherChar(char c) {
        return plugs[convertCharToIndex(c)];
    }

    @Override
    public String toString() {
        return String.copyValueOf(plugs);
    }
}

