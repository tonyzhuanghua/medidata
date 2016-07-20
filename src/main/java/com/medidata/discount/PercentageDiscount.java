package com.medidata.discount;

/**
 * Created by zhuanghua on 16/7/20.
 */
public class PercentageDiscount extends DiscountStrategy {

    private double servicePercentageDiscount;

    public PercentageDiscount(double price, double percentage) {

        super(price);
        if (percentage > 1.0) percentage = 1.0;
        servicePercentageDiscount = percentage;
    }

    @Override
    public double calculateDiscount() {

        return servicePrice * (1 - servicePercentageDiscount);
    }
}
