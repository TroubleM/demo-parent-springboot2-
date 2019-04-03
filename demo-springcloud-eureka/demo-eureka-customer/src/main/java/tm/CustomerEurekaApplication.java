package tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "tm")
@EnableEurekaClient
public class CustomerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerEurekaApplication.class, args);
        System.out.println("success");
    }

}
