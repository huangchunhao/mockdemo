package mock.mockdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "mock" })
public class MockdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockdemoApplication.class, args);
    }

}
