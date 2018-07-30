package cn.liaohongdong.service;

import cn.liaohongdong.dao.SysUserMapper;
import cn.liaohongdong.model.SysUser;
import cn.liaohongdong.param.UserParam;
import cn.liaohongdong.utils.BeanValidator2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public List<SysUser> getAll() {
        return sysUserMapper.getAll();
//        Preconditions.checkNotNull(list, "kognde");
    }

    public SysUser login(String username, String password) {
        return sysUserMapper.login(username, password);
    }

    public void save(UserParam param){
        BeanValidator2.check(param);
    }

}
