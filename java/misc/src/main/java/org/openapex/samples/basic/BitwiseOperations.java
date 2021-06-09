package org.openapex.samples.basic;

public class BitwiseOperations {
    public static void main(String[] args) {
        long num = 1026832071211166612L;
        for(int i = 0; i < 64; i++){
            boolean set = (num & (1L<<i))>0;
            System.out.println("Bit "+i+ "set?: "+set);
        }
        //System.out.println(num & (2L<<34));
    }
}
