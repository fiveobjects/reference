package org.openapex.samples.pattern.decorator;

/**
 * The primary interface for beverages. All beverages including the decorators
 * (additives) are going to implement this.
 */
public interface IBeverage {
    void make();
    double getPrice();
}
