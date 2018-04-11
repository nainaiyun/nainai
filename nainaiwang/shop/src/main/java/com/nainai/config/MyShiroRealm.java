package com.nainai.config;//package com.nainai.config;
//
///**
// * Created by haopeng yan on 2018/2/6 16:37.
// *
// * @author haopeng yan
// * @version 1.0
// * @since 1.0
// * Copyright (C) 2018. haopeng yan All Rights Received
// */
//
//import java.util.HashSet;
//import java.util.Set;
//import javax.annotation.Resource;
//
//import com.nainai.domain.User;
//import com.nainai.mapper.UserMapper;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.cas.CasRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//
//
///**
// * 权限校验核心类; 由于使用了单点登录，所以无需再进行身份认证 只需要授权即可
// *
// * @author chhliu
// */
//public class MyShiroRealm extends CasRealm {
//
//    @Resource
//    private UserMapper userMapper;
//
//    /**
//     * 1、CAS认证 ,验证用户身份
//     * 2、将用户基本信息设置到会话中,方便获取
//     * 3、该方法可以直接使用CasRealm中的认证方法，此处仅用作测试
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
//
//        // 调用父类中的认证方法，CasRealm已经为我们实现了单点认证。
//        AuthenticationInfo authc = super.doGetAuthenticationInfo(token);
//
//        // 获取登录的账号，cas认证成功后，会将账号存起来
//        String account = (String) authc.getPrincipals().getPrimaryPrincipal();
//
//        // 将用户信息存入session中,方便程序获取,此处可以将根据登录账号查询出的用户信息放到session中
//        SecurityUtils.getSubject().getSession().setAttribute("no", account);
//
//        return authc;
//    }
//
//    /**
//     * 此方法调用 hasRole,hasPermission的时候才会进行回调.
//     *
//     * 权限信息.(授权): 1、如果用户正常退出，缓存自动清空； 2、如果用户非正常退出，缓存自动清空；
//     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。 （需要手动编程进行实现；放在service进行调用）
//     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例， 调用clearCached方法；
//     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
//     *
//     * @param principals
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
//
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        // 获取单点登陆后的用户名，也可以从session中获取，因为在认证成功后，已经将用户名放到session中去了
//        String userName = (String) super.getAvailablePrincipal(principals);
////       principals.getPrimaryPrincipal(); 这种方式也可以获取用户名
//
//        // 根据用户名获取该用户的角色和权限信息
//        User user = userMapper.selectUserByUsername(userName);
//
//        if (user != null) {
//            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            //给用户添加角色（让shiro去验证）
//            Set<String> roleNames = new HashSet<>();
//            if (user.getUsername().equals("b")) {
//                roleNames.add("admin");
//            }
//            info.setRoles(roleNames);
//            if (user.getUsername().equals("b")) {
//                //给用户添加权限（让shiro去验证）
//                info.addStringPermission("admin:manage");
//            }
//            //或者按下面这样添加
//            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
//            //simpleAuthorInfo.addRole("admin");
//            //添加权限
//            //simpleAuthorInfo.addStringPermission("admin:manage");
//            //logger.info("已为用户[mike]赋予了[admin]角色和[admin:manage]权限");
//            return info;
//        }
//        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
//        return null;
//    }
//}