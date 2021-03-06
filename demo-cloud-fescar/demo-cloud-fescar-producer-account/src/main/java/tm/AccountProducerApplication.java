package tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableDiscoveryClient
@ImportResource(locations={"classpath:spring-fescar-proxy-db.xml"})
public class AccountProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountProducerApplication.class, args);
        System.out.println("success");
    }

}
