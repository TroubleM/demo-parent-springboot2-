package tm.controller;

import com.alibaba.fescar.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;

import tm.bean.OrderResponse;
import tm.service.OrderHandelService;

/**
 * @auther: zhangyi
 * @date: 2019/3/14
 * @Description: fescar消费者控制层
 */
@RestController
@RequestMapping(value = "fescar-customer")
public class FescarCustomerController {

    private Logger LOGGER = LoggerFactory.getLogger(FescarCustomerController.class);

    @Autowired
    private OrderHandelService orderHandelService;

    /**
     * @Author zhangyi
     * @Description: fescar消费者测试
     * @Date  2019/3/1
     * @Param []
     * @return java.lang.Object
     **/
    @GetMapping(value = "fescarCustomerTest")
    /*@GlobalTransactional(timeoutMills = 600000, name = "dubbo-demo-tx")*/
    public Object fescarCustomerTest(String code){

        LOGGER.info("xid============{}", RootContext.getXID());

        OrderResponse orderResponse =
                orderHandelService.handelOrder("U100001","C00321",1,code);

        //手动执行异常异常
        if("0".equals(code)){
            LOGGER.error("手动执行运行时异常");
            System.out.println(1/0);
        }
        return orderResponse;
    }

}
