package medical.test;


import medical.order.Order;
import medical.order.OrderImpl;
import medical.service.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhuanghua on 16/7/20.
 * 1. Diagnosis £60
 * <p>
 * 2. X-Ray £150
 * <p>
 * 3. Blood Test £78
 * <p>
 * 4. ECG £200.40
 * <p>
 * 5. Vaccine £27.50 (service) + £15 (for each vaccine)
 */
public class OrderImplTest {

    Order order = new OrderImpl();
    private static final double DELTA = 0.0001;

    /*
    * given not insured citizen aged over 70
    * **/
    @Test
    public final void testOrder1() {
        List<Service> list = new ArrayList<Service>();
        Service s1 = new Diagnosis(); // 60
        list.add(s1);
        Service s2 = new BloodTest(); // 78
        list.add(s2);
        Service s3 = new Vaccine(); //27.5+30 = 57.5
        s3.setExtendCount(2);
        list.add(s3);
        Service s4 = new XRay(); //150
        list.add(s4);

        double price = order.getTotalPrice(80, false, list); // total original = 345.5

        assertEquals(price, 34.55, DELTA); //after discount should be 34.55
    }


    /*
    * given insured citizen aged between 65 and 70
    * and take blood test
    * **/

    @Test
    public final void testOrder2() {
        List<Service> list = new ArrayList<Service>();
        Service s1 = new Diagnosis(); // 60
        list.add(s1);
        Service s2 = new BloodTest(); // 78
        list.add(s2);

        double price = order.getTotalPrice(70, true, list); // total original = 138

        assertEquals(price, 50.52, DELTA); //after discount should be 60*0.4 + 78*0.4*0.85 = 50.52
    }


    /*
    * given not insured citizen aged under 5
    * **/

    @Test
    public final void testOrder3() {
        List<Service> list = new ArrayList<Service>();
        Service s1 = new Diagnosis(); // 60
        list.add(s1);
        Service s2 = new BloodTest(); // 78
        list.add(s2);
        Service s3 = new Vaccine(); //27.5+30 = 57.5
        s3.setExtendCount(2);
        list.add(s3);
        Service s4 = new XRay(); //150
        list.add(s4);
        Service s5= new ECG(); //200.4
        list.add(s5);
        double price = order.getTotalPrice(4, false, list); // total original = 545.9

        assertEquals(price, 327.54, DELTA); //after discount should be 545.9 * 0.6 = 327.54
    }
}
