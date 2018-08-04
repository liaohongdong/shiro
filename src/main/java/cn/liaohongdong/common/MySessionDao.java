package cn.liaohongdong.common;

import cn.liaohongdong.dao.SysSessionMapper;
import cn.liaohongdong.model.SysSession;
import cn.liaohongdong.utils.JdbcTemplateUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public class MySessionDao extends EnterpriseCacheSessionDAO {
    @Autowired
    private SysSessionMapper sysSessionMapper;

    private JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();

    @Override
    @Transactional
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        SysSession se = new SysSession();
        se.setId(sessionId.toString());
        se.setSession(SerializableUtils.serialize(session));
        sysSessionMapper.insert(se);
//        String sql = "insert into sys_session(id, session) values(?,?)";
//        jdbcTemplate.update(sql, sessionId, SerializableUtils.serialize(session));
        return session.getId();
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        SysSession sysSession = sysSessionMapper.selectByPrimaryKey(sessionId.toString());
        if(sysSession == null){
            return null;
        }
        return SerializableUtils.deSerialize(sysSession.getSession());
//        String sql = "select sys_session from session where id=?";
//        List<String> sessionStrList = jdbcTemplate.queryForList(sql, String.class, sessionId);
//        if (sessionStrList.size() == 0) return null;
//        return SerializableUtils.deSerialize(sessionStrList.get(0));
    }

    @Override
    @Transactional
    protected void doUpdate(Session session) {
//        super.doUpdate(session);

        if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
            return;
        }

        SysSession se = new SysSession();
        se.setId(session.getId().toString());
        se.setSession(SerializableUtils.serialize(session));
        sysSessionMapper.updateByPrimaryKeySelective(se);
//        String sql = "update sys_session set session=? where id=?";
//        jdbcTemplate.update(sql, SerializableUtils.serialize(session), session.getId());
    }

    @Override
    @Transactional
    protected void doDelete(Session session) {
        sysSessionMapper.deleteByPrimaryKey(session.getId().toString());
//        String sql = "delete from sys_session where id=?";
//        jdbcTemplate.update(sql, session.getId());
    }
}
