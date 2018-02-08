	package com.xakj.controller;

import java.util.HashMap;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xakj.service.UnitInfoService;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class ArchivesSettledUnitController {

	@Autowired
	private UnitInfoService unitInfoService;
	
	/**
	 * 建筑的单位信息
	 */
	@RequestMapping(value="/settledUnit/list")
	public String Build_details(ModelMap map,
			@RequestParam(value = "buildCode") String buildCode,
			@RequestParam(value = "unitNature", defaultValue = "", required = false) String unitNature,
			@RequestParam(value = "unitType", defaultValue = "", required = false) Integer unitType,
			@RequestParam(value = "subordinateUnit", defaultValue = "", required = false) String subordinateUnit,
			@RequestParam(value = "xzqhCode", defaultValue = "", required = false) String xzqhCode,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("buildCode", buildCode);
		paramMap.put("unitNature", unitNature);
		paramMap.put("unitType", unitType);
		paramMap.put("subordinateUnit", subordinateUnit);
		paramMap.put("xzqhCode", xzqhCode);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject object = unitInfoService.list(paramMap);
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", buildCode==null?null:object);
		map.addAttribute("xzqhCode", xzqhCode);
		return "Archives/SettledUnit/SettledUnit_list";
	}
	/**
	 * 单位信息详情
	 */
	@RequestMapping(value = "/settledUnit/details")
	public String UnitInfo_details(ModelMap map, 
			@RequestParam(value = "unitCode", required = false) String unitCode,
			@RequestParam(value = "unitNature", required = false) Integer unitNature
			) {
		map.addAttribute("unitCode", unitCode);
		map.addAttribute("unitNature", unitNature);
		return "Archives/SettledUnit/SettledUnit_details";
	}

}