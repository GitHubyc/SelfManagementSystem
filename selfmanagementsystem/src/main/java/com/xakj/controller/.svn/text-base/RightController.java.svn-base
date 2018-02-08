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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.service.ApplyService;
import com.xakj.service.RightService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class RightController {

	@Autowired
	private RightService rightService;
	@Autowired
	private ApplyService applyService;

	/**
	 * 权限列表
	 */
	@RequestMapping(value="/right/list", method = RequestMethod.GET)
	public String Right_list(ModelMap map) {
		JSONObject object = rightService.list(null);	//所有权限
		HashMap<String, Object> paramMap1 = new HashMap<String, Object>();	
		paramMap1.put("parentId", "0");
		JSONObject appObject = rightService.list(paramMap1);	//所有最高权限，如消防应用
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("appObject", appObject);
		map.addAttribute("object", object);
		return "Users/Right/Right_list";
	}
	
	/**
	 * 权限新增
	 */
	@RequestMapping(value="/right/add", method = RequestMethod.GET)
	public String to_right_add(
			ModelMap map,
			@RequestParam(value = "rightId", defaultValue = "", required = false) String rightId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rightId", rightId);
		JSONObject object = rightService.list(paramMap);
		if(rightId.equals("0")){
			object.put("data", "");
		}
		JSONObject allobject = rightService.list(new HashMap<String, Object>());
		JSONObject applys = applyService.list(new HashMap<String, Object>());
		map.addAttribute("applys", applys);
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/Right/Right_add";
	}
	
	@RequestMapping(value = "/right/add", method = RequestMethod.POST)
	@ResponseBody
	public String Right_add(@RequestBody String body) {
		HashMap<String, Object> paramMap =HttpClientUtil.toMap(body);
		HashMap<String, Object> rightDto = new HashMap<String, Object>();
		HashMap<String, Object> menuDto = new HashMap<String, Object>();
		HashMap<String, Object> operateDto = new HashMap<String, Object>();
		rightDto.put("applyId", paramMap.get("applyId"));
		rightDto.put("parentId", paramMap.get("parentId"));
		rightDto.put("rightType", paramMap.get("rightType"));
		if(paramMap.get("rightType").equals("2")){
			operateDto.put("operateType", paramMap.get("operateType"));
			operateDto.put("operateName", paramMap.get("operateName"));
			operateDto.put("operateUrl", paramMap.get("operateUrl"));
			operateDto.put("operateDescribe", paramMap.get("operateDescribe"));
			paramMap =  new HashMap<String, Object>();
			paramMap.put("operateDto", operateDto);
		}else{
			menuDto.put("meunDescribe", paramMap.get("meunDescribe"));
			menuDto.put("menuSort", paramMap.get("menuSort"));
			menuDto.put("menuUrl", paramMap.get("menuUrl"));
			menuDto.put("menuName", paramMap.get("menuName"));
			menuDto.put("meunIcon", paramMap.get("meunIcon"));
			paramMap =  new HashMap<String, Object>();
			paramMap.put("menuDto", menuDto);
		}
		paramMap.put("rightDto", rightDto);
		JSONObject object = rightService.add(paramMap);
		String json=object.toString();
		return json;
	}
	
	/**
	 * 权限删除
	 */
	@RequestMapping(value="/right/del", method = RequestMethod.DELETE)
	@ResponseBody
	public String right_del(
			@RequestParam(value = "rightId", defaultValue = "", required = false) String rightId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rightId",rightId);
		JSONObject object = rightService.del(paramMap);
		String json = object.toString();
		return json;
	}
	
	/**
	 * 权限更新
	 */
	@RequestMapping(value="/right/edit", method = RequestMethod.GET)
	public String Right_edit(
			ModelMap map, 
			@RequestParam(value = "rightId", defaultValue = "", required = false) String rightId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rightId", rightId);
		JSONObject object = rightService.list(paramMap);
		JSONObject allobject = rightService.list(new HashMap<String, Object>());
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/Right/Right_edit";
	}

	@RequestMapping(value = "/right/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String Right_edit(@RequestBody String body) {
		HashMap<String, Object> paramMap =HttpClientUtil.toMap(body);
		HashMap<String, Object> rightDto = new HashMap<String, Object>();
		HashMap<String, Object> menuDto = new HashMap<String, Object>();
		HashMap<String, Object> operateDto = new HashMap<String, Object>();
		rightDto.put("applyId", paramMap.get("applyId"));
		rightDto.put("parentId", paramMap.get("parentId"));
		rightDto.put("rightType", paramMap.get("rightType"));
		String rightId = (String) paramMap.get("rightId");
		if(paramMap.get("rightType").equals("2")){
			operateDto.put("operateType", paramMap.get("operateType"));
			operateDto.put("operateName", paramMap.get("operateName"));
			operateDto.put("operateUrl", paramMap.get("operateUrl"));
			operateDto.put("operateDescribe", paramMap.get("operateDescribe"));
			paramMap =  new HashMap<String, Object>();
			paramMap.put("operateDto", operateDto);
		}else if(paramMap.get("rightType").equals("1")){
			menuDto.put("meunDescribe", paramMap.get("meunDescribe"));
			menuDto.put("menuSort", paramMap.get("menuSort"));
			menuDto.put("menuUrl", paramMap.get("menuUrl"));
			menuDto.put("menuName", paramMap.get("menuName"));
			menuDto.put("meunIcon", paramMap.get("meunIcon"));
			paramMap =  new HashMap<String, Object>();
			paramMap.put("menuDto", menuDto);
		}
		paramMap.put("rightDto", rightDto);
		paramMap.put("rightId", rightId);
		JSONObject object = rightService.edit(paramMap);
		String json=object.toString();
		return json;
	}
	
	/**
	 * 权限查看
	 */
	@RequestMapping(value="/right/details", method = RequestMethod.GET)
	public String Right_details(
			ModelMap map, 
			@RequestParam(value = "rightId", defaultValue = "", required = false) String rightId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rightId", rightId);
		JSONObject object = rightService.list(paramMap);
		JSONObject allobject = rightService.list(new HashMap<String, Object>());
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/Right/Right_details";
	}
}