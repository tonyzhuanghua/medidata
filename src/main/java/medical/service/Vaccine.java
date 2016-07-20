package medical.service;

/**
 * Created by zhuanghua on 16/7/20.
 */
public class Vaccine extends Service {

    private double price = 27.5f;

    double extendUnit = 15;

    @Override
    public double getPrice() {
        return price + this.extendUnit * this.extendCount;
    }
}
