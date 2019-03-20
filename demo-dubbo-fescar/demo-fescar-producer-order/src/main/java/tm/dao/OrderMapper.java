package tm.dao;

import org.apache.ibatis.annotations.Mapper;

import tm.bean.Order;

@Mapper
public interface OrderMapper {
    /**
     *
     * @mbg.generated 2019-03-14
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int insert(Order record);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int insertSelective(Order record);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    Order selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int updateByPrimaryKey(Order record);
}