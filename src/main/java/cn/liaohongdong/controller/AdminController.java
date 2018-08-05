package cn.liaohongdong.controller;

import cn.liaohongdong.common.LogUtils;
import cn.liaohongdong.service.TestService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        return "list";
    }

    @RequestMapping("/list")
    public String list() {
        System.out.println("list....");
        return "list";
    }

    @RequestMapping("/admin")
    public ModelAndView admin(ModelAndView vm, Model model) {
//        ModelAndView view = new ModelAndView("admin");
//        System.out.println("admin....");
//        view.addObject("liao1", "liao1");
//        view.addObject("name", "张三");
//        view.addObject("age", "18");
//        List list = Lists.newArrayList();
//        list.add("1");
//        list.add("2");
//        list.add("3");
        vm.setViewName("admin");
        vm.addObject("liao1", "liaossss");
        return vm;
    }

    @RequestMapping("/user")
    public String user(Model model) {
        System.out.println("user....");
        model.addAttribute("liao1", "liaohd1");
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
//    @RequiresRoles(value = {"admin"})
    public String getTime(HttpSession session) {
        session.setAttribute("liao", "gagagagaga");
        System.out.println(testService.getTime());
        return "list";
    }

}
