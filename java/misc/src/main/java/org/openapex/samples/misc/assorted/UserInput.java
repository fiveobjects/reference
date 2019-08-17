package org.openapex.samples.misc.assorted;

import java.util.Scanner;

public class UserInput {
    public static Scanner choiceOneScanner = new Scanner(System.in);

    public static void main(String[] args) {
        choiceOneScanner.close();
        int x = choiceOneScanner.nextInt();
        System.out.println(x);
    }
}
