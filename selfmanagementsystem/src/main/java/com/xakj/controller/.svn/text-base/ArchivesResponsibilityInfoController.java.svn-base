package com.xakj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class ArchivesResponsibilityInfoController {

	/**
	 * 主体责任签订
	 */
	@RequestMapping(value="/entityResponsibility/details")
	public String EntityResponsibility_details(ModelMap map,
	@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode		
			) {
		map.addAttribute("menu", "entityResponsibility");	
		map.addAttribute("buildCode", buildCode);	
		return "Archives/ResponsibilityInfo/EntityResponsibility_details";
	}
	
	/**
	 * 管理责任签订
	 */
	@RequestMapping(value="/managerResponsibility/details")
	public String ManagerResponsibility_details(ModelMap map,
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode) {
		map.addAttribute("menu", "entityResponsibility");
		map.addAttribute("buildCode", buildCode);	
		return "Archives/ResponsibilityInfo/ManagerResponsibility_details";
	}
	
	/**
	 * 主体责任信息
	 */
	@RequestMapping(value="/entityResponsibilityinfo/details")
	public String EntityResponsibilityinfo_details(ModelMap map,
	@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode		
			) {
		map.addAttribute("menu", "entityResponsibilityinfo");	
		map.addAttribute("buildCode", buildCode);	
		return "Archives/ResponsibilityInfo/EntityResponsibilityInfo_details";
	}
	
	/**
	 * 管理责任信息
	 */
	@RequestMapping(value="/managerResponsibilityinfo/details")
	public String ManagerResponsibilityinfo_details(ModelMap map,
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode) {
		map.addAttribute("menu", "entityResponsibilityinfo");
		map.addAttribute("buildCode", buildCode);	
		return "Archives/ResponsibilityInfo/ManagerResponsibilityInfo_details";
	}
}