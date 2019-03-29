package tm.bean;

public class Order {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String commodityCode;

    /**
     * 
     */
    private Integer count;

    /**
     * 
     */
    private Integer money;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return user_id 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 
     * @return commodity_code 
     */
    public String getCommodityCode() {
        return commodityCode;
    }

    /**
     * 
     * @param commodityCode 
     */
    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode == null ? null : commodityCode.trim();
    }

    /**
     * 
     * @return count 
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count 
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return money 
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 
     * @param money 
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", commodityCode='" + commodityCode + '\'' +
                ", count=" + count +
                ", money=" + money +
                '}';
    }
}