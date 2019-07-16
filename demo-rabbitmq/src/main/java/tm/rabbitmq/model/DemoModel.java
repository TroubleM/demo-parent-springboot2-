package tm.rabbitmq.model;

/**
 * @auther: zhangyi
 * @date: 2019/7/11
 * @Description: rabbitMq消息交互实体
 */
public class DemoModel {

    /**
     * @auther: zhangyi
     * @date: 2019/7/11
     * @Description: 姓名
     */
    private String name;

    /**
     * @auther: zhangyi
     * @date: 2019/7/11
     * @Description: 年龄
     */
    private Integer age;

    /**
     * @auther: zhangyi
     * @date: 2019/7/11
     * @Description: 时间戳
     */
    private Long timestamps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Long timestamps) {
        this.timestamps = timestamps;
    }
}
