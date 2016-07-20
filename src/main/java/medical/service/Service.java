package medical.service;

/**
 * Created by zhuanghua on 16/7/20.
 */
public abstract class Service {

    protected double extendUnit = 0;
    protected int extendCount = 0;

    public abstract double getPrice();

    public void setExtendCount(int extendCount){
        this.extendCount = extendCount;
    }
}
