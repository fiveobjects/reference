package org.openapex.samples.basic;

import java.util.Scanner;

public class ScannerUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Item name, item price and item quantity
        System.out.println("Enter item name");
        String name = scanner.nextLine();
        System.out.println("Enter item price");
        int price = scanner.nextInt();
        System.out.println("Enter item quantity");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter item description");
        String description = scanner.nextLine();
        System.out.println(name +", "+ price +", "+ quantity+", "+description);
    }
}
