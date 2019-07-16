package org.openapex.samples.pattern.decorator;

/**
 * The common ancestor of all beverage decorators.
 */
public abstract class BeverageDecorator implements IBeverage {
    /**
     * Holds reference of main beverage the decorator is going to decorate.
     */
    private final IBeverage beverage;
    public BeverageDecorator (IBeverage beverage){
        this.beverage = beverage;
    }
    public void make() {
        this.beverage.make();
    }

    public double getPrice() {
        return this.beverage.getPrice();
    }
}
