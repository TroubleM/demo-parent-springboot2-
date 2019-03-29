package tm.bean;

public class Storage {
    /**
     * 
     */
    private Long id;

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
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
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
}