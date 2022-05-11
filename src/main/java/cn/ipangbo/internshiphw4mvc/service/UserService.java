package cn.ipangbo.internshiphw4mvc.service;

import cn.ipangbo.internshiphw4mvc.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    boolean validateToken(String token);

    int addUser(User user);

    int getUserCount();
}
