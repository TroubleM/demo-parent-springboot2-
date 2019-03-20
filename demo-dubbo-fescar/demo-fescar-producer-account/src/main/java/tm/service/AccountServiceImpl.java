package tm.service;

import com.alibaba.fescar.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tm.bean.Account;
import tm.dao.AccountMapper;

@Service(value = "accountService")
@Transactional
public class AccountServiceImpl implements AccountService{

    private Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void debit(String userId, int money) {

        LOGGER.info("Order Service Begin ... xid: " + RootContext.getXID());

        Account account = new Account();
        account.setMoney(money);
        account.setUserId(userId);
        accountMapper.updateForOrder(account);

        LOGGER.info("Order Service End ... ");
    }
}
