package cn.liaohongdong.dao;

import cn.liaohongdong.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByUsername(String username);

    boolean checkUser(String username, String password, String salt, String encryptpwd);
}