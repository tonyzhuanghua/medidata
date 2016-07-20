package com.medidata.doer;

import com.medidata.discount.PercentageDiscount;
import com.medidata.medical.CommonService;
import com.medidata.medical.MedicalService;

/**
 * Created by zhuanghua on 16/7/20.
 */
public class CommonServiceDoer implements doer {

    private double percentage;

    public CommonServiceDoer(double percentage) {
        this.percentage = percentage;
    }

    public MedicalService medicalServiceFactory(String name, double price) {
        MedicalService commonService = new CommonService(name,price);
        double totalPrice = commonService.getTotalPrice();
        commonService.setDiscountStrategy(new PercentageDiscount(totalPrice,percentage));
        return commonService;
    }
}
