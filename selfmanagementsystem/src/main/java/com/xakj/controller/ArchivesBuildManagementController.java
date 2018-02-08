package com.xakj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xakj.service.BuildInfoService;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 * 建筑管理
 */
@Controller
public class ArchivesBuildManagementController {

	@Autowired
	private BuildInfoService buildInfoService;
	
	/**
	 * 建筑信息
	 */
	@RequestMapping(value="/buildManagement/list")
	public String Build_details(ModelMap map,
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode) {
		JSONObject object = buildInfoService.findOne(buildCode);
		map.addAttribute("object", buildCode==null?null:object);
		map.addAttribute("buildCode", buildCode);	
		return "Archives/BuildManagement/BuildManagement_details";
	}	
}