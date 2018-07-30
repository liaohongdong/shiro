package cn.liaohongdong.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TestService {
    public String getTime() {
        Session session = SecurityUtils.getSubject().getSession();
        Object liao = session.getAttribute("liao");
        return new Date().toString() + " session: " + liao;
    }
}
