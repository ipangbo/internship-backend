package cn.ipangbo.internshiphw4mvc.mapper;

import cn.ipangbo.internshiphw4mvc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("SELECT userId, userName, userPass, userNickname, userEmail, userUrl, userAvatar, userLastLoginIp, userRegisterTime, userLastLoginTime, userStatus FROM users_for_inthw3")
    List<User> getUserList();

    @Insert("INSERT INTO users_for_inthw3(userName, userPass, userNickname, userEmail, userUrl, userAvatar, userStatus) VALUES (#{userName}, #{userPass}, #{userNickname}, #{userEmail}, #{userUrl}, #{userAvatar}, #{userStatus})")
    int addUser(User user);

    @Select("SELECT COUNT(*) FROM users_for_inthw3")
    int getUserCount();

}
