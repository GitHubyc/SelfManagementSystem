package com.xakj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class PoliceStationController {



	/**
	 * 派出所列表
	 */
	@RequestMapping(value="/policestation/list")
	public String PoliceStation_list() {
		
		return "FirePoliceForces/PoliceStation/PoliceStation_list";
	}
	
	/**
	 * 派出所新增
	 */
	@RequestMapping(value="/policestation/add")
	public String PoliceStation_add() {
		
		return "FirePoliceForces/PoliceStation/PoliceStation_add";
	}
	
	/**
	 * 派出所更新
	 */
	@RequestMapping(value="/policestation/edit")
	public String PoliceStation_edit() {
		
		return "FirePoliceForces/PoliceStation/PoliceStation_edit";
	}
	
	/**
	 * 管理大队列表
	 */
	@RequestMapping(value="/brigadepersonnel/list")
	public String PoliceStation_details() {
		
		return "FirePoliceForces/BrigadePersonnel/BrigadePersonnel_list";
	}
	
}