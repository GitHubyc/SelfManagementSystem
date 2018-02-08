package com.xakj.controller;

import java.util.HashMap;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.service.ApplyService;
import com.xakj.util.HttpClientUtil;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class ApplyController {

	@Autowired
	private ApplyService applyService;

	/**
	 * 应用列表
	 */
	@RequestMapping(value="/apply/list", method = RequestMethod.GET)
	public String apply_list(ModelMap map) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();	
		JSONObject object = applyService.list(paramMap);
		map.addAttribute("object", object);
		return "Users/apply/apply_list";
	}
	
	/**
	 * 应用新增
	 */
	@RequestMapping(value="/apply/add/{applyId}", method = RequestMethod.GET)
	public String to_apply_add(
			ModelMap map,
			@PathVariable("applyId") String applyId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("applyId", applyId);
		JSONObject object = applyService.list(paramMap);
		JSONObject allobject = applyService.list(new HashMap<String, Object>());
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/apply/apply_add";
	}
	
	@RequestMapping(value = "/apply/add", method = RequestMethod.POST)
	@ResponseBody
	public String apply_add(@RequestBody String body) {
		HashMap<String, Object> paramMap =HttpClientUtil.toMap(body);
		HashMap<String, Object> applyDto = new HashMap<String, Object>();
		HashMap<String, Object> menuDto = new HashMap<String, Object>();
		HashMap<String, Object> operateDto = new HashMap<String, Object>();
		applyDto.put("applyId", paramMap.get("applyId"));
		applyDto.put("parentId", paramMap.get("parentId"));
		applyDto.put("applyType", paramMap.get("applyType"));
		if(paramMap.get("applyType").equals("2")){
			operateDto.put("operateType", paramMap.get("operateType"));
			operateDto.put("operateName", paramMap.get("operateName"));
			operateDto.put("operateUrl", paramMap.get("operateUrl"));
			operateDto.put("operateDescribe", paramMap.get("operateDescribe"));
			paramMap =  new HashMap<String, Object>();
			paramMap.put("operateDto", operateDto);
		}else{
			menuDto.put("menuDescribe", paramMap.get("menuDescribe"));
			menuDto.put("menuSort", paramMap.get("menuSort"));
			menuDto.put("menuUrl", paramMap.get("menuUrl"));
			menuDto.put("menuName", paramMap.get("menuName"));
			menuDto.put("menuIcon", paramMap.get("menuIcon"));
			paramMap =  new HashMap<String, Object>();
			paramMap.put("menuDto", menuDto);
		}
		paramMap.put("applyDto", applyDto);
		JSONObject object = applyService.add(paramMap);
		String json=object.toString();
		return json;
	}
	
	/**
	 * 应用删除
	 */
	@RequestMapping(value="/apply/{applyId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String apply_del(@PathVariable("applyId") String applyId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("applyId",applyId);
		JSONObject object = applyService.del(paramMap);
		String json = object.toString();
		return json;
	}
	
	/**
	 * 应用更新
	 */
	@RequestMapping(value="/apply/edit/{applyId}", method = RequestMethod.GET)
	public String apply_edit(
			ModelMap map, 
			@PathVariable("applyId") String applyId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("applyId", applyId);
		JSONObject object = applyService.list(paramMap);
		JSONObject allobject = applyService.list(new HashMap<String, Object>());
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/apply/apply_edit";
	}

	@RequestMapping(value = "/apply", method = RequestMethod.PUT)
	@ResponseBody
	public String apply_edit(@RequestBody String body) {
		HashMap<String, Object> paramMap =HttpClientUtil.toMap(body);
		HashMap<String, Object> applyDto = new HashMap<String, Object>();
		HashMap<String, Object> menuDto = new HashMap<String, Object>();
		HashMap<String, Object> operateDto = new HashMap<String, Object>();
		applyDto.put("applyId", paramMap.get("applyId"));
		applyDto.put("parentId", paramMap.get("parentId"));
		applyDto.put("applyType", paramMap.get("applyType"));
		String applyId = (String) paramMap.get("applyId");
		if(paramMap.get("applyType").equals("2")){
			operateDto.put("operateType", paramMap.get("operateType"));
			operateDto.put("operateName", paramMap.get("operateName"));
			operateDto.put("operateUrl", paramMap.get("operateUrl"));
			operateDto.put("operateDescribe", paramMap.get("operateDescribe"));
			paramMap =  new HashMap<String, Object>();
			paramMap.put("operateDto", operateDto);
		}else{
			menuDto.put("menuDescribe", paramMap.get("menuDescribe"));
			menuDto.put("menuSort", paramMap.get("menuSort"));
			menuDto.put("menuUrl", paramMap.get("menuUrl"));
			menuDto.put("menuName", paramMap.get("menuName"));
			paramMap =  new HashMap<String, Object>();
			paramMap.put("menuDto", menuDto);
		}
		paramMap.put("applyDto", applyDto);
		paramMap.put("applyId", applyId);
		JSONObject object = applyService.edit(paramMap);
		String json=object.toString();
		return json;
	}
	
	/**
	 * 应用查看
	 */
	@RequestMapping(value="/apply/details/{applyId}", method = RequestMethod.GET)
	public String apply_details(ModelMap map, @PathVariable("applyId") String applyId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("applyId", applyId);
		JSONObject object = applyService.list(paramMap);
		JSONObject allobject = applyService.list(new HashMap<String, Object>());
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/apply/apply_details";
	}
}