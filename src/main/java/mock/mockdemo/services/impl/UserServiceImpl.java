package mock.mockdemo.services.impl;

import com.alibaba.fastjson.JSONObject;
import mock.mockdemo.bean.User;
import mock.mockdemo.bean.res.UserRes;
import mock.mockdemo.conf.MockConf;
import mock.mockdemo.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
@Scope("prototype")
public class UserServiceImpl implements UserServices {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);



    @Autowired
    private UserRes userRes;
    @Autowired
    private MockConf mockConf;

    @Override
    public String addUser(User user) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        userRes.setCreateTime(dateFormat.format(now));
        userRes.setUserData(user);
        userRes.setUserId(UUID.randomUUID().toString());
        String res=JSONObject.toJSONString(userRes);
        logger.debug("响应内容:{}",res);
        return res;
    }

    @Override
    public String getUserNum() {
        return mockConf.getUserNum();
    }
}
