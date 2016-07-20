package medical.order;

import medical.service.BloodTest;
import medical.service.Service;

import java.util.List;

/**
 * Created by zhuanghua on 16/7/20.
 */
public class OrderImpl implements Order {


    public double getTotalPrice(int age, boolean insured, List<Service> list) {
        double discountRate = 1;
        double extraRate = 0.85;
        double total = 0;

        if (age < 5) {
            discountRate = 0.6f;
        } else if (age >= 65 && age <= 70) {
            discountRate = 0.4f;
        } else if (age > 70) {
            discountRate = 0.1f;
        }


        for (Service s : list) {
            double price = s.getPrice();
            if (insured && s instanceof BloodTest) {
                price = price * extraRate;
            }
            total += price;
        }
        return total * discountRate;
    }
}
