package com.xakj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xakj.util.RightUtil;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class FirePoliceForceController {



	/**
	 * 消防警力列表
	 */
	@RequestMapping(value="/firepoliceforce/list")
	public String FirePoliceForce_list(ModelMap map) {
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		return "FirePoliceForces/FirePoliceForce/FirePoliceForce_list";
	}
	
	/**
	 * 消防警力新增
	 */
	@RequestMapping(value="/firepoliceforce/add")
	public String FirePoliceForce_add() {
		
		return "FirePoliceForces/FirePoliceForce/FirePoliceForce_add";
	}
	
	/**
	 * 消防警力更新
	 */
	@RequestMapping(value="/firepoliceforce/edit")
	public String FirePoliceForce_edit() {
		
		return "FirePoliceForces/FirePoliceForce/FirePoliceForce_edit";
	}
	
	/**
	 * 消防警力详情
	 */
	@RequestMapping(value="/firepoliceforce/details")
	public String FirePoliceForce_details() {
		
		return "FirePoliceForces/FirePoliceForce/FirePoliceForce_details";
	}
	
}