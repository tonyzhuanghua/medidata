package medical.service;

/**
 * Created by zhuanghua on 16/7/20.
 */
public class XRay extends Service {

    private double price = 150;

    @Override
    public double getPrice() {
        return price;
    }
}
