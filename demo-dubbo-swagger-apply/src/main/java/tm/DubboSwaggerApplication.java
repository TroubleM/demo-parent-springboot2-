package tm;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDubbo
// @ComponentScan(basePackages = {"com.duia.dubbo.swagger"})
public class DubboSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboSwaggerApplication.class, args);
        System.out.println("success");
    }

}