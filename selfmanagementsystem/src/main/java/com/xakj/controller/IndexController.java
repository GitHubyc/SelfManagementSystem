package com.xakj.controller;

import java.util.HashMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xakj.constant.Constant;
import com.xakj.model.dto.User;
import com.xakj.service.UserService;
import com.xakj.util.RightUtil;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class IndexController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String init(ModelMap map) {	
		map.addAttribute("title", "欢迎您!");	
		return "login";
	}

	/**
	 * 主页
	 */
	@RequestMapping("/index")
	public String index(ModelMap map) {
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());	
		return "index";
	}

		
}