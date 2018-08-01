package cn.liaohongdong.common;

import cn.liaohongdong.dao.SysSessionMapper;
import cn.liaohongdong.model.SysSession;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class MySessionDao extends EnterpriseCacheSessionDAO {
    @Autowired
    private SysSessionMapper sysSessionMapper;

    public MySessionDao() {
        super();
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        SysSession se = new SysSession();
        se.setId(sessionId.toString());
        se.setSession(SerializableUtils.serialize(session));
        sysSessionMapper.insert(se);
        System.out.println("haha");
        return session.getId();
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        SysSession sysSession = sysSessionMapper.selectByPrimaryKey(sessionId.toString());
        return SerializableUtils.deSerialize(sysSession.getSession());
    }

    @Override
    protected void doUpdate(Session session) {
//        super.doUpdate(session);
        if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
            return;
        }
        SysSession se = new SysSession();
        se.setId(session.getId().toString());
        se.setSession(SerializableUtils.serialize(session));
        sysSessionMapper.updateByPrimaryKeySelective(se);
    }

    @Override
    protected void doDelete(Session session) {
        sysSessionMapper.deleteByPrimaryKey(session.getId().toString());
    }
}
