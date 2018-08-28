package cn.liaohongdong.service.oauth;

import cn.liaohongdong.common.PasswordHelper;
import cn.liaohongdong.dao.UserMapper;
import cn.liaohongdong.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordHelper passwordHelper;

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public boolean checkUser(String username, String password, String salt, String encryptpwd) {
        String pwd = passwordHelper.encryptPassword(username, password, salt);
        return pwd.equals(encryptpwd);
    }
}
