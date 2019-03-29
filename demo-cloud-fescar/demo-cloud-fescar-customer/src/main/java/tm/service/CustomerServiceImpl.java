package tm.service;

import com.alibaba.fescar.core.context.RootContext;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.bean.OrderResponse;
import tm.rao.OrderRao;
import tm.rao.StorageRao;
import tm.service.spi.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private OrderRao orderRao;

    @Autowired
    private StorageRao storageRao;

    @Override
    @GlobalTransactional(timeoutMills = 600000, name = "dubbo-demo-tx")
    public OrderResponse executeCustomer(String code) {

        LOGGER.info("xid==============={}", RootContext.getXID());

        OrderResponse orderResponse = orderRao.create(code);

        storageRao.deduct("C00321",1,code);

        if(code.equals("0")){
            System.out.println(1/0);
        }

        return orderResponse;
    }
}
