package tm.service;

import tm.bean.OrderResponse;

/**
 * @auther: zhangyi
 * @date: 2019/3/14
 * @Description: 订单处理业务层
 */
public interface OrderHandelService {

    /**
     * @Author zhangyi
     * @Description: 订单处理
     * @Date  2019/3/14
     * @Param [userId, commodityCode, orderCount, code]
     * @return tm.bean.OrderResponse
     **/
    OrderResponse handelOrder(String userId, String commodityCode, Integer orderCount,
                              String code);

}
