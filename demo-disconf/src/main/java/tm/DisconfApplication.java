package tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:application.properties"})
@ComponentScan("tm.disconf")
public class DisconfApplication {

    public static void main(String[] args) {

        SpringApplication.run(DisconfApplication.class, args);
        System.out.println("success");
    }

}
