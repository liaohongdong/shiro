package cn.liaohongdong.controller.api;

import cn.liaohongdong.common.JsonData;
import cn.liaohongdong.common.LogUtils;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;

@RestController
@RequestMapping(value = "/api/admin")
public class ApiAdminController {

    @CrossOrigin
    @RequestMapping("/doLogin")
    @ResponseBody
    public JsonData doLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password) throws IOException {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) { // 没有经过身份验证
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                subject.login(token);
            } catch (AuthenticationException e) {
                LogUtils.logger(this.getClass(), "------AuthenticationException error------" + e);
            }
        }
        return JsonData.success(null, "登陆成功", 20000);
    }
}
