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

import com.xakj.service.KeySiteService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class KeySiteController {

	@Autowired
	private KeySiteService keySiteService;

	/**
	 * 重点部位列表
	 */
	@RequestMapping(value="/keysite/list", method = RequestMethod.GET)
	public String KeySite_list(
			ModelMap map,
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode,
			@RequestParam(value = "floorCode", defaultValue = "", required = false) String floorCode,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize
			) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject keysite=keySiteService.list(buildCode, floorCode, paramMap);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("object", keysite);
		map.addAttribute("buildCode", buildCode);
		map.addAttribute("floorCode", floorCode);
		return "BuildInfos/KeySite/KeySite_list";
	}
	
	
	
	
	/**
	 * 重点部位新增
	 */
	@RequestMapping(value="/keysite/add" , method = RequestMethod.GET)
	public String KeySite_add() {
		return "BuildInfos/KeySite/KeySite_add";
	}
	
	@RequestMapping(value = "/keysite/add", method = RequestMethod.POST)
	@ResponseBody
	public String KeySite_add(
			@RequestParam(value = "buildCode") String buildCode,
			@RequestParam(value = "floorCode") String floorCode,
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = keySiteService.add(buildCode, floorCode, paramMap);
			return object.toString();		
	}
	
	/**
	 * 重点部位更新
	 */
	
	@RequestMapping(value="/keysite/edit", method = RequestMethod.GET)
	public String KeySite_edit(
			ModelMap map,
			@RequestParam(value = "buildCode") String buildCode,
			@RequestParam(value = "floorCode") String floorCode,
			@RequestParam(value = "keySiteCode") String keySiteCode	
			) {	
		JSONObject object = keySiteService.findOne(buildCode, floorCode, keySiteCode);
		map.put("object", object);
		return "BuildInfos/KeySite/KeySite_edit";
	}
	
	
	@RequestMapping(value = "/keysite/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String KeySite_edit(
			@RequestParam(value = "buildCode") String buildCode,
			@RequestParam(value = "floorCode") String floorCode,
			@RequestParam(value = "keySiteCode") String keySiteCode,
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = keySiteService.edit(buildCode, floorCode, keySiteCode, paramMap);
		return object.toString();
	}
	
	/**
	 * 删除重点部位
	 */
	@RequestMapping(value="/keysite/del",method = RequestMethod.DELETE)
	@ResponseBody
	public String KeySite_del(
			@RequestParam(value = "buildCode") String buildCode,
			@RequestParam(value = "floorCode") String floorCode,
			@RequestParam(value = "keySiteCode") String keySiteCode
			) {
		JSONObject object = keySiteService.del(buildCode, floorCode, keySiteCode);
		return object.toString();
	}
	
	/**
	 * 查看重点部位
	 */
	@RequestMapping(value="/keysite/details", method = RequestMethod.GET)
	public String KeySite_details(
			ModelMap map,
			@RequestParam(value = "buildCode") String buildCode,
			@RequestParam(value = "floorCode") String floorCode,
			@RequestParam(value = "keySiteCode") String keySiteCode
			) {
		JSONObject object = keySiteService.findOne(buildCode, floorCode, keySiteCode);
		map.put("object", object);
		return "BuildInfos/KeySite/KeySite_details";
	}
	
	
}