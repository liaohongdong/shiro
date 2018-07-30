package cn.liaohongdong.controller;

import cn.liaohongdong.common.JsonData;
import cn.liaohongdong.common.RequestHolder;
import cn.liaohongdong.exception.ParamException;
import cn.liaohongdong.model.SysUser;
import cn.liaohongdong.param.UserParam;
import cn.liaohongdong.service.SysUserService;
import cn.liaohongdong.utils.MD5Util;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/sys/user")
@Controller
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/getAll")
    @ResponseBody
    public JsonData getAll() throws IOException {
        List<SysUser> all = sysUserService.getAll();
        return JsonData.success(all, "", 0);
    }

    @RequestMapping("/login")
    @ResponseBody
    public JsonData login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println(username + " " + password);
        SysUser login = sysUserService.login(username, MD5Util.encrypt(password));
        System.out.println(login);
        return JsonData.success("", "登陆成功", 0);
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonData save(UserParam user) {
        sysUserService.save(user);
        return JsonData.success("", 0);
    }
}