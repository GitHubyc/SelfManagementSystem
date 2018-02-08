package com.xakj.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xakj.service.UnitEmployeeService;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 * 重点人员
 */
@Controller
public class ArchivesKeyPersonnelController {
	@Autowired
	private UnitEmployeeService unitEmployeeService;

	/**
	 * 单位人员列表
	 */
	@RequestMapping(value = "/keyPersonnel/list", method = RequestMethod.GET)
	public String KeyPersonnel_list(       
			ModelMap map,
			@RequestParam(value = "xzqhCode", defaultValue = "", required = false) String xzqhCode,
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode,
			@RequestParam(value = "type", defaultValue = "", required = false) String type,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize,
			@RequestParam(value = "employeeCode", defaultValue = "", required = false) String employeeCode,
			@RequestParam(value = "contactNumber", defaultValue = "", required = false) String contactNumber,
			@RequestParam(value = "name", defaultValue = "", required = false) String name) {			
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("xzqhCode", xzqhCode);
			paramMap.put("unitCode", unitCode);
			if( "".equals(type) || type == null || "null".equals(type) || "0".equals(type)){
				type = null;
			}
			paramMap.put("type", type);
			paramMap.put("currentPage", currentPage);
			paramMap.put("pageSize", pageSize);
			paramMap.put("employeeCode", employeeCode);
			paramMap.put("contactNumber", contactNumber);
			paramMap.put("name", name);
			JSONObject object = unitEmployeeService.list(paramMap);
			if(type == null){
				paramMap.remove("type");
				paramMap.put("type", "0");
			}
			map.addAttribute("object", object);
			map.addAttribute("paramMap", paramMap);
			map.addAttribute("unitCode", unitCode);
			return "Archives/KeyPersonnel/KeyPersonnel_list";
	}
}