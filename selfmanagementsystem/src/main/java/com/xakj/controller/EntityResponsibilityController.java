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

import com.xakj.service.EntityResponsibilityService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class EntityResponsibilityController {

	@Autowired
	private EntityResponsibilityService entityResponsibilityService;

	/**
	 * 主体责任列表
	 */
	@RequestMapping(value="/entityresponsibility/list")
	public String EntityResponsibility_list(ModelMap map,
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode,
			@RequestParam(value = "search", defaultValue = "", required = false) String search,			
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("buildCode", buildCode);
		Integer Intsearch = null;
		if(search.equals("自然人")){
			 Intsearch=0;
		}else if(search.equals("法人其他组织")){
			Intsearch= 1;
			paramMap.put("responsibilityType", Intsearch);
		}else if(search.equals("其他组织")){
			Intsearch=2;
			paramMap.put("responsibilityType", Intsearch);
		}else if(search.equals("非责任代表")){
			Intsearch= 0;
			paramMap.put("responsibilityRepresent", Intsearch);
		}else if(search.equals("是责任代表")){
			Intsearch= 1;
			paramMap.put("responsibilityRepresent", Intsearch);
		}else if(search.length()==11){
			paramMap.put("contactNumber", search);
		}else {
			paramMap.put("responsibilityPerson", search);
		}				
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		paramMap.put("search", search);
		JSONObject object = entityResponsibilityService.list(paramMap);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);
		return "BuildInfos/EntityResponsibility/EntityResponsibility_list";
	}
	
	/**
	 * 主体责任新增
	 */
	@RequestMapping(value="/entityresponsibility/add",method = RequestMethod.GET)
	public String EntityResponsibility_add() {
		
		return "BuildInfos/EntityResponsibility/EntityResponsibility_add";
	}
	
	@RequestMapping(value="/entityresponsibility/add",method = RequestMethod.POST)
	@ResponseBody
	public String Entity_add(
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode,
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = entityResponsibilityService.add(buildCode,paramMap);
		String json = object.toString();
		return json;
	}

	/**
	 * 主体责任更新
	 */
	@RequestMapping(value="/entityresponsibility/edit",method = RequestMethod.GET)
	public String EntityResponsibilityGet_edit(ModelMap map,	
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode,
			@RequestParam(value = "responsibilityCode", defaultValue = "", required = false) String responsibilityCode
			) {
		JSONObject object = entityResponsibilityService.findOne(buildCode, responsibilityCode);
		map.addAttribute("object", object);
		return "BuildInfos/EntityResponsibility/EntityResponsibility_edit";
	}
	
	
	@RequestMapping(value="/entityresponsibility/edit",method = RequestMethod.PUT)
	@ResponseBody
	public String EntityResponsibility_edit(
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode,
			@RequestParam(value = "responsibilityCode", defaultValue = "", required = false) String responsibilityCode,	
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = entityResponsibilityService.edit(buildCode,responsibilityCode,paramMap);
		String json = object.toString();
		return json;
	}
	
	/**
	 * 删除主体责任
	 */
	@RequestMapping(value = "/entityresponsibility/del", method = RequestMethod.DELETE)
	@ResponseBody
	public String EntityResponsibility_del(
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode,
			@RequestParam(value = "responsibilityCode", defaultValue = "", required = false) String responsibilityCode
			) {	
		JSONObject object = entityResponsibilityService.del(buildCode,responsibilityCode);
		String json = object.toString();
		return json;
	}
	/**
	 * 主体责任详情
	 */
	@RequestMapping(value="/entityresponsibility/details",method = RequestMethod.GET)
	public String EntityResponsibilityGet_details(ModelMap map,	
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode,
			@RequestParam(value = "responsibilityCode", defaultValue = "", required = false) String responsibilityCode
			) {
		JSONObject object = entityResponsibilityService.findOne(buildCode, responsibilityCode);
		map.addAttribute("object", object);
		return "BuildInfos/EntityResponsibility/EntityResponsibility_details";
	}
	
}