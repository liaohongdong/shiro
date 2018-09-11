package cn.liaohongdong.dao;

import cn.liaohongdong.model.Client;

import java.util.List;

public interface ClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);

    List<Client> getAll();

    Client findByClientId(String clientId);

    Client findByClientSecret(String clientSecret);
}