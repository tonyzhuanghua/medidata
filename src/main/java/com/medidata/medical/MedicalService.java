package com.medidata.medical;

/**
 * Created by zhuanghua on 16/7/20.
 */

import com.medidata.discount.DiscountStrategy;

public abstract class MedicalService {
    protected String serviceName;
    protected double price;
    protected DiscountStrategy discountStrategy;

    public MedicalService(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }






    public double getDiscount() {
        return discountStrategy.calculateDiscount();
    }

    public double getTotalPrice() {
        return price;
    }


    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
