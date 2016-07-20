package com.medidata.doer;

import com.medidata.discount.PercentageDiscount;
import com.medidata.medical.CommonService;
import com.medidata.medical.MedicalService;

/**
 * Created by zhuanghua on 16/7/20.
 */
public class InsuredBloodTestDoer implements doer {
    private boolean isInsured;
    private double percentage;

    public InsuredBloodTestDoer(boolean isInsured, double percentage) {
        this.isInsured = isInsured;
        this.percentage = percentage;
    }

    public MedicalService medicalServiceFactory(String name, double price) {

        MedicalService commonService = new CommonService(name,price);
        double totalPrice = commonService.getTotalPrice();
        if(isInsured) totalPrice=totalPrice*0.85;
        commonService.setDiscountStrategy(new PercentageDiscount(totalPrice,percentage));
        return commonService;
    }
}
