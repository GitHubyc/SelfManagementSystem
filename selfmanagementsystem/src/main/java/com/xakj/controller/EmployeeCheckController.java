package com.xakj.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xakj.util.RightUtil;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class EmployeeCheckController {



	/**
	 * 员工考核列表
	 */
	@RequestMapping(value="/employeecheck/list")
	public String EmployeeCheck_list(ModelMap map) {
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		return "EmployeeCheck/EmployeeCheck_list";
	}
	
	/**
	 * 员工考核新增
	 */
	@RequestMapping(value="/employeecheck/add")
	public String EmployeeCheck_add() {
		
		return "EmployeeCheck_add";
	}
	
	/**
	 * 员工考核更新
	 */
	@RequestMapping(value="/employeecheck/edit")
	public String EmployeeCheck_edit() {
		
		return "EmployeeCheck_edit";
	}
	
	/**
	 * 员工考核详情
	 */
	@RequestMapping(value="/employeecheck/details")
	public String EmployeeCheck_details() {
		
		return "EmployeeCheck_details";
	}
	
}