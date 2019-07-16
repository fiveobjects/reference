package org.openapex.samples.pattern.decorator;

/**
 * Beverage machine is the user interface for ordering
 * various beverages.
 */
public class BeverageMachine {
    public static void main(String[] args) {
        IBeverage mySweetTea = new Milk(new Sugar(new Tea()));
        mySweetTea.make();
        System.out.println("Price: " + mySweetTea.getPrice());
        System.out.println();
        IBeverage myBlackCoffee = new Sugar(new Coffee());
        myBlackCoffee.make();
        System.out.println("Price: " + myBlackCoffee.getPrice());
    }
}
