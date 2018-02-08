package com.xakj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class FacilityInfoController{



	/**
	 * 楼层信息列表
	 */
	@RequestMapping(value="/facility/list")
	public String FacilityInfo_list() {
		
		return "FacilityInfo_list";
	}
	
	/**
	 * 楼层信息新增
	 */
	@RequestMapping(value="/facility/add")
	public String FacilityInfo_add() {
		
		return "FacilityInfo_add";
	}
	
	/**
	 * 楼层信息更新
	 */
	@RequestMapping(value="/facility/edit")
	public String FacilityInfo_edit() {
		
		return "FacilityInfo_edit";
	}
	
	/**
	 * 楼层信息详情
	 */
	@RequestMapping(value="/facility/details")
	public String FacilityInfo_details() {
		
		return "FacilityInfo_details";
	}
	
}