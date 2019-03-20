package tm.dao;

import tm.bean.Account;

public interface AccountMapper {
    /**
     *
     * @mbg.generated 2019-03-14
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int insert(Account record);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int insertSelective(Account record);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    Account selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int updateByPrimaryKey(Account record);

    /**
     * @Author zhangyi
     * @Description: 修改账户雨额
     * @Date  2019/3/14
     * @Param [account]
     * @return int
     **/
    int updateForOrder(Account account);
}