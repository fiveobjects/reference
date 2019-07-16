package org.openapex.samples.pattern.decorator;

/**
 * An additive (decorator) to beverage - milk.
 */
public class Milk extends BeverageDecorator {
    public Milk(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public void make() {
        System.out.println("Adding Milk.");
        super.make();
    }

    @Override
    public double getPrice() {
        return 2.0d + super.getPrice();
    }
}
