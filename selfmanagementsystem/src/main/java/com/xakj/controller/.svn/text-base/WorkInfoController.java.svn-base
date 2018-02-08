package com.xakj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class WorkInfoController {



	/**
	 * 每日巡查
	 */
	@RequestMapping(value="/work/day")
	public String WorkInfo_day_list(ModelMap map,
			@RequestParam(value = "display",defaultValue ="1") String display) {
		map.addAttribute("menu", "work");	
		map.addAttribute("display", display);		
		return "WorkInfos/Day/WorkInfo_day";
	}
	
	/**
	 * 每日检查详细
	 */
	@RequestMapping(value="/work/day/details")
	public String WorkInfo_day_details(ModelMap map) {
		map.addAttribute("menu", "work");
		return "WorkInfos/Day/WorkInfo_day_details";
	}
	
	/**
	 * 每月检查
	 * 
	 */
	@RequestMapping(value="/work/month")
	public String WorkInfo_month_list(ModelMap map,
			@RequestParam(value = "display",defaultValue ="1") String display) {
		map.addAttribute("menu", "work");
		map.addAttribute("display", display);
		return "WorkInfos/Month/WorkInfo_month";
	}
	
	/**
	 * 每月巡查详细
	 */
	@RequestMapping(value="/work/month/details")
	public String WorkInfo_month_details(ModelMap map) {
		map.addAttribute("menu", "work");
		return "WorkInfos/Month/WorkInfo_month_details";
	}
	
	/**
	 * 控制室检查
	 */
	@RequestMapping(value="/work/control")
	public String WorkInfo_control_list(ModelMap map,
			@RequestParam(value = "display",defaultValue ="1") String display) {
		map.addAttribute("menu", "work");
		map.addAttribute("display", display);
		return "WorkInfos/Control/WorkInfo_control";
	}
	
	/**
	 * 控制室检查详细
	 */
	@RequestMapping(value="/work/control/details")
	public String WorkInfo_control_details(ModelMap map) {
		map.addAttribute("menu", "work");
		return "WorkInfos/Control/WorkInfo_control_details";
	}
	
	/**
	 * 电子巡更
	 */
	@RequestMapping(value="/work/electronicpatrol")
	public String WorkInfo_electronicpatrol_list(ModelMap map,
			@RequestParam(value = "display",defaultValue ="1") String display) {
		map.addAttribute("menu", "work");
		map.addAttribute("display", display);
		return "WorkInfos/Electronicpatrol/WorkInfo_electronicpatrol";
	}
	
	/**
	 * 控制室检查详细
	 */
	@RequestMapping(value="/work/electronicpatrol/details")
	public String WorkInfo_electronicpatrol_details(ModelMap map) {
		map.addAttribute("menu", "work");
		return "WorkInfo_electronicpatrol_details";
	}
}