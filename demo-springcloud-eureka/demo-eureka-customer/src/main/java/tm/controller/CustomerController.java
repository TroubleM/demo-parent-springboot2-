package tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.service.CustomerService;

@RestController
@RequestMapping(value = "demoEurekaCustomer")
public class CustomerController{

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "test1")
    public Object test1(String orderNo){
        Object object = customerService.customerTest1(orderNo);
        return object;
    }
}
