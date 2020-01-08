package com.syc.china.shiro;

import com.syc.china.enums.ExceptionEnums;
import com.syc.china.exception.HyException;
import com.syc.china.pojo.PermissionsTest;
import com.syc.china.pojo.RoleTest;
import com.syc.china.pojo.User;
import com.syc.china.pojo.UserTest;
import com.syc.china.service.PermissionService;
import com.syc.china.service.RoleService;
import com.syc.china.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Permissions;
import java.util.List;

/**
 * @author 汪梦瑶
 * @create  2020-01-08 14:29
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private PermissionService permissionService;


    /***
     * 身份验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从认证token中拿到用户名和密码
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        char[] password = token.getPassword();
        User user=userService.getUserByUsername(username);
        if (user==null){
            throw new HyException(ExceptionEnums.ACCOUNT_IS_NOT_EXIST);
        }
        if (!user.getPassword().equals(password)){
            throw new HyException(ExceptionEnums.USERNAME_OR_PASSWORD_ERROR);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password.toString(), getName());
        return info;
    }


    /**
     * 给用户进行授权
     * @param collection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
        //获取登陆用户
        User user = (User) collection.getPrimaryPrincipal();
        Long id = user.getId();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //通过id查询role
        List<String> roles = roleService.findRolesByUserId(id);
        //添加角色
        info.addRoles(roles);
        //通过id查询权限
        List<String> permissions = permissionService.findPermissionsByUserId(id);
        //添加权限
        info.addStringPermissions(permissions);
        return info;
    }


    /*@Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        UserTest user = userService.getUserByName(name);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        UserTest user = userService.getUserByName(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (RoleTest role : user.getRoles()) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            //添加权限
            for (PermissionsTest permissions : role.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsName());
            }
        }
        return simpleAuthorizationInfo;
    }

*/
}
