package mock.mockdemo.controller;

import mock.mockdemo.bean.User;
import mock.mockdemo.services.UserServices;
import mock.util.ParamsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class MockController {
    private final static Logger logger = LoggerFactory.getLogger(MockController.class);

    @Autowired
    private UserServices userServices;


    //@RequestBody
    /**
    *
     * @Description:  @RequestBody
     * @Author: huangchunhao
     * @Date: 2022/3/29 10:44 AM
     * @param request:
     * @param user:
     * @return java.lang.String
     **/
    @RequestMapping(value = "addUser", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String addUser(HttpServletRequest request, @RequestBody User user) {
        logger.debug(request.getRemoteAddr());
        return userServices.addUser(user);
    }

    //@RequestHeader
    /**
    *
     * @Description: @RequestHeader
     * @Author: huangchunhao
     * @Date: 2022/3/29 10:45 AM
     * @param request:
     * @param user:
     * @param encoding:
     * @param type:
     * @return java.lang.String
     **/
    @RequestMapping(value = "addUser/header", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String addUser_header(HttpServletRequest request, @RequestBody User user,@RequestHeader("Accept-Encoding") String encoding,@RequestHeader("Content-Type") String type) {
        logger.debug(request.getRemoteAddr());
        logger.debug("Accept-Encoding:{}",encoding);
        logger.debug("Content-Type:{}",type);
        return userServices.addUser(user);
    }


    //@PathVariable
    /**
    *
     * @Description: @PathVariable
     * @Author: huangchunhao
     * @Date: 2022/3/29 10:45 AM
     * @param request:
     * @param name:
     * @param age:
     * @return java.lang.String
     **/
    @RequestMapping(value = "addUser/{name}/{age}", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String addUser_path(HttpServletRequest request, @PathVariable("name") String name, @PathVariable("age") String age) {
        logger.debug(request.getRemoteAddr());
        User user = new User();
        user.setAge(age);
        user.setName(name);
        return userServices.addUser(user);
    }

    //@RequestParam 和 @RequestBody同时存在
    /**
    *
     * @Description:  @RequestParam 和 @RequestBody同时存在
     * @Author: huangchunhao
     * @Date: 2022/3/29 10:45 AM
     * @param request:
     * @param body:
     * @param name:
     * @param age:
     * @return java.lang.String
     **/
    @RequestMapping(value = "addUser_param", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String addUser_params(HttpServletRequest request, @RequestBody String body,@RequestParam("name") String name, @RequestParam("age") String age) {
        logger.debug("请求内容：{}",body);
        try {
            logger.debug("将请求内容转成map：{}",ParamsUtil.getParm(body));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(request.getRemoteAddr());
        User user2 = new User();
        user2.setAge(age);
        user2.setName(name);
        return userServices.addUser(user2);
    }

    //@RequestBody
    /**
    *
     * @Description:@RequestBody
     * @Author: huangchunhao
     * @Date: 2022/3/29 10:45 AM
     * @param request:
     * @return java.lang.String
     **/
    @RequestMapping(value = "getUserNum", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String getUserNum(HttpServletRequest request) {
        logger.debug(request.getRemoteAddr());
        return userServices.getUserNum();
    }
}
