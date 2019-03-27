package tm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tm.rao.OrderRao;

@Service
public class CustomerService {

    @Autowired
    private OrderRao orderRao;

    public Object customerTest1(String orderNo){

        System.out.println("微服务调用开始");

        System.out.println(orderRao);

        System.out.println("微服务调用结束");

        return orderRao.createOrder(orderNo);
    }

}
