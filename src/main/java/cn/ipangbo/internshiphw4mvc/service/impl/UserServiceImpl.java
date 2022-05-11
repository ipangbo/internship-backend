package cn.ipangbo.internshiphw4mvc.service.impl;

import cn.ipangbo.internshiphw4mvc.entity.User;
import cn.ipangbo.internshiphw4mvc.mapper.UserMapper;
import cn.ipangbo.internshiphw4mvc.service.UserService;
import cn.ipangbo.internshiphw4mvc.utils.JwtUtils;
import io.jsonwebtoken.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper mapper;

    @Override
    public List<User> getUserList() {
        return mapper.getUserList();
    }

    @Override
    public boolean validateToken(String token) {
        return JwtUtils.validateToken(token);
    }

    @Override
    public int addUser(User user) {
        return mapper.addUser(user);
    }

    @Override
    public int getUserCount() {
        return mapper.getUserCount();
    }
}
