package com.xakj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class NoticeController {



	/**
	 * 公告通知列表
	 */
	@RequestMapping(value="/notice/list")
	public String NoticeForce_list() {
		
		return "Notice_list";
	}
	
	/**
	 * 公告通知新增
	 */
	@RequestMapping(value="/notice/add")
	public String NoticeForce_add() {
		
		return "Notice_add";
	}
	
	/**
	 * 公告通知更新
	 */
	@RequestMapping(value="/notice/edit")
	public String NoticeForce_edit() {
		
		return "Notice_edit";
	}
	
	/**
	 * 公告通知详情
	 */
	@RequestMapping(value="/notice/details")
	public String NoticeForce_details() {
		
		return "Notice_details";
	}
	
}