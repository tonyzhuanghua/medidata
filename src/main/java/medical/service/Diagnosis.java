package medical.service;

/**
 * Created by zhuanghua on 16/7/20.
 */
public class Diagnosis extends Service {

    private double price = 60;

    @Override
    public double getPrice() {
        return price;
    }
}
