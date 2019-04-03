package tm.controller;

import com.google.common.collect.Maps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.entity.Order;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(value = "order")
public class OrderController {


    @RequestMapping(value = "createOrder")
    @HystrixCommand(fallbackMethod = "handelCreateOrderFail")
    public Object createOrder(String orderNo) {

        System.out.println("执行创建订单");

        Order order = new Order();

        order.setOrderNo(orderNo);

        order.setCreateTime(new Date());

        //手动异常
        if("-1".equals(orderNo)){
            System.out.println(1/0);
        }

        return order;
    }

    /**
     * @Author zhangyi
     * @Description: 创建订单失败结果处理
     * @Date  2019/4/3
     * @Param []
     * @return java.lang.Object
     **/
    public Object handelCreateOrderFail(String orderNo){

        System.out.println("熔断器执行" + orderNo);

        Map<String,Object> resultMap = Maps.newHashMap();

        resultMap.put("code",500);

        return resultMap;
    }
    
}
