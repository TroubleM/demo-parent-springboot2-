package tm.eureka.api.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import tm.eureka.api.rao.OrderRao;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderRaoHystrix implements OrderRao {

    @Override
    public Object createOrder(@RequestParam(value = "orderNo")String orderNo) {

        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("code",600);

        return resultMap;
    }
}
