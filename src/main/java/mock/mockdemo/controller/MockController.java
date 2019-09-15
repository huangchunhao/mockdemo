package mock.mockdemo.controller;

import mock.mockdemo.bean.User;
import mock.mockdemo.services.UserServices;
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
    @RequestMapping(value = "addUser", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String addUser(HttpServletRequest request, @RequestBody User user) {
        logger.debug(request.getRemoteAddr());
        return userServices.addUser(user);
    }

    //@RequestHeader
    @RequestMapping(value = "addUser/header", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String addUser_header(HttpServletRequest request, @RequestBody User user,@RequestHeader("Accept-Encoding") String encoding,@RequestHeader("Content-Type") String type) {
        logger.debug(request.getRemoteAddr());
        logger.debug("Accept-Encoding:{}",encoding);
        logger.debug("Content-Type:{}",type);
        return userServices.addUser(user);
    }


    //@PathVariable
    @RequestMapping(value = "addUser/{name}/{age}", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String addUser_path(HttpServletRequest request, @PathVariable("name") String name, @PathVariable("age") String age) {
        logger.debug(request.getRemoteAddr());
        User user = new User();
        user.setAge(age);
        user.setName(name);
        return userServices.addUser(user);
    }

    //@RequestParam
    @RequestMapping(value = "addUser_param", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String addUser_params(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("age") String age) {
        logger.debug(request.getRemoteAddr());
        User user2 = new User();
        user2.setAge(age);
        user2.setName(name);
        return userServices.addUser(user2);
    }

    //@RequestBody
    @RequestMapping(value = "getUserNum", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String getUserNum(HttpServletRequest request) {
        logger.debug(request.getRemoteAddr());
        return userServices.getUserNum();
    }
}
