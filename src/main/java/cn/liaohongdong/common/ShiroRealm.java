package cn.liaohongdong.common;

import com.google.common.collect.Sets;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;

// extends AuthorizingRealm 授权 1
// extends AuthenticatingRealm 认证 2
public class ShiroRealm extends AuthorizingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LogUtils.logger(this.getClass(), "ShiroRealm" + authenticationToken);
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
//        Object credentials = "a66abb5684c45962d887564f08346e8d";
//        Object credentials = "4da49c16db42ca04538d629ef0533fe8";
        ByteSource credentialsSalt = ByteSource.Util.bytes(principals);
        String realmName = getName();
//        SimpleAuthenticationInfo simple = new SimpleAuthenticationInfo(principals, credentials, realmName);
        SimpleAuthenticationInfo simple = new SimpleAuthenticationInfo(principals, credentials, credentialsSalt, realmName);
        return simple;
    }

    // 实现授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LogUtils.logger(this.getClass(), "我要开始授权啦");
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal(); // 获取登录信息
        HashSet<String> roles = Sets.newHashSet(); // 查库获取roles
        roles.add("user");
        if ("admin".equals(primaryPrincipal)) {
            roles.add("admin");
        }
        SimpleAuthorizationInfo simple = new SimpleAuthorizationInfo(roles); // 设置roles
        return simple;
    }

//    public static void main(String[] args) {
//        String hashAlgorithmName = "MD5";
//        Object credentials = "123456";
//        Object salt = ByteSource.Util.bytes("admin");
//        int hashIterations = 1;
//        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
//        System.out.println(simpleHash);
//    }
}
