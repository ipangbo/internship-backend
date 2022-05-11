package cn.ipangbo.internshiphw4mvc.controller;

import cn.ipangbo.internshiphw4mvc.entity.GetAllVO;
import cn.ipangbo.internshiphw4mvc.entity.MessageModel;
import cn.ipangbo.internshiphw4mvc.entity.User;
import cn.ipangbo.internshiphw4mvc.service.UserService;
import cn.ipangbo.internshiphw4mvc.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    UserService service;

    @PostMapping("/login")
    public MessageModel login(@RequestBody User user) {
        if ("ipangbo".equals(user.getUserName()) && "123".equals(user.getUserPass())) {
            log.info(user.getUserName() + "登录了");
            return MessageModel.builder().status(200).token(JwtUtils.creatToken()).build();
        } else {
            return MessageModel.builder().status(401).message("登陆失败").build();
        }
    }

    @GetMapping("/getAll")
    public GetAllVO getAll() {
        List<User> users = service.getUserList();
        return GetAllVO.builder().status(200).data(users).build();
    }

    @GetMapping("/testBean")
    public User testBean(User user) {
        return user;
    }

    @GetMapping("/checkToken")
    public MessageModel checkToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (service.validateToken(token)) {
            return MessageModel.builder().status(200).build();
        } else {
            return MessageModel.builder().status(400).message("验证失败，请重新登录").build();
        }
    }

    @PostMapping("/addUser")
    public MessageModel addUser(@RequestBody User user) {
        if (service.addUser(user) != 0) {
            return MessageModel.builder().status(200).build();
        } else {
            return MessageModel.builder().status(500).message("插入失败").build();
        }
    }

    @GetMapping("/getUserCount")
    public MessageModel getUserCount() {
        return MessageModel.builder().status(200).data(String.valueOf(service.getUserCount())).build();
    }
}
