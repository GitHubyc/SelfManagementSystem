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
public class FirebroadcastingsystemController {

	@Autowired
	private FireFacilitieService fireFacilitieService;

	/**
	 * 火灾应急广播系统列表
	 */
	@RequestMapping(value = "/firebroadcastingsystem/list")
	public String Firebroadcastingsystem_list(ModelMap map,
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
		
		return "BuildInfos/Firebroadcastingsystem/Firebroadcastingsystem_list";
	}

	/**
	 * 火灾应急广播系统新增页面
	 */
	@RequestMapping(value = "/firebroadcastingsystem/add", method = RequestMethod.GET)
	public String Firebroadcastingsystem_add() {
		return "BuildInfos/Firebroadcastingsystem/Firebroadcastingsystem_add";
	}

	

	/**
	 * 火灾应急广播系统更新
	 */
	@RequestMapping(value = "/firebroadcastingsystem/edit", method = RequestMethod.GET)
	public String Firebroadcastingsystem_edit(		
			ModelMap map,
			@RequestParam(value = "facilitieCode") String facilitieCode,
			@RequestParam(value = "facilitieSystemCode") String facilitieSystemCode
			) {
		JSONObject object = fireFacilitieService.findOne(facilitieCode, facilitieSystemCode);
		map.put("object", object);
		return "BuildInfos/Firebroadcastingsystem/Firebroadcastingsystem_edit";
	}
	
	

	/**
	 * 火灾应急广播系统详情
	 */
	@RequestMapping(value = "/firebroadcastingsystem/details", method = RequestMethod.GET)
	public String Firebroadcastingsystem_details(	ModelMap map,
			@RequestParam(value = "facilitieCode") String facilitieCode,
			@RequestParam(value = "facilitieSystemCode") String facilitieSystemCode
			) {
		JSONObject object = fireFacilitieService.findOne(facilitieCode, facilitieSystemCode);
		map.put("object", object);
		return "BuildInfos/Firebroadcastingsystem/Firebroadcastingsystem_details";
	}
	
	/**
	 * 删除火灾应急广播系统
	 */
	@RequestMapping(value="/firebroadcastingsystem/del",method = RequestMethod.DELETE)
	@ResponseBody
	public String AutomaticFireAlarmSystem_del(
			@RequestParam(value = "facilitieCode") String facilitieCode,
			@RequestParam(value = "facilitieSystemCode") String facilitieSystemCode
			) {
		JSONObject object = fireFacilitieService.del(facilitieCode, facilitieSystemCode);
		return object.toString();
	}
	
}