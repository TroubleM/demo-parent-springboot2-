package tm.controller;

import com.alibaba.fescar.core.context.RootContext;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import org.hibernate.validator.constraints.pl.REGON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.bean.OrderResponse;
import tm.service.spi.OrderService;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    private static final Logger LOGGER  = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "create")
    public Object create(String code){

        LOGGER.info("Order Service Begin ... xid: " + RootContext.getXID());


        if(code.equals("-1")){
            System.out.println(1/0);
        }

        OrderResponse orderResponse = orderService.create("U100001", "C00321", 1);

        return orderResponse;
    }

}
