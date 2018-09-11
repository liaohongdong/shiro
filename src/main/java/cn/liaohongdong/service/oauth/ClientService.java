package cn.liaohongdong.service.oauth;

import cn.liaohongdong.dao.ClientMapper;
import cn.liaohongdong.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientMapper clientMapper;


    public Client createClient(Client client) {
        client.setClientId(UUID.randomUUID().toString());
        client.setClientSecret(UUID.randomUUID().toString());
        return client;
    }

    public Client findByClientId(String clientId) {
        return clientMapper.findByClientId(clientId);
    }

    public Client findByClientSecret(String clientSecret){
        return clientMapper.findByClientSecret(clientSecret);
    }
}
