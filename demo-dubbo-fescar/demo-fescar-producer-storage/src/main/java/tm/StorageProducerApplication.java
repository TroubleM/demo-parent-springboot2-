package tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations={"classpath:dubbo-storage-producer.xml",
        "classpath:spring-fescar-proxy-db.xml"})
public class StorageProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageProducerApplication.class, args);
        System.out.println("success");
    }

}
