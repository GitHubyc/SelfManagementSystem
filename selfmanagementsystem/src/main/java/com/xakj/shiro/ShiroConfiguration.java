package com.xakj.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ShiroConfiguration {
 
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean(name = "hashedCredentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName("MD5");
		credentialsMatcher.setHashIterations(2);
		credentialsMatcher.setStoredCredentialsHexEncoded(true);
		return credentialsMatcher;
	}

	@Bean(name = "shiroRealm")
	@DependsOn("lifecycleBeanPostProcessor")
	public ShiroRealm shiroRealm() {
		ShiroRealm realm = new ShiroRealm();
		// realm.setCredentialsMatcher(hashedCredentialsMatcher());
		return realm;
	}

	 /**
	 * EhCacheManager，缓存管理，用户登陆成功后，把用户信息和权限信息缓存起来，
	 * 然后每次用户请求时，放入用户的session中，如果不设置这个bean，每个请求都会查询一次数据库。
	 */
//	 @Bean(name = "ehCacheManager")
//	 @DependsOn("lifecycleBeanPostProcessor")
//	 public EhCacheManager ehCacheManager() {
//		 return new EhCacheManager();
//	 }

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm());
		// securityManager.setCacheManager(ehCacheManager());
		return securityManager;
	}

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// 未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		// 拦截器.
		Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
		filterChainDefinitionManager.put("/logout", "logout");
		filterChainDefinitionManager.put("/entityResponsibility", "anon");
		filterChainDefinitionManager.put("/login", "anon");
		filterChainDefinitionManager.put("/css/**", "anon");
		filterChainDefinitionManager.put("/fonts/**", "anon");
		filterChainDefinitionManager.put("/img/**", "anon");
		filterChainDefinitionManager.put("/js/**", "anon");
		filterChainDefinitionManager.put("/json/**", "anon");
		filterChainDefinitionManager.put("/ueditor/**", "anon");
		filterChainDefinitionManager.put("/index", "anon");
		//为以下权限加上权限链接验证（即访问链接必须有该链接的权限）
//		filterChainDefinitionManager.put("/user/list", "authc,perms[/user/list]");
//		filterChainDefinitionManager.put("/role/list", "authc,perms[/role/list]");
//		filterChainDefinitionManager.put("/group/list", "authc,perms[/group/list]");
//		filterChainDefinitionManager.put("/right/list", "authc,perms[/right/list]");
//		filterChainDefinitionManager.put("/build/list", "authc,perms[/build/list]");
//		filterChainDefinitionManager.put("/unit/list", "authc,perms[/unit/list]");
//		filterChainDefinitionManager.put("/employee/list", "authc,perms[/employee/list]");
//		filterChainDefinitionManager.put("/employeecheck/list", "authc,perms[/employeecheck/list]");
//		filterChainDefinitionManager.put("/firecontrolinstrumentation/list", "authc,perms[/firecontrolinstrumentation/list]");
//		filterChainDefinitionManager.put("/label/list", "authc,perms[/label/list]");
//		filterChainDefinitionManager.put("/managementinformation/list", "authc,perms[/managementinformation/list]");
//		filterChainDefinitionManager.put("/firepoliceforce/list", "authc,perms[/firepoliceforce/list]");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
		return shiroFilterFactoryBean;
	}

	@Bean
	@ConditionalOnMissingBean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
		defaultAAP.setProxyTargetClass(true);
		return defaultAAP;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor aASA = new AuthorizationAttributeSourceAdvisor();
		aASA.setSecurityManager(securityManager());
		return aASA;
	}
}
