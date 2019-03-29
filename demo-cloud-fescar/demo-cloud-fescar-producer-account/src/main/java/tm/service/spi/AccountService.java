package tm.service.spi;

public interface AccountService {

    /**
     * @Author zhangyi
     * @Description: 账户扣款
     * @Date  2019/3/28
     * @Param [userId, money]
     * @return void
     **/
    void debit(String userId, int money);

}
