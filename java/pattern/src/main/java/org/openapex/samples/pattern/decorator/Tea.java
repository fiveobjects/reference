package org.openapex.samples.pattern.decorator;

/**
 * A type of beverage - tea.
 */
public class Tea implements IBeverage {
    public void make() {
        System.out.println("Making Hot Tea");
    }

    public double getPrice() {
        return 10.0;
    }
}
