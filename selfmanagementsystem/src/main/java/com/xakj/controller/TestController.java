package com.xakj.controller;

import java.util.HashMap;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.service.ApplyService;
import com.xakj.util.HttpClientUtil;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class TestController {


	/**
	 * 应用列表
	 */
	@RequestMapping(value="/text", method = RequestMethod.GET)
	public String apply_list(ModelMap map) {
		
		return "/custom";
	}
	
	
}