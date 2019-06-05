package tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HadoopApplication {

    public static void main(String[] args) {

        SpringApplication.run(HadoopApplication.class, args);
        System.out.println("success");
    }

}
