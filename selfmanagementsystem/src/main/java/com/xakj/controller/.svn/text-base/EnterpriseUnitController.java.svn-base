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
public class EnterpriseUnitController{

	@Autowired
	private UnitInfoService unitInfoService;

	/**
	 * 企业单位列表
	 */
	@RequestMapping(value="/enterpriseunit/list")
	public String EnterpriseUnit_list() {
		
		return "UnitInfos/EnterpriseUnit/EnterpriseUnit_list";
	}
	
	/**
	 * 企业单位新增
	 */
	@RequestMapping(value="/enterpriseunit/add")
	public String EnterpriseUnit_add() {
		
		return "UnitInfos/EnterpriseUnit/EnterpriseUnit_add";
	}
	
	/**
	 * 企业单位更新
	 */
	@RequestMapping(value="/enterpriseunit/edit")
	public String EnterpriseUnit_edit(ModelMap map,@RequestParam(value = "unitCode", required = true) String unitCode) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		JSONObject object = unitInfoService.findenter(paramMap);
		JSONObject result = (JSONObject) JSONObject.fromObject(object).get(
				"data");
		JSONObject UnitInfoDto = JSONObject.fromObject(result
				.get("UnitInfoDto"));
		JSONObject enterpriseSubjectDutyDto = JSONObject.fromObject(result
				.get("enterpriseSubjectDutyDto"));
		JSONObject enterpriseUnitDto = JSONObject.fromObject(result
				.get("enterpriseUnitDto"));

		map.addAttribute("UnitInfoDto", UnitInfoDto);
		map.addAttribute("enterpriseSubjectDutyDto", enterpriseSubjectDutyDto);
		map.addAttribute("enterpriseUnitDto", enterpriseUnitDto);
		return "UnitInfos/EnterpriseUnit/EnterpriseUnit_edit";
	}
	
	/**
	 * 企业单位详情
	 */
	@RequestMapping(value="/enterpriseunit/details")
	public String EnterpriseUnit_details() {
		
		return "UnitInfos/EnterpriseUnit/EnterpriseUnit_details";
	}
	
}