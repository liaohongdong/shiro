package cn.liaohongdong.dao;

import cn.liaohongdong.model.SysMagic;

public interface SysMagicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMagic record);

    int insertSelective(SysMagic record);

    SysMagic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMagic record);

    int updateByPrimaryKeyWithBLOBs(SysMagic record);
}