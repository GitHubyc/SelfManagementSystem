package com.xakj.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.service.UnitDepartmentService;
import com.xakj.service.UnitEmployeeService;
import com.xakj.service.UnitInfoService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class UnitEmployeeController {
	@Autowired
	private UnitInfoService unitInfoService;
	@Autowired
	private UnitEmployeeService unitEmployeeService;
	@Autowired
	private UnitDepartmentService unitDepartmentService;

	/**
	 * 单位部门人员列表
	 */
	@RequestMapping(value = "/unitEmployee/list", method = RequestMethod.GET)
	public String UnitEmployee_list(
			ModelMap map,
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode,
			@RequestParam(value = "departmentCode", defaultValue = "", required = false) String departmentCode,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		//单位部门树
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		JSONObject unitDepartment = unitInfoService.list(paramMap);	//得到单位数据并对其字段进行封装，便于前台生成
		JSONArray unitArray =   new JSONArray();
		if (unitDepartment.get("data") != null && !(unitDepartment.get("data")).equals("null")) { // 判断得到的数据是否为空
			unitArray = (JSONArray) unitDepartment.get("data");
		}
		JSONArray data = new JSONArray();
		for (int i = 0; i < unitArray.size(); i++) {
			String id = ((JSONObject) unitArray.get(i)).get("unitCode").toString();
			String pid = id;
			String unitName = ((JSONObject) unitArray.get(i)).get("unitName").toString();
			JSONObject unitone = (JSONObject) unitArray.get(i);
			unitone.put("id", id);
			unitone.put("pId", pid);
			unitone.put("name", unitName);
			unitone.put("isParent", true);
			unitone.put("open", true);
			data.add(unitone);
		}
		JSONObject departmentobject = unitDepartmentService.list(unitCode, paramMap); 	//得到单位下所有部门数据并对其字段进行封装，便于前台生成
		JSONArray a =  new JSONArray();
		if (departmentobject.get("data") != null && !(departmentobject.get("data")).equals("null")) { // 判断得到的数据是否为空
			a = (JSONArray) departmentobject.get("data");
		}
		JSONObject departments = new JSONObject();
		departments.put("status", departmentobject.get("status"));
		departments.put("msg", departmentobject.get("msg"));
		for (int i = 0; i < a.size(); i++) {
			String id = ((JSONObject) a.get(i)).get("departmentCode").toString();
			String pid = ((JSONObject) a.get(i)).get("unitCode").toString();
			String departmentName = ((JSONObject) a.get(i)).get("departmentName").toString();
			JSONObject b = (JSONObject) a.get(i);
			b.put("id", id);
			b.put("pId", pid);
			b.put("name", departmentName);
			b.put("isParent", false);
			data.add(b);
		}
		departments.put("data", data);
		//人员的数据
		paramMap.put("departmentCode", departmentCode);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		if(departmentCode.equals("0") || departmentCode.equals("")){	//部门编号为空时，返回所有人员
			JSONObject object = unitEmployeeService.list(paramMap);
			departmentCode = "0";
			map.addAttribute("object", object);
		}else{							//部门编号不为空时，返回部门人员
			paramMap.put("departmentCode", departmentCode);
			JSONObject object = unitEmployeeService.department_list(paramMap);
			map.addAttribute("object", object);
		}
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("unitCode", unitCode);
		map.addAttribute("departmentCode", departmentCode);
		map.addAttribute("departmentobject", departments);
		return "UnitInfos/UnitEmployees/UnitEmployee_list";
	}
	
	/**
	 * 单位部门人员列表
	 */
	@RequestMapping(value = "/unitEmployee/listdetails", method = RequestMethod.GET)
	public String UnitEmployee_listdetails(
			ModelMap map,
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode,
			@RequestParam(value = "departmentCode", defaultValue = "", required = false) String departmentCode,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		//单位部门树
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		JSONObject unitDepartment = unitInfoService.list(paramMap);	//得到单位数据并对其字段进行封装，便于前台生成
		JSONArray unitArray =   new JSONArray();
		if (unitDepartment.get("data") != null && !(unitDepartment.get("data")).equals("null")) { // 判断得到的数据是否为空
			unitArray = (JSONArray) unitDepartment.get("data");
		}
		JSONArray data = new JSONArray();
		for (int i = 0; i < unitArray.size(); i++) {
			String id = ((JSONObject) unitArray.get(i)).get("unitCode").toString();
			String pid = id;
			String unitName = ((JSONObject) unitArray.get(i)).get("unitName").toString();
			JSONObject unitone = (JSONObject) unitArray.get(i);
			unitone.put("id", id);
			unitone.put("pId", pid);
			unitone.put("name", unitName);
			unitone.put("isParent", true);
			unitone.put("open", true);
			data.add(unitone);
		}
		JSONObject departmentobject = unitDepartmentService.list(unitCode, paramMap); 	//得到单位下所有部门数据并对其字段进行封装，便于前台生成
		JSONArray a =  new JSONArray();
		if (departmentobject.get("data") != null && !(departmentobject.get("data")).equals("null")) { // 判断得到的数据是否为空
			a = (JSONArray) departmentobject.get("data");
		}
		JSONObject departments = new JSONObject();
		departments.put("status", departmentobject.get("status"));
		departments.put("msg", departmentobject.get("msg"));
		for (int i = 0; i < a.size(); i++) {
			String id = ((JSONObject) a.get(i)).get("departmentCode").toString();
			String pid = ((JSONObject) a.get(i)).get("unitCode").toString();
			String departmentName = ((JSONObject) a.get(i)).get("departmentName").toString();
			JSONObject b = (JSONObject) a.get(i);
			b.put("id", id);
			b.put("pId", pid);
			b.put("name", departmentName);
			b.put("isParent", false);
			data.add(b);
		}
		departments.put("data", data);
		//人员的数据
		paramMap.put("departmentCode", departmentCode);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		if(departmentCode.equals("0") || departmentCode.equals("")){	//部门编号为空时，返回所有人员
			JSONObject object = unitEmployeeService.list(paramMap);
			departmentCode = "0";
			map.addAttribute("object", object);
		}else{							//部门编号不为空时，返回部门人员
			paramMap.put("departmentCode", departmentCode);
			JSONObject object = unitEmployeeService.department_list(paramMap);
			map.addAttribute("object", object);
		}
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("unitCode", unitCode);
		map.addAttribute("departmentCode", departmentCode);
		map.addAttribute("departmentobject", departments);
		return "UnitInfos/UnitEmployees/UnitEmployee_listDetails";
	}
	
	

	/**
	 * 单位人员新增
	 */
	@RequestMapping(value = "/unitEmployee/add", method = RequestMethod.GET)
	public String UnitEmployee_toadd(ModelMap map,
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode,
			@RequestParam(value = "departmentCode", defaultValue = "", required = false) String departmentCode) {
		map.addAttribute("unitCode", unitCode);
		map.addAttribute("departmentCode", departmentCode);
		return "UnitInfos/UnitEmployees/UnitEmployee_add";
	}
	
	@RequestMapping(value = "/unitEmployee/add", method = RequestMethod.POST)
	@ResponseBody
	public String UnitEmployee_add(@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		String documentType = paramMap.get("documentType").toString();
		if(documentType.equals("1")){
			paramMap.put("documentNo", paramMap.get("documentNo1"));
		}else if(documentType.equals("2")){
			paramMap.put("documentNo", paramMap.get("documentNo2"));
		}else{
			paramMap.put("documentNo", paramMap.get("documentNo3"));
		}
		paramMap.remove("documentNo1");
		paramMap.remove("documentNo2");
		paramMap.remove("documentNo3");
		
		paramMap.put("unitCode", paramMap.get("unitCode"));
		paramMap.put("departmentCode", paramMap.get("departmentCode"));
		JSONObject object = unitEmployeeService.add(paramMap);
		String json = object.toString();
		return json;
	}
	
	/**
	 * 单位人员删除
	 */
	@RequestMapping(value = "/unitEmployee/del", method = RequestMethod.DELETE)
	@ResponseBody
	public String UnitEmployee_del(
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode,
			@RequestParam(value = "departmentCode", defaultValue = "", required = false) String departmentCode,
			@RequestParam(value = "employeeCode", defaultValue = "", required = false) String employeeCode
			) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		paramMap.put("departmentCode", departmentCode);
		paramMap.put("employeeCode", employeeCode);
		JSONObject object = unitEmployeeService.del(paramMap);
		String json = object.toString();
		return json;
	}

	/**
	 * 单位人员更新
	 */
	@RequestMapping(value = "/unitEmployee/edit", method = RequestMethod.GET)
	public String UnitEmployee_edit(
			ModelMap map,
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode,
			@RequestParam(value = "departmentCode", defaultValue = "", required = false) String departmentCode,
			@RequestParam(value = "employeeCode", defaultValue = "", required = false) String employeeCode) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);//5cb1588a123945788bfb95bfd5107ccb
		paramMap.put("departmentCode", departmentCode);//026c263be5fe4c4cab499797f61bba3a
		paramMap.put("employeeCode", employeeCode);//8fd0f179ae5f4540ac3bc7d297dbfd82
		JSONObject object = unitEmployeeService.details(paramMap);
		//字符串转jsonArray
		Object a = object.get("data");
		String b = "[" + a.toString() + "]";
		JSONArray json = JSONArray.fromObject(b); // 首先把字符串转成 JSONArray  对象
		if(json.size()>0){
			for(int i=0;i<json.size();i++){
				JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
			}
		}
		object.remove("data");
		object.put("data", json);
		map.addAttribute("object", object);
		return "UnitInfos/UnitEmployees/UnitEmployee_edit";
	}
	
	@RequestMapping(value = "/unitEmployee/edit", method = RequestMethod.PUT)
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
	@RequestMapping(value = "/unitEmployee/details", method = RequestMethod.GET)
	public String UnitEmployee_details(
			ModelMap map,
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode,
			@RequestParam(value = "departmentCode", defaultValue = "", required = false) String departmentCode,
			@RequestParam(value = "employeeCode", defaultValue = "", required = false) String employeeCode) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);//5cb1588a123945788bfb95bfd5107ccb
		paramMap.put("departmentCode", departmentCode);//026c263be5fe4c4cab499797f61bba3a
		paramMap.put("employeeCode", employeeCode);//8fd0f179ae5f4540ac3bc7d297dbfd82
		JSONObject object = unitEmployeeService.details(paramMap);
		//字符串转jsonArray
		Object a = object.get("data");
		String b = "[" + a.toString() + "]";
		JSONArray json = JSONArray.fromObject(b); // 首先把字符串转成 JSONArray  对象
		if(json.size()>0){
		  for(int i=0;i<json.size();i++){
		    JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
		  }
		}
		object.remove("data");
		object.put("data", json);
		map.addAttribute("object", object);
		return "UnitInfos/UnitEmployees/UnitEmployee_details";
	}
	
	/**
	 * 单位部门删除
	 */
	@RequestMapping(value = "/unitDepartment/del", method = RequestMethod.DELETE)
	@ResponseBody
	public String unitDepartment_del(
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode,
			@RequestParam(value = "departmentCode", defaultValue = "", required = false) String departmentCode
			) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);//5cb1588a123945788bfb95bfd5107ccb
		paramMap.put("departmentCode", departmentCode);//026c263be5fe4c4cab499797f61bba3a
		JSONObject object = unitDepartmentService.del(unitCode, departmentCode);
		String json = object.toString();
		return json;
	}
	
//	/**
//	 * 单位部门新增
//	 */
//	@RequestMapping(value = "/unitDepartment/add", method = RequestMethod.GET)
//	public String Department_toadd(
//			ModelMap map,
//			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode) {
//		map.addAttribute("unitCode", unitCode);
//		return "UnitInfos/UnitEmployees/UnitDepartment_add";
//	}
	
	@RequestMapping(value = "/unitDepartment/add", method = RequestMethod.POST)
	@ResponseBody
	public String Department_add(
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		String unitCode = paramMap.get("unitCode").toString();
		paramMap.remove("unitCode");
		JSONObject object = unitDepartmentService.add(unitCode,paramMap);
		String json = object.toString();
		return json;
	}
	
	/**
	 * 单位部门修改
	 */
	@RequestMapping(value = "/unitDepartment/edit", method = RequestMethod.GET)
	@ResponseBody
	public String Department_toedit(
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode,
			@RequestParam(value = "departmentCode", defaultValue = "", required = false) String departmentCode) {
		JSONObject object = unitDepartmentService.findOne(unitCode, departmentCode);
		return object.toString();
	}
	
	@RequestMapping(value = "/unitDepartment/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String Department_edit(@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		String unitCode = paramMap.get("unitCode").toString();
		String departmentCode = paramMap.get("departmentCode").toString();
		paramMap.remove("unitCode");
		paramMap.remove("departmentCode");
		JSONObject object = unitDepartmentService.edit(unitCode, departmentCode, paramMap);
		String json = object.toString();
		return json;
	}
}