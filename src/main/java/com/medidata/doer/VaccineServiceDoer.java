package com.medidata.doer;

import com.medidata.common.Vaccine;
import com.medidata.discount.PercentageDiscount;
import com.medidata.medical.VaccineService;
import com.medidata.medical.MedicalService;

import java.util.List;

/**
 * Created by zhuanghua on 16/7/20.
 */
public class VaccineServiceDoer implements doer {

    private double percentage;
    private List<Vaccine> vaccines;

    public VaccineServiceDoer(double percentage, List<Vaccine> vaccines) {

        this.percentage = percentage;

        this.vaccines = vaccines;
    }

    public MedicalService medicalServiceFactory(String name, double price) {
        MedicalService vaccineService = new VaccineService(name, price, vaccines);
        double totalPrice = vaccineService.getTotalPrice();
        vaccineService.setDiscountStrategy(new PercentageDiscount(totalPrice, percentage));
        return vaccineService;
    }
}
