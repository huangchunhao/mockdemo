package mock.mockdemo.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Data
@Component
@PropertySource("classpath:config/conf.properties")
public class MockConf {
    @Value("${user_num}")
    public String userNum;
}
