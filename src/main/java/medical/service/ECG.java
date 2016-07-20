package medical.service;

/**
 * Created by zhuanghua on 16/7/20.
 */
public class ECG extends Service {

    private double price = 200.40f;

    @Override
    public double getPrice() {
        return price;
    }
}
