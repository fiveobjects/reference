package org.openapex.samples.pattern.decorator;

/**
 * A type of beverage - coffee.
 */
public class Coffee implements IBeverage {

    public void make() {
        System.out.println("Making the best coffee of the town.");
    }

    public double getPrice() {
        return 20.0;
    }
}
