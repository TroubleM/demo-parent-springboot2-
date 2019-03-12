package tm.service;

/**
 * @auther: zhangyi
 * @date: 2019/3/1
 * @Description: 账户业务层
 */
public interface AccountService {

    /**
     * 余额扣款
     *
     * @param userId 用户ID
     * @param money 扣款金额
     */
    void debit(String userId, int money);

}
