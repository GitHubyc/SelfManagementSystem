package com.xakj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 * 自我管理
 */
@Controller
public class ArchivesBuildingSelfManagementController {
	/**
	 * 每日巡查
	 */
	@RequestMapping(value="/buildingSelfManagement/day")
	public String WorkInfo_day_list(ModelMap map) {
		map.addAttribute("menu", "work");		
		return "Archives/BuildingSelfManagement/Day/WorkInfo_day";
	}
	
	/**
	 * 每日检查详细
	 */
	@RequestMapping(value="/buildingSelfManagement/day/details")
	public String WorkInfo_day_details(ModelMap map) {
		map.addAttribute("menu", "work");
		return "Archives/BuildingSelfManagement/Day/WorkInfo_day_details";
	}
	
	/**
	 * 每月检查
	 * 
	 */
	@RequestMapping(value="/buildingSelfManagement/month")
	public String WorkInfo_month_list(ModelMap map) {
		map.addAttribute("menu", "work");
		return "Archives/BuildingSelfManagement/Month/WorkInfo_month";
	}
	
	/**
	 * 每月巡查详细
	 */
	@RequestMapping(value="/buildingSelfManagement/month/details")
	public String WorkInfo_month_details(ModelMap map) {
		map.addAttribute("menu", "work");
		return "Archives/BuildingSelfManagement/Month/WorkInfo_month_details";
	}
	
	/**
	 * 控制室检查
	 */
	@RequestMapping(value="/buildingSelfManagement/control")
	public String WorkInfo_control_list(ModelMap map) {
		map.addAttribute("menu", "work");
		return "Archives/BuildingSelfManagement/Control/WorkInfo_control";
	}
	
	/**
	 * 控制室检查详细
	 */
	@RequestMapping(value="/buildingSelfManagement/control/details")
	public String WorkInfo_control_details(ModelMap map) {
		map.addAttribute("menu", "work");
		return "Archives/BuildingSelfManagement/Control/WorkInfo_control_details";
	}
	
	/**
	 * 电子巡更
	 */
	@RequestMapping(value="/buildingSelfManagement/electronicpatrol")
	public String WorkInfo_electronicpatrol_list(ModelMap map) {
		map.addAttribute("menu", "work");
		return "Archives/BuildingSelfManagement/Electronicpatrol/WorkInfo_electronicpatrol";
	}
	
	/**
	 * 电子巡更详细
	 */
	@RequestMapping(value="/buildingSelfManagement/electronicpatrol/details")
	public String WorkInfo_electronicpatrol_details(ModelMap map) {
		map.addAttribute("menu", "work");
		return "Archives/WorkInfo_electronicpatrol_details";
	}
	
	/**
	 * 物联监控
	 */
	@RequestMapping(value="/buildingSelfManagement/jointMonitoring")
	public String WorkInfo_jointMonitoring_list(ModelMap map) {
		map.addAttribute("menu", "work");
		return "Archives/BuildingSelfManagement/JointMonitoring/WorkInfo_jointMonitoring";
	}
	
	/**
	 * 物联监控详细
	 */
	@RequestMapping(value="/buildingSelfManagement/jointMonitoring/details")
	public String WorkInfo_jointMonitoring_details(ModelMap map) {
		map.addAttribute("menu", "work");
		return "Archives/WorkInfo_electronicpatrol_details";
	}
}