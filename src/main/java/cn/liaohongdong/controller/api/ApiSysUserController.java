package cn.liaohongdong.controller.api;

import cn.liaohongdong.common.JsonData;
import cn.liaohongdong.model.SysUser;
import cn.liaohongdong.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/sys/user")
public class ApiSysUserController{

    @Autowired
    private SysUserService sysUserService;

    @CrossOrigin
    @RequestMapping("/getAll")
    @ResponseBody
    public Object getAll() throws IOException {
        List<SysUser> all = sysUserService.getAll();
        return JsonData.success(all, "", 20000);
    }

}
