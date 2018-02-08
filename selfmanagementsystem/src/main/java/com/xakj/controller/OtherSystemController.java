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
public class OtherSystemController {


	@Autowired
	private FireFacilitieService fireFacilitieService;

	/**
	 * 其他系统列表
	 */
	@RequestMapping(value = "/othersystem/list")
	public String OtherSystem_list(ModelMap map,
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
		
		return "BuildInfos/OtherSystem/OtherSystem_list";
	}

	/**
	 * 其他系统新增页面
	 */
	@RequestMapping(value = "/othersystem/add", method = RequestMethod.GET)
	public String OtherSystem_add() {
		return "BuildInfos/OtherSystem/OtherSystem_add";
	}


	/**
	 * 其他系统更新
	 */
	@RequestMapping(value = "/othersystem/edit", method = RequestMethod.GET)
	public String OtherSystem_edit(		
			ModelMap map,
			@RequestParam(value = "facilitieCode") String facilitieCode,
			@RequestParam(value = "facilitieSystemCode") String facilitieSystemCode
			) {
		JSONObject object = fireFacilitieService.findOne(facilitieCode, facilitieSystemCode);
		map.put("object", object);
		return "BuildInfos/OtherSystem/OtherSystem_edit";
	}
	


	/**
	 * 其他系统详情
	 */
	@RequestMapping(value = "/othersystem/details", method = RequestMethod.GET)
	public String OtherSystem_details(	ModelMap map,
			@RequestParam(value = "facilitieCode") String facilitieCode,
			@RequestParam(value = "facilitieSystemCode") String facilitieSystemCode
			) {
		JSONObject object = fireFacilitieService.findOne(facilitieCode, facilitieSystemCode);
		map.put("object", object);
		return "BuildInfos/OtherSystem/OtherSystem_details";
	}
	
	/**
	 * 删除其他系统
	 */
	@RequestMapping(value="/othersystem/del",method = RequestMethod.DELETE)
	@ResponseBody
	public String AutomaticFireAlarmSystem_del(
			@RequestParam(value = "facilitieCode") String facilitieCode,
			@RequestParam(value = "facilitieSystemCode") String facilitieSystemCode
			) {
		JSONObject object = fireFacilitieService.del(facilitieCode, facilitieSystemCode);
		return object.toString();
	}
}