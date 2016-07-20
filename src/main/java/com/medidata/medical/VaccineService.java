package com.medidata.medical;

import com.medidata.common.Vaccine;

import java.util.List;

/**
 * Created by zhuanghua on 16/7/20.
 */
public class VaccineService extends MedicalService {

    private List<Vaccine> vaccines;

    public VaccineService(String serviceName, double price, List<Vaccine> vaccines) {
        super(serviceName, price);
        this.vaccines = vaccines;
    }

    @Override
    public double getTotalPrice() {
        //to do

        return 101;
    }
}
