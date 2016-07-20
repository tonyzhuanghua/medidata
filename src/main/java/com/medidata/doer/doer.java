package com.medidata.doer;

import com.medidata.medical.MedicalService;

/**
 * Created by zhuanghua on 16/7/20.
 */


public interface doer {

    MedicalService medicalServiceFactory(String serviceName, double price);
}
