package tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations={"classpath:dubbo-account-producer.xml",
        "classpath:spring-fescar-proxy-db.xml"})
public class AccountProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountProducerApplication.class, args);
        System.out.println("success");
    }

}
