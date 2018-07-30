package cn.liaohongdong.controller;

import cn.liaohongdong.common.LogUtils;
import cn.liaohongdong.service.TestService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private TestService testService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
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
        return "redirect:/admin/list";
    }

    @RequestMapping("/list")
    public String list() {
        System.out.println("list....");
        return "list";
    }

    @RequestMapping("/admin")
    public String admin() {
        System.out.println("admin....");
        return "admin";
    }

    @RequestMapping("/user")
    public String user() {
        System.out.println("user....");
        return "user";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        System.out.println("unauthorized....");
        return "unauthorized";
    }

    @RequestMapping("/logout")
    public void logout() {
        System.out.println("logout");
    }

    @RequestMapping("/getTime")
    @RequiresRoles(value = {"admin"})
    public String getTime(HttpSession session) {
        session.setAttribute("liao", "gagagagaga");
        System.out.println(testService.getTime());
        return "redirect:/admin/list";
    }

}
