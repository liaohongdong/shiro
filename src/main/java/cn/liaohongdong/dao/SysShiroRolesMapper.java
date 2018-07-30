package cn.liaohongdong.dao;

import cn.liaohongdong.model.SysShiroRoles;

import java.util.List;

public interface SysShiroRolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysShiroRoles record);

    int insertSelective(SysShiroRoles record);

    SysShiroRoles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysShiroRoles record);

    int updateByPrimaryKey(SysShiroRoles record);

    List<SysShiroRoles> getAll();
}