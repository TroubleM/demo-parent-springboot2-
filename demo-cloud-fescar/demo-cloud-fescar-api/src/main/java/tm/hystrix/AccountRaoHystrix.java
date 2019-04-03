package tm.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tm.eureka.rao.AccountRao;

@RequestMapping(value = "account-hystrix")
public class AccountRaoHystrix implements AccountRao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountRaoHystrix.class);

    @Override
    public Object debit(@RequestParam(value = "userId") String userId,
                        @RequestParam(value = "money") int money) {

        LOGGER.error("-------------账户熔断器执行--------------");
        
        return null;
    }
}
