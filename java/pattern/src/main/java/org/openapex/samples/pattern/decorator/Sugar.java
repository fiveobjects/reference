package org.openapex.samples.pattern.decorator;

/**
 * An additive (decorator) to beverage - sugar.
 */
public class Sugar extends BeverageDecorator {
    public Sugar(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public void make() {
        System.out.println("Adding Sugar");
        super.make();
    }

    @Override
    public double getPrice() {
        return 1.0d + super.getPrice();
    }
}
