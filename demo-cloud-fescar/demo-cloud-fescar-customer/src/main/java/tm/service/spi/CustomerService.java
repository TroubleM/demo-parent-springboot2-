package tm.service.spi;

import tm.bean.OrderResponse;

public interface CustomerService {

     /**
      * @Author zhangyi
      * @Description: 消费者方法执行
      * @Date  2019/3/28
      * @Param [userId, commodityCode, orderCount, code]
      * @return tm.bean.OrderResponse
      **/
     OrderResponse executeCustomer(String code);

}
