package mock.mockdemo.bean.res;

import lombok.Data;
import mock.mockdemo.bean.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@Data
public class UserRes {
    private String userId;
    private User userData;
    private String createTime;
}
