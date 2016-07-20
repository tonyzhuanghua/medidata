package com.medidata.common;

/**
 * Created by zhuanghua on 16/7/20.
 */
public enum DiscountType {
    NO_DISCOUNT(0),
    OVER_70(1),
    BETWEEN_65_70(2),
    UNDER_5(3),
    INSURANCE_HOLDER(4);


    private Integer value;

    private DiscountType(final Integer value)
    {
        this.value = value;
    }


    public Integer value()
    {
        return value;
    }
}
