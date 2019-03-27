
package tm.rao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo-eureka-producer-order")
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
