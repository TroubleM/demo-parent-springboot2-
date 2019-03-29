package tm.service.spi;

import tm.bean.OrderResponse;

public interface OrderService {

    /**
     * @Author zhangyi
     * @Description: 创建订单
     * @Date  2019/3/28
     * @Param [userId, commodityCode, orderCount]
     * @return tm.bean.OrderResponse
     **/
    OrderResponse create(String userId, String commodityCode, int orderCount);

}
