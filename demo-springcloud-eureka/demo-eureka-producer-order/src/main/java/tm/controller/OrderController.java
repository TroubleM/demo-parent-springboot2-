package tm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.entity.Order;
import java.util.Date;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @RequestMapping(value = "createOrder")
    public Object createOrder(String orderNo) {

        System.out.println("执行创建订单");

        Order order = new Order();

        order.setOrderNo(orderNo);

        order.setCreateTime(new Date());

        return order;
    }
}
