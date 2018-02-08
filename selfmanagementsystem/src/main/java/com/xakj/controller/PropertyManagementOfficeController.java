package com.xakj.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xakj.service.UnitInfoService;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class PropertyManagementOfficeController {

	@Autowired
	private UnitInfoService unitInfoService;

	/**
	 * 物业管理处列表
	 */
	@RequestMapping(value="/propertymanagementoffice/list")
	public String PropertyManagementOffice_list() {
		
		return "UnitInfos/PropertyManagementOffice/PropertyManagementOffice_list";
	}
	
	/**
	 * 物业管理处新增
	 */
	@RequestMapping(value="/propertymanagementoffice/add")
	public String PropertyManagementOffice_add() {
		
		return "UnitInfos/PropertyManagementOffice/PropertyManagementOffice_add";
	}
	
	/**
	 * 物业管理处更新
	 */
	@RequestMapping(value="/propertymanagementoffice/edit")
	public String PropertyManagementOffice_edit(ModelMap map,@RequestParam(value = "unitCode", required = true) String unitCode) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		JSONObject object = unitInfoService.findproperty(paramMap);
		JSONObject result = (JSONObject) JSONObject.fromObject(object).get(
				"data");
		JSONObject UnitInfoDto = JSONObject.fromObject(result
				.get("UnitInfoDto"));
		JSONObject propertyManagementOfficeDto = JSONObject.fromObject(result
				.get("propertyManagementOfficeDto"));
		JSONObject propertyServeDto = JSONObject.fromObject(result
				.get("propertyServeDto"));
		map.addAttribute("UnitInfoDto", UnitInfoDto);
		map.addAttribute("propertyManagementOfficeDto",
				propertyManagementOfficeDto);
		map.addAttribute("propertyServeDto", propertyServeDto);
		return "UnitInfos/PropertyManagementOffice/PropertyManagementOffice_edit";
	}
	
	/**
	 * 物业管理处详情
	 */
	@RequestMapping(value="/propertymanagementoffice/details")
	public String PropertyManagementOffice_details() {
		
		return "UnitInfos/PropertyManagementOffice/PropertyManagementOffice_details";
	}
	
}