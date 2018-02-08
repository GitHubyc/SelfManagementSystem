package com.xakj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class ArchivesController {

	/**
	 * 档案册页面
	 */
	@RequestMapping(value="/archives/index")
	public String Archives_index() {

		return "Archives/Archives_index";
	}
	
	/**
	 * 档案册列表
	 */
	@RequestMapping(value="/archives/list")
	public String Archives_list() {
		
		return "Archives_list";
	}
	
	/**
	 * 档案册新增
	 */
	@RequestMapping(value="/archives/add")
	public String Archives_add() {
		
		return "Archives_add";
	}
	
	/**
	 * 档案册更新
	 */
	@RequestMapping(value="/archives/edit")
	public String Archives_edit() {
		
		return "Archives_edit";
	}
	
	/**
	 * 档案册详情
	 */
	@RequestMapping(value="/archives/details")
	public String Archives_details() {
		
		return "Archives_details";
	}
}