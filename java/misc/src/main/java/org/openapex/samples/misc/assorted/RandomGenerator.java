package org.openapex.samples.misc.assorted;

import java.util.Random;

public class RandomGenerator {
    public static void main(String[] args) {
        Random randomizer = new Random();
        for (int i =0; i< 20; i++) {
            // (USING HARD-CODED MIN-MAX VALUES FOR TESTING)
            int max = 18;
            int min = 14;

            String syear = Integer.toString(randomizer.nextInt((max + 1 - min) ) + min);
            System.out.println(syear);
        }
    }
}
