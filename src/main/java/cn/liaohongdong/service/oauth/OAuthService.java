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

    public boolean checkClientSecret(String clientSecret) {
        return clientService.findByClientSecret(clientSecret) != null;
    }

    public boolean checkAuthCode(String authCode) {
        return cache.get(authCode) != null;
    }

    public String getUsernameByAuthCode(String authCode) {
        return (String) cache.get(authCode).get();
    }

    public boolean checkAccessToken(String accessToken) {
        return cache.get(accessToken) != null;
    }

    public String getUsernameByAccessToken(String accessToken) {
        return (String) cache.get(accessToken).get();
    }

    public long getExpireIn() {
        return 3600L;
    }
}
