/**
 * Created by zhuanghua on 16/7/20.
 */

import com.medidata.buy.Buy;
import com.medidata.buy.BuyImpl;
import com.medidata.common.DiscountType;
import com.medidata.common.ServiceType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuyImplTest {

    Buy buy = new BuyImpl();
    private static final double DELTA = 0.0001;

    @Test
    public final void testBuy1() {
        buy.purchase(ServiceType.DIAGNOSIS.value(), 60, DiscountType.BETWEEN_65_70.value());
        buy.purchase(ServiceType.X_RAY.value(), 150, DiscountType.BETWEEN_65_70.value());
        assertEquals(buy.priceBeforeDiscount(), 210, DELTA);
        assertEquals(buy.priceAfterDiscount(), 84, DELTA);

    }

    @Test
    public final void testBuy2() {
        buy.purchase(ServiceType.DIAGNOSIS.value(), 60, DiscountType.OVER_70.value()); //60*0.1=6
        buy.purchase(ServiceType.X_RAY.value(), 150, DiscountType.BETWEEN_65_70.value()); // 150*0.4=60
        buy.purchase(ServiceType.X_RAY.value(), 150, DiscountType.UNDER_5.value()); // 150*0.6=90
        buy.purchase(ServiceType.BLOOD_TEST.value(),78,DiscountType.NO_DISCOUNT.value()); //78
        assertEquals(buy.priceBeforeDiscount(), 438, DELTA);
        assertEquals(buy.priceAfterDiscount(), 234, DELTA);

    }


    /*
    * to test purchase blood test with & without insurance
    * **/
    @Test
    public final void testBuy3() {
        buy.purchaseBloodTest(ServiceType.BLOOD_TEST.value(), 78, true, DiscountType.OVER_70.value()); //78*0.1*0.85= 6.63
        buy.purchaseBloodTest(ServiceType.BLOOD_TEST.value(), 78, false, DiscountType.UNDER_5.value()); // 78*0.6=46.8
        assertEquals(buy.priceBeforeDiscount(), 156, DELTA);
        assertEquals(buy.priceAfterDiscount(), 53.43, DELTA);

    }
}
