package com.xakj.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.service.FireFacilitieService;
import com.xakj.util.RightUtil;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class SprinklerSystemController {

	@Autowired
	private FireFacilitieService fireFacilitieService;

	/**
	 * 自动喷水灭火系统系统列表
	 */
	@RequestMapping(value = "/sprinklersystem/list")
	public String SprinklerSystem_list(ModelMap map,
			@RequestParam(value = "facilitieCode", defaultValue = "", required = false) String facilitieCode,
	
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject object = fireFacilitieService.listType(facilitieCode, paramMap);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("object", object);
		map.addAttribute("facilitieCode", facilitieCode);
		
		return "BuildInfos/SprinklerSystem/SprinklerSystem_list";
	}

	/**
	 * 自动喷水灭火系统系统新增页面
	 */
	@RequestMapping(value = "/sprinklersystem/add", method = RequestMethod.GET)
	public String SprinklerSystem_add() {
		return "BuildInfos/SprinklerSystem/SprinklerSystem_add";
	}

	

	/**
	 * 自动喷水灭火系统系统更新
	 */
	@RequestMapping(value = "/sprinklersystem/edit", method = RequestMethod.GET)
	public String SprinklerSystem_edit(		
			ModelMap map,
			@RequestParam(value = "facilitieCode") String facilitieCode,
			@RequestParam(value = "facilitieSystemCode") String facilitieSystemCode
			) {
		JSONObject object = fireFacilitieService.findOne(facilitieCode, facilitieSystemCode);
		map.put("object", object);
		return "BuildInfos/SprinklerSystem/SprinklerSystem_edit";
	}
	
	

	/**
	 * 自动喷水灭火系统系统详情
	 */
	@RequestMapping(value = "/sprinklersystem/details", method = RequestMethod.GET)
	public String SprinklerSystem_details(	ModelMap map,
			@RequestParam(value = "facilitieCode") String facilitieCode,
			@RequestParam(value = "facilitieSystemCode") String facilitieSystemCode
			) {
		JSONObject object = fireFacilitieService.findOne(facilitieCode, facilitieSystemCode);
		map.put("object", object);
		return "BuildInfos/SprinklerSystem/SprinklerSystem_details";
	}
	
	/**
	 * 删除自动喷水灭火系统系
	 */
	@RequestMapping(value="/sprinklersystem/del",method = RequestMethod.DELETE)
	@ResponseBody
	public String AutomaticFireAlarmSystem_del(
			@RequestParam(value = "facilitieCode") String facilitieCode,
			@RequestParam(value = "facilitieSystemCode") String facilitieSystemCode
			) {
		JSONObject object = fireFacilitieService.del(facilitieCode, facilitieSystemCode);
		return object.toString();
	}
}