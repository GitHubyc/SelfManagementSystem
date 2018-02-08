package com.xakj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xakj.util.RightUtil;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class LabelController {



	/**
	 * 标签列表
	 */
	@RequestMapping(value="/label/list")
	public String Label_list(ModelMap map) {
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		return "Labels/Label_list";
	}
	
	/**
	 * 标签新增
	 */
	@RequestMapping(value="/label/add")
	public String Label_add() {
		
		return "Labels/Label_add";
	}
	
	/**
	 * 标签更新
	 */
	@RequestMapping(value="/label/edit")
	public String Label_edit() {
		
		return "Labels/Label_edit";
	}
	
	/**
	 * 标签查看
	 */
	@RequestMapping(value="/label/details")
	public String Label_details() {
		
		return "Labels/Label_details";
	}
	
	/**
	 * 标签查看详情
	 */
	@RequestMapping(value="/label/check")
	public String Label_check() {
		
		return "Labels/Label_check";
	}
	
	/**
	 * 标签查看详情
	 */
	@RequestMapping(value="/label/check/details")
	public String Label_check_details() {
		
		return "Labels/Label_check_details";
	}
	
}