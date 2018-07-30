package cn.liaohongdong.common;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class ShiroRealm2 extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LogUtils.logger(this.getClass(), "ShiroRealm2" + authenticationToken);
        // 1. authenticationToken 转为 UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 2. 从UsernamePasswordToken中获取username
        String username = token.getUsername();
        // 3. 查询数据库
        // 4. 不存在抛出 UnKnownAccountException 异常
        if ("unknown".equals(username)) {
            throw new UnknownAccountException("账户不存在");
        }
        // 5. 根据查询情况抛出其他AuthenticationException异常
        // 6. 根据查询情况 构建 AuthenticationInfo 并返回
        Object principals = username;
        Object credentials = null;
        if ("admin".equals(username)) {
            credentials = "a66abb5684c45962d887564f08346e8d";
        } else if ("user".equals(username)) {
            credentials = "4da49c16db42ca04538d629ef0533fe8";
        }
//        Object credentials = "cd5ea73cd58f827fa78eef7197b8ee606c99b2e6.";
//        Object credentials = "99e7a456385b481f25e1451868a3a584d4200d17";
        ByteSource credentialsSalt = ByteSource.Util.bytes(principals);
        String realmName = getName();
//        SimpleAuthenticationInfo simple = new SimpleAuthenticationInfo(principals, credentials, realmName);
        SimpleAuthenticationInfo simple = new SimpleAuthenticationInfo("ssssss", credentials, credentialsSalt, realmName);
        return simple;
    }

//    public static void main(String[] args) {
//        String hashAlgorithmName = "SHA1";
//        Object credentials = "123456";
//        Object salt = ByteSource.Util.bytes("admin");
//        int hashIterations = 1;
//        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
//        System.out.println(simpleHash);
//    }
}
