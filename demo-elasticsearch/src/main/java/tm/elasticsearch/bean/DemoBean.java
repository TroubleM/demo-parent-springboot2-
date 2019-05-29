package tm.elasticsearch.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @auther: zhangyi
 * @date: 2019/5/27
 * @Description: Es中的实体Bean，
 * indexName:数据库名
 * type:表名
 * 映射配置：字段名，类型
 */
@Document(indexName = "demo", type = "demo_bean")
public class DemoBean {

    @Id
    private Long id;

    @Field(type= FieldType.Text,fielddata=true,analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String code;

    @Field(type= FieldType.Text,fielddata=true,analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String userName;

    @Field(type= FieldType.Text,fielddata=true)
    private String password;

    @Field(type= FieldType.Text,fielddata=true)
    private String mail;

    @Field(type= FieldType.Text,fielddata=true)
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "DemoBean{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}