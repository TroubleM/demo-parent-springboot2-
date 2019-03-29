package tm.rao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tm.bean.OrderResponse;

@FeignClient(name = "demo-cloud-fescar-order-producer")
@RequestMapping(value = "order")
public interface OrderRao {

    /**
     * @Author zhangyi
     * @Description: Feign调用订单微服务
     * @Date  2019/3/28
     * @Param [code]
     * @return tm.bean.OrderResponse
     **/
    @RequestMapping(value = "create")
    OrderResponse create(@RequestParam(value = "code") String code);

}
