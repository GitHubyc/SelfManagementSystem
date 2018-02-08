package com.xakj.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.service.FireFacilitieService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class FireFacilitiesController {

	@Autowired
	private FireFacilitieService fireFacilitieService;

	/**
	 * 消防设施列表
	 */

	@RequestMapping(value = "/firefacilities/list")
	public String FireFacilities_list(ModelMap map,
			@RequestParam(value = "buildCode", required = true) String buildCode,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "20", required = false) Integer pageSize) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		JSONArray totalRows= new JSONArray();
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		paramMap.put("buildCode", buildCode);
		JSONObject object = fireFacilitieService.list(paramMap);	
		if(!object.getString("data").equals("null")){
		JSONArray array = JSONArray.fromObject(object.getString("data"));
		for (int i = 0; i < array.size(); i++) {	
			JSONObject result =fireFacilitieService.listType(array.getJSONObject(i).getString("facilitieCode"), paramMap);					
			totalRows.add(result.getString("totalRows"));
		}}
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("object", object);		
		map.addAttribute("row", totalRows);
		map.addAttribute("buildCode", buildCode);
		return "BuildInfos/FireFacilities/FireFacilities_list";
	}
	
	/**
	 * 消防设施列表
	 */

	@RequestMapping(value = "/firefacilities/details")
	public String FireFacilities_details(ModelMap map,
			@RequestParam(value = "buildCode", required = true) String buildCode,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "20", required = false) Integer pageSize) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		paramMap.put("buildCode", buildCode);
		JSONObject object = fireFacilitieService.list(paramMap);	
		map.addAttribute("object", object);		
		map.addAttribute("buildCode", buildCode);
		return "BuildInfos/FireFacilities/FireFacilities_details";
	}
	

	/**
	 * 消防设施设置
	 */
	@RequestMapping(value = "/firefacilities/setfire", method = RequestMethod.GET)
	public String FireFacilities_listType(ModelMap map,
			@RequestParam(value = "buildCode", required = true) String buildCode,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "20", required = false) Integer pageSize
		) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		JSONArray facilitieType= new JSONArray();
		paramMap.put("buildCode", buildCode);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject object = fireFacilitieService.list(paramMap);
		if(!object.getString("data").equals("null")){
		JSONArray array=JSONArray.fromObject(object.getString("data"));
		for (int i = 0; i < array.size(); i++) {		
			facilitieType.add(array.getJSONObject(i).getString("facilitieType"));
		}}else{
			facilitieType.add(0);
		}
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("facilitieType", facilitieType);
		return "BuildInfos/FireFacilities/FireFacilities_setFire";
	}
	
	@RequestMapping(value = "/firefacilities/setfire", method = RequestMethod.POST)
	@ResponseBody
	public String FireFacilities_listType(@RequestBody String body) {
		JSONObject object = fireFacilitieService.setFire(body);
		return object.toString();
	}

	/**
	 * 消防设施新增
	 */
	@RequestMapping(value = "/fireFacilitie/add", method = RequestMethod.POST)
	@ResponseBody
	public String FireFacilities_add(
			@RequestParam(value = "facilitieCode") String facilitieCode,		
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = fireFacilitieService.add(facilitieCode, paramMap);
		return object.toString();
	}

	/**
	 * 消防设施更新
	 */
	
	@RequestMapping(value = "/fireFacilitie/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String FireFacilities_edit(
			@RequestParam(value = "facilitieCode") String facilitieCode,		
			@RequestParam(value = "facilitieSystemCode") String facilitieSystemCode,	
			@RequestBody String body
			) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = fireFacilitieService.edit(facilitieCode, facilitieSystemCode, paramMap);
		return object.toString();
	}
	
	
}