
package tm.eureka.api.rao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tm.eureka.api.hystrix.OrderRaoHystrix;

@FeignClient(name = "demo-eureka-producer-order",fallback = OrderRaoHystrix.class)
@RequestMapping(value = "order")
public interface OrderRao {

    /**
     * @Author zhangyi
     * @Description: 创建订单
     * @Date  2019/3/26
     * @Param [orderNo]
     * @return tm.entity.Order
     **/

    @RequestMapping(value = "createOrder")
    Object createOrder(@RequestParam(value = "orderNo") String orderNo);

}
