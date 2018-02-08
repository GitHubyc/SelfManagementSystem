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

import com.xakj.service.HouseInfoService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class HouseInfoController {

	@Autowired
	private HouseInfoService houseInfoService;

	/**
	 * 房屋信息列表
	 */
	@RequestMapping(value="/house/list", method = RequestMethod.GET)
	public String HouseInfo_list(
			ModelMap map,
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode,
			@RequestParam(value = "floorCode", defaultValue = "", required = false) String floorCode,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize
			) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject house=houseInfoService.list(buildCode, floorCode, paramMap);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("object", house);
		map.addAttribute("buildCode", buildCode);
		map.addAttribute("floorCode", floorCode);
		return "BuildInfos/HouseInfo/HouseInfo_list";
	}

	/**
	 * 房屋信息新增
	 */
	@RequestMapping(value="/house/add", method = RequestMethod.GET)
	public String HouseInfo_add() {
		return "BuildInfos/HouseInfo/HouseInfo_add";
	}
	
	@RequestMapping(value = "/house/add", method = RequestMethod.POST)
	@ResponseBody
	public String HouseInfo_add(
			@RequestParam(value = "buildCode" , required = true) String buildCode,
			@RequestParam(value = "floorCode" , required = true) String floorCode,
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = houseInfoService.add(buildCode, floorCode, paramMap);
			return object.toString();		
	}

	/**
	 * 房屋信息更新
	 */
	
	@RequestMapping(value="/house/edit", method = RequestMethod.GET)
	public String HouseInfo_edit(
			ModelMap map,
			@RequestParam(value = "buildCode") String buildCode,
			@RequestParam(value = "floorCode") String floorCode,
			@RequestParam(value = "houseCode") String houseCode
			) {
		JSONObject object = houseInfoService.findOne(buildCode, floorCode, houseCode);
		map.put("object", object);
		return "BuildInfos/HouseInfo/HouseInfo_edit";
	}
	
	
	@RequestMapping(value = "/house/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String HouseInfo_edit(@RequestParam(value = "buildCode") String buildCode,
			@RequestParam(value = "floorCode") String floorCode,
			@RequestParam(value = "houseCode") String houseCode,
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = houseInfoService.edit(buildCode, floorCode, houseCode, paramMap);
		return object.toString();
	}
	
	/**
	 * 删除房屋信息
	 */
	@RequestMapping(value="/house/del",method = RequestMethod.DELETE)
	@ResponseBody
	public String HouseInfo_del(
			@RequestParam(value = "buildCode") String buildCode,
			@RequestParam(value = "floorCode") String floorCode,
			@RequestParam(value = "houseCode") String houseCode
			) {
		JSONObject object = houseInfoService.del(buildCode, floorCode, houseCode);
		return object.toString();
	}
	
}