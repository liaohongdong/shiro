package cn.liaohongdong.common;

import com.google.common.collect.Sets;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SSOCasRealm extends CasRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        CasToken c = (CasToken) token;
        if (token == null) {
            return null;
        }
        String ticket = (String) c.getCredentials();

        TicketValidator ticketValidator = ensureTicketValidator();
        try {
            Assertion assertion = ticketValidator.validate(ticket, getCasService());
            AttributePrincipal principal = assertion.getPrincipal();
            String name = principal.getName();
            LogUtils.logger(
                    this.getClass(),
                    "Validate ticket : {} in CAS server : {} to retrieve user : {},",
                    new Object[]{ticket, getCasServerUrlPrefix(), name});
            Map attributes = principal.getAttributes();
            c.setUserId(name);
            String rememberMeAttributeName = getRememberMeAttributeName();
            String remeberMeStringValue = (String) attributes.get(rememberMeAttributeName);
            boolean isRemembered = (remeberMeStringValue != null) && (Boolean.parseBoolean(remeberMeStringValue));
            if (isRemembered) {
                c.setRememberMe(true);
            }

            List principals = CollectionUtils.asList(new Object[]{name, attributes});
            SimplePrincipalCollection collection = new SimplePrincipalCollection(principals, getName());
            return new SimpleAuthenticationInfo(collection, ticket);
        } catch (Exception e) {
            throw new CasAuthenticationException("Unable to validate ticket ["
                    + ticket + "]", e);
        }

    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        LogUtils.logger(this.getClass(), "SSOCasRealm:------------" + username);
        HashSet<String> roles = Sets.newHashSet(); // 查库获取roles
        roles.add("user");
        if ("admin".equals(username)) {
            roles.add("admin");
        }
        SimpleAuthorizationInfo simple = new SimpleAuthorizationInfo(roles); // 设置roles
        return simple;
    }


}
