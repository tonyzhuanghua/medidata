package com.medidata.common;

/**
 * Created by zhuanghua on 16/7/20.
 */
public enum ServiceType {
    DIAGNOSIS("Diagnosis"),
    X_RAY("X_ray"),
    BLOOD_TEST("Blood_test");


    private String value;

    private ServiceType(final String value)
    {
        this.value = value;
    }


    public String value()
    {
        return value;
    }
}
