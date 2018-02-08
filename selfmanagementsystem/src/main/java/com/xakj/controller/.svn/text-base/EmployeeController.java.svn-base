package com.xakj.controller;

import java.util.HashMap;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.constant.Constant;
import com.xakj.model.dto.User;
import com.xakj.service.UnitDepartmentService;
import com.xakj.service.UnitEmployeeService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class EmployeeController {

	@Autowired
	private UnitEmployeeService unitEmployeeService;
	@Autowired
	private UnitDepartmentService unitDepartmentService;

	/**
	 * 单位人员列表
	 */
	@RequestMapping(value = "/employee/list", method = RequestMethod.GET)
	public String UnitEmployee_list(
			ModelMap map,
			@RequestParam(value = "xzqhCode", defaultValue = "", required = false) String xzqhCode,
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode,
			@RequestParam(value = "display",defaultValue ="1") String display,
			@RequestParam(value = "type", defaultValue = "0") String type,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize,
			@RequestParam(value = "employeeCode", defaultValue = "", required = false) String employeeCode,
			@RequestParam(value = "contactNumber", defaultValue = "", required = false) String contactNumber,
			@RequestParam(value = "name", defaultValue = "", required = false) String name) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		JSONObject departmentobject = unitDepartmentService.list( user.getUnitCode(),
				paramMap);
		paramMap.put("xzqhCode", xzqhCode);
		paramMap.put("unitCode", user.getUnitCode());
		paramMap.put("type", type);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		paramMap.put("employeeCode", employeeCode);
		paramMap.put("contactNumber", contactNumber);
		paramMap.put("name", name);
		JSONObject object = unitEmployeeService.list(paramMap);
		map.addAttribute("object", object);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.put("display", display);
		map.put("departmentobject", departmentobject);
		map.addAttribute("paramMap", paramMap);
		return "Employees/Employee_list";
	}

	/**
	 * 人员新增
	 */
	@RequestMapping(value = "/employee/add", method = RequestMethod.GET)
	public String UnitEmployee_toadd(
			ModelMap map,
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode,
			@RequestParam(value = "type", defaultValue = "0") String type) {
		JSONObject departmentobject = unitDepartmentService.list(unitCode,
				new HashMap<String, Object>());
		map.addAttribute("unitCode", unitCode);
		map.addAttribute("type", type);
		map.addAttribute("departmentobject", departmentobject);
		return "Employees/Employee_add";
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	@ResponseBody
	public String UnitEmployee_add(@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		String documentType = paramMap.get("documentType").toString();
		if (documentType.equals("1")) {
			paramMap.put("documentNo", paramMap.get("documentNo1"));
		} else if (documentType.equals("2")) {
			paramMap.put("documentNo", paramMap.get("documentNo2"));
		} else {
			paramMap.put("documentNo", paramMap.get("documentNo3"));
		}
		paramMap.remove("documentNo1");
		paramMap.remove("documentNo2");
		paramMap.remove("documentNo3");
		JSONObject object = unitEmployeeService.add(paramMap);
		String json = object.toString();
		return json;
	}

	/**
	 * 单位人员更新
	 */
	@RequestMapping(value = "/edit/{unitCode}/unitDepartment/{departmentCode}/unitEmployee/{employeeCode}", method = RequestMethod.GET)
	public String UnitEmployee_edit(
			ModelMap map,
			@PathVariable(value = "unitCode") String unitCode,
			@PathVariable(value = "departmentCode") String departmentCode,
			@PathVariable(value = "employeeCode") String employeeCode,
			@RequestParam(value = "type", defaultValue = "", required = false) String type) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		paramMap.put("departmentCode", departmentCode);
		paramMap.put("employeeCode", employeeCode);
		JSONObject object = unitEmployeeService.list(paramMap);
		JSONObject departmentobject = unitDepartmentService.list(unitCode, new HashMap<String, Object>());
		map.addAttribute("unitCode", unitCode);
		map.addAttribute("departmentobject", departmentobject);
		map.addAttribute("type", type);
		map.addAttribute("object", object);
		return "Employees/Employee_edit";
	}

	@RequestMapping(value = "/employee/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String UnitEmployee_edit(@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = unitEmployeeService.edit(paramMap);
		String json = object.toString();
		return json;
	}

	/**
	 * 单位人员详情
	 */
	@RequestMapping(value = "/unit/{unitCode}/unitDepartment/{departmentCode}/Employee/{employeeCode}", method = RequestMethod.GET)
	public String Employee_details(ModelMap map,
			@PathVariable(value = "unitCode") String unitCode,
			@PathVariable(value = "departmentCode") String departmentCode,
			@PathVariable(value = "employeeCode") String employeeCode) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		paramMap.put("departmentCode", departmentCode);
		paramMap.put("employeeCode", employeeCode);
		JSONObject object = unitEmployeeService.list(paramMap);
		JSONObject departmentobject = unitDepartmentService.list(unitCode, new HashMap<String, Object>());
		map.addAttribute("departmentobject", departmentobject);
		map.addAttribute("object", object);
		return "Employees/Employee_details";
	}
}