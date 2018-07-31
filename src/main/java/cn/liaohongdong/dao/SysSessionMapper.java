package cn.liaohongdong.dao;

import cn.liaohongdong.model.SysSession;

public interface SysSessionMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysSession record);

    int insertSelective(SysSession record);

    SysSession selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysSession record);

    int updateByPrimaryKeyWithBLOBs(SysSession record);
}