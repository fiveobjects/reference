package org.openapex.samples.misc.assorted;

public class BigLoop {
    public static void main(String args[]) {
        double stressCalc = 0.0001;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            //stressCalc = Math.sqrt(stressCalc);
            stressCalc += i;
        }
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
