package cn.liaohongdong.common;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;

import javax.servlet.http.HttpServletRequest;

public class OnlineSessionFactory implements SessionFactory {
    @Override
    public Session createSession(SessionContext sessionContext) {
        OnlineSession session = new OnlineSession();
        if (sessionContext != null && sessionContext instanceof WebSessionContext) {
            HttpServletRequest request = (HttpServletRequest) ((WebSessionContext) sessionContext).getServletRequest();
            if (request != null){
                session.setHost(request.getRemoteHost());
                session.setUserAgent(request.getHeader("User-Agent"));
            }
        }
        return session;
    }
}
