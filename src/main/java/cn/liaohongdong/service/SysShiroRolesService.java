package cn.liaohongdong.service;

import cn.liaohongdong.dao.SysShiroRolesMapper;
import cn.liaohongdong.model.SysShiroRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysShiroRolesService {
    @Autowired
    private SysShiroRolesMapper sysShiroRolesMapper;

    public List<SysShiroRoles> getRolesItem() {
        List<SysShiroRoles> all = sysShiroRolesMapper.getAll();
        return all;
    }
}
