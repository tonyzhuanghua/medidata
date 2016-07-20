package com.medidata.buy;

import com.medidata.common.DiscountType;
import com.medidata.common.ServiceType;
import com.medidata.common.Vaccine;
import com.medidata.doer.CommonServiceDoer;
import com.medidata.doer.InsuredBloodTestDoer;
import com.medidata.medical.MedicalService;

import java.util.List;

/**
 * Created by zhuanghua on 16/7/20.
 */
public class BuyImpl implements Buy {

    double totalPriceBefore;
    double totalPriceAfter;

    public void purchase(String name, double basicPrice, int type) {

        MedicalService medicalService = null;
        if (type == DiscountType.BETWEEN_65_70.value()) {
            medicalService = new CommonServiceDoer(0.6).medicalServiceFactory(name, basicPrice);
        } else if (type == DiscountType.OVER_70.value()) {
            medicalService = new CommonServiceDoer(0.9).medicalServiceFactory(name, basicPrice);
        } else if (type == DiscountType.UNDER_5.value()) {
            medicalService = new CommonServiceDoer(0.4).medicalServiceFactory(name, basicPrice);
        }
        if (medicalService != null) {
            totalPriceBefore += medicalService.getTotalPrice();
            totalPriceAfter += medicalService.getDiscount();
        } else {
            totalPriceBefore += basicPrice;
            totalPriceAfter += basicPrice;
        }
    }

    public void purchaseBloodTest(String name, double basicPrice, boolean insured, int type) {

        if (name.equals(ServiceType.BLOOD_TEST.value())) {

            MedicalService medicalService = null;
            if (type == DiscountType.BETWEEN_65_70.value()) {
                medicalService = new InsuredBloodTestDoer(insured, 0.6).medicalServiceFactory(name, basicPrice);
            } else if (type == DiscountType.OVER_70.value()) {
                medicalService = new InsuredBloodTestDoer(insured, 0.9).medicalServiceFactory(name, basicPrice);
            } else if (type == DiscountType.UNDER_5.value()) {
                medicalService = new InsuredBloodTestDoer(insured, 0.4).medicalServiceFactory(name, basicPrice);
            }

            if (medicalService != null) {
                totalPriceBefore += medicalService.getTotalPrice();
                totalPriceAfter += medicalService.getDiscount();
            } else {
                totalPriceBefore += basicPrice;
                totalPriceAfter += basicPrice;
            }
        }
    }

    public void purchaseVaccine(String name, double basicPrice, List<Vaccine> vaccines, int type) {
//// TODO: 16/7/20
    }

    public double priceBeforeDiscount() {
        return totalPriceBefore;
    }

    public double priceAfterDiscount() {
        return totalPriceAfter;
    }
}
