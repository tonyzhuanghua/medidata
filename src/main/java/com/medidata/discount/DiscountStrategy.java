package com.medidata.discount;

/**
 * Created by zhuanghua on 16/7/20.
 */
public abstract class DiscountStrategy {

    protected double servicePrice = 0.0;

    public DiscountStrategy(double price) {
        servicePrice = price;
    }

    abstract public double calculateDiscount();
}
