package medical.order;

import medical.service.Service;

import java.util.List;

/**
 * Created by zhuanghua on 16/7/20.
 */
public interface Order {

     double getTotalPrice(int age,boolean insured,List<Service> list);
}
