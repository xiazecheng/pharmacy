package com.yaojie.shiro.realm;

import com.yaojie.pojo.RoleResourceswr;
import com.yaojie.pojo.UserRoleswn;
import com.yaojie.service.JedisClient;
import com.yaojie.service.RoleResourcesService;
import com.yaojie.service.UserRolesService;
import com.yaojie.utils.JsonUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by madao on 2017/5/14.
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserRolesService userRoleService;
    @Autowired
    private RoleResourcesService roleResourcesService;

    @Autowired
    private JedisClient jedisClient;
    Logger log = LoggerFactory.getLogger(MyRealm.class);

    /**
     * 获取授权信息
     * 每当需要鉴权时，都会先通过此方法获取用户拥有的权限，并包装成shiro自己封装的AuthorizationInfo对象里面
     */
    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            return null;
        } else {
            AuthorizationInfo info = null;
            if (log.isTraceEnabled()) {
                log.trace("Retrieving AuthorizationInfo for principals [" + principals + "]");
            }
//            info = shiroRedis.getAuthinfo(principals.toString());
            info = JsonUtils.jsonToPojo(jedisClient.get(principals.toString()),AuthorizationInfo.class);
            if (info == null) {
                info = this.doGetAuthorizationInfo(principals);
                if (info != null) {
                    if (log.isTraceEnabled()) {
                        log.trace("Caching authorization info for principals: [" + principals + "].");
                    }
                    jedisClient.set(principals.toString(), JsonUtils.objectToJson(info));
                }
            }
            return info;
        }
    }

    /**
     * 获取授权信息，在这个方法中，从db获取当前登录用户的角色和资源权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        int userId = Integer.parseInt((String) getAvailablePrincipal(principalCollection));
        List<UserRoleswn> userRoles = userRoleService.getRoleByUserId(userId);
        //通过用户名从数据库获取权限字符串
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //角色权限
        Set<String> roleSet = new HashSet<>();
        //资源权限
        Set<String> resourcesSet = new HashSet<>();
        for (UserRoleswn userRole : userRoles) {
            roleSet.add(userRole.getRoleName());
            List<RoleResourceswr> resourceList = roleResourcesService.getResourcesByRole(userRole.getRoleId());
            for (RoleResourceswr roleResources : resourceList) {
                resourcesSet.add(roleResources.getUri() + ":" + roleResources.getMethod());
            }
        }
        info.setRoles(roleSet);
        info.setStringPermissions(resourcesSet);
        return info;
    }

    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userId = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(userId, password, getName());
        return aInfo;
    }

}