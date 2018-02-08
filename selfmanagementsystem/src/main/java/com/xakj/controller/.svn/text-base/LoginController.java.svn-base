package com.xakj.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.sf.json.JSONObject;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		// model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@RequestBody String body, Model model,
			@RequestParam(value = "authorization", required = true, defaultValue = "false") boolean authorization) {
		JSONObject json = JSONObject.fromObject(body);
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		String username = json.getString("username");
		String password = json.getString("password");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(authorization);

		try {
			subject.login(token);
			resultMap.put("status", 200);
			resultMap.put("message", "登录成功");
		} catch (UnknownAccountException uae) {
			System.out.println("账户或密码错误!");
			resultMap.put("status", 403);
			resultMap.put("message", "账户或密码错误!");
		} catch (IncorrectCredentialsException ice) {
			System.out.println("账户或密码错误!");
			resultMap.put("status", 403);
			resultMap.put("message", "账户或密码错误!");
		} catch (LockedAccountException lae) {
			System.out.println("账户被禁了!");
			resultMap.put("status", 403);
			resultMap.put("message", "账户被禁了!");
		} catch (AuthenticationException ae) {
			System.out.println("认证错误!");
			resultMap.put("status", 403);
			resultMap.put("message", "认证错误!");
		}

		return resultMap;

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(RedirectAttributes attributes) {
		attributes.addFlashAttribute("message", "您已安全退出");
		return "redirect:/login";
	}

	@RequestMapping("/403")
	public String unauthorizedRole() {
		return "403";
	}
}
