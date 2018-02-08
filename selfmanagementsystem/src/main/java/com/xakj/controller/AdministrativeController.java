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
public class AdministrativeController {

	@Autowired
	private UnitInfoService unitInfoService;

	/**
	 * 行政单位列表
	 */
	@RequestMapping(value="/administrative/list")
	public String Administrative_list() {
		
		return "Administrative_list";
	}
	
	/**
	 * 行政单位新增
	 */
	@RequestMapping(value="/administrative/add")
	public String Administrative_add() {
		
		return "UnitInfos/Administrative/Administrative_add";
	}
	
	/**
	 * 行政单位更新
	 */
	@RequestMapping(value="/administrative/edit")
	public String Administrative_edit(ModelMap map,@RequestParam(value = "unitCode", required = true) String unitCode) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		JSONObject object = unitInfoService.findadmin(paramMap);
		JSONObject result = (JSONObject) JSONObject.fromObject(object).get(
				"data");
		JSONObject UnitInfoDto = JSONObject.fromObject(result
				.get("UnitInfoDto"));
		JSONObject AdministrativeJurisdictionDto = JSONObject.fromObject(result
				.get("AdministrativeJurisdictionDto"));
		JSONObject AdministrativeUnitDto = JSONObject.fromObject(result
				.get("AdministrativeUnitDto"));

		map.addAttribute("UnitInfoDto", UnitInfoDto);
		map.addAttribute("AdministrativeJurisdictionDto",
				AdministrativeJurisdictionDto);
		map.addAttribute("AdministrativeUnitDto", AdministrativeUnitDto);
		return "UnitInfos/Administrative/Administrative_edit";
	}
	
	/**
	 * 行政单位详情
	 */
	@RequestMapping(value="/administrative/details")
	public String Administrative_details() {
		
		return "Administrative_details";
	}
	
}