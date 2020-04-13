package tm.entity;

import java.util.Date;

public class DuibaGroupTopic {
    /**
     *
     */
    private Integer categoryId;

    /**
     *
     */
    private Integer groupId;

    /**
     *
     */
    private String topic;

    /**
     *
     */
    private Integer creator;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Integer upNum;

    /**
     * 0：否
     1：是
     */
    private Integer highLight;

    /**
     *
     */
    private Integer highTop;

    /**
     *
     */
    private Integer viewNum;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpNum() {
        return upNum;
    }

    public void setUpNum(Integer upNum) {
        this.upNum = upNum;
    }

    public Integer getHighLight() {
        return highLight;
    }

    public void setHighLight(Integer highLight) {
        this.highLight = highLight;
    }

    public Integer getHighTop() {
        return highTop;
    }

    public void setHighTop(Integer highTop) {
        this.highTop = highTop;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }
}
