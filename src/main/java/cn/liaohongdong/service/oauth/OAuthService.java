package cn.liaohongdong.service.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class OAuthService {

    private Cache cache;

    @Autowired
    private ClientService clientService;

    public OAuthService(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("code-cache");
    }

    public boolean checkClientId(String clientId) {
        return clientService.findByClientId(clientId) != null;
    }

    public void addAuthCode(String authCode, String username) {
        cache.put(authCode, username);
    }
}
