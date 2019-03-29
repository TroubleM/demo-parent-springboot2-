package tm.bean;

public class Account {
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
}