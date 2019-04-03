package tm.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tm.bean.OrderResponse;
import tm.eureka.order.rao.OrderRao;

@RequestMapping(value = "order-hystrix")
public class OrderRaoHystrix implements OrderRao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderRaoHystrix.class);

    @Override
    public OrderResponse create(@RequestParam(value = "code") String code) {
        LOGGER.error("----------------订单熔断器执行----------------");

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setCode("500");
        orderResponse.setMessage("操作异常");

        return orderResponse;
    }
}
