package com.xakj.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.xakj.constant.Constant;
import com.xakj.model.dto.Right;
import com.xakj.model.dto.Role;
import com.xakj.model.dto.User;
import com.xakj.service.LoginService;
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private LoginService loginService;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Constant.USER);
		
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> role = user.getRole();	// 赋予角色
        for (int j = 0; j < role.size(); j++) {
			info.addRole(role.get(j).getRoleName());
		}
        List<Right> right = user.getRight();	// 赋予权限
        List<String> permissions = new ArrayList<String>();
        for (int j = 0; j < right.size(); j++) {
        	if(right.get(j).getRightType().equals("1")){
        		permissions.add(right.get(j).getMenuUrl());
        	}else{
        		permissions.add(right.get(j).getOperateUrl());
        	}
		}
		info.addStringPermissions(permissions);		// 将权限放入shiro中.
		return info;
	}

	/**
	 * 认证信息.(身份验证) : Authentication 是用来验证用户身份
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String userName = token.getUsername();
		String password = String.valueOf(token.getPassword());
		User user = loginService.Login(userName, password);

		if (user != null) {
			// byte[] salt = Encodes.decodeHex(user.getSalt());
			// ShiroUser shiroUser=new ShiroUser(user.getId(),
			// user.getLoginName(), user.getName());
			// 设置用户session
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute(Constant.USER, user);
			return new SimpleAuthenticationInfo(userName, token.getPassword(),
					getName());
		} else {
			return null;
		}
	}

}
//JSONObject allObject = rightService.list(null);
//ShiroConfiguration sc = new ShiroConfiguration();
//sc.shiroFilterFactoryBean(allObject);
