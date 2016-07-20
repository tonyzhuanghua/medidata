package com.medidata.buy;

import com.medidata.common.Vaccine;

import java.util.List;

/**
 * Created by zhuanghua on 16/7/20.
 */
public interface Buy {

    void purchase(String name, double basicPrice, int discountType);

    void purchaseBloodTest(String name, double basicPrice, boolean insured, int discountType);

    void purchaseVaccine(String name, double basicPrice, List<Vaccine> vaccines, int discountType);

    double priceBeforeDiscount();

    double priceAfterDiscount();
}
