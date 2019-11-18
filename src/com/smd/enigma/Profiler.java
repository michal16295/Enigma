package com.smd.enigma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Profiler {
    private static final Random random = new Random();
    private static final int NUMBER_OF_RUNS = 1_000_000;

    public static void main(String[] args) {
        long startTime;
        String[] s = {"I", "II", "III", "IV", "V"};
        try {
            // Wait for user input before starting the loop
            System.out.println("Press enter to start the profiler - number of iterations: " + NUMBER_OF_RUNS);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();
        System.out.println("Began running - start time: " + startTime);
        Rotor r1 = new Rotor("I", 'a', 'a');
        Rotor r2 = new Rotor("I", 'a', 'a');
        Rotor r3 = new Rotor("I", 'a', 'a');
        Board b = new Board();
        Enigma e = new Enigma(r1, r2, r3, b);
        for (int i = 0; i < NUMBER_OF_RUNS; ++i) {
            try {
                b.setBoard(randomString(10, false));
                randomRotor(r1);
                randomRotor(r2);
                randomRotor(r3);
            } catch (Exception err) {
                err.printStackTrace();
            }
            e.cipherStr(randomString(15, true));
        }
        System.out.println("Finished - Took: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static void randomRotor(Rotor r) {
        String[] s = {"I", "II", "III", "IV", "V"};
        char c1 = (char) (random.nextInt(26) + 'a');
        char c2 = (char) (random.nextInt(26) + 'a');
        String type = s[random.nextInt(s.length)];
        r.setRotor(type);
        r.setRingPosition(c1 - 'a');
        r.setRingSettings(c2 - 'a');
    }

    private static String randomString(int targetStringLength, boolean allowRepetitions) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            char chr = (char) randomLimitedInt;
            if (!allowRepetitions) {
                if (buffer.indexOf("" + chr) > -1) {
                    --i;
                    continue;
                }
            }
            buffer.append(chr);
        }
        return buffer.toString();
    }
}
