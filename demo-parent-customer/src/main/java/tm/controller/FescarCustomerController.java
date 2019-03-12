package tm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.google.common.collect.Maps;
import tm.service.OrderService;
import tm.service.StorageService;

@RestController
@RequestMapping(value = "fescar-customer")
public class FescarCustomerController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private OrderService orderService;

    /**
     * @Author zhangyi
     * @Description: fescar消费者测试
     * @Date  2019/3/1
     * @Param []
     * @return java.lang.Object
     **/
    @GetMapping(value = "testOne")
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-demo-tx")
    public Object testOne(String code){
        orderService.create("1","1",1);
        storageService.deduct("C00321",1);
        System.out.println("121212122");

        //手动创建异常
        if("0".equals(code)){
            System.out.println(1/0);
        }

        Map<String,String> resultMap = Maps.newHashMap();
        resultMap.put("result","操作成功");

        return resultMap;
    }

}
