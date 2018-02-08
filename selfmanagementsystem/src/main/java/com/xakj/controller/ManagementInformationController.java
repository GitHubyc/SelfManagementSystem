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
import com.xakj.service.UnitBuildService;
import com.xakj.service.UnitInfoService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;
import com.xiaoleilu.hutool.http.HttpStatus;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class ManagementInformationController {

	@Autowired
	private UnitInfoService unitInfoService;
	@Autowired
	private UnitBuildService unitBuildService;

	/**
	 * 管理处信息列表
	 */
	@RequestMapping(value="/managementinformation/list")
	public String ManagementInformation_list(ModelMap map,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		Session session = SecurityUtils.getSubject().getSession();
		User user=  (User) session.getAttribute(Constant.USER);
		String xzqhCode=user.getXzqhCode();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("xzqhCode", xzqhCode==null?"":xzqhCode);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject object = unitInfoService.getInfo(paramMap);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);
		return "ManagementInformations/ManagementInformation_list";
	}

	/**
	 * 跳转管理处信息新增页面
	 */
	@RequestMapping(value="/managementinformation/add")
	public String ManagementInformation_addpage(ModelMap map) {
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		return "ManagementInformations/ManagementInformation_add";
	}


	@RequestMapping(value="/managementinformation/add",method=RequestMethod.POST)
	@ResponseBody
	public String ManagementInformation_add(ModelMap map,@RequestBody String requestbody) {
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();// 用于传入单位建筑接口的Map
			JSONObject paramMap = JSONObject.fromObject(requestbody);
			JSONObject unitInfoDto = JSONObject.fromObject(paramMap.get("unitInfoDto").toString());
			JSONObject postdata = new JSONObject();
			postdata.put("unitInfoDto", unitInfoDto);
			RightUtil ru = new RightUtil();
			map.addAttribute("menu", ru.menu());
			map.addAttribute("right", ru.right());
			JSONObject object = unitInfoService.addProperty(HttpClientUtil.toMap(paramMap.toString()));			
			return object.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 管理处信息删除
	 */
	@RequestMapping(value="/managementinformation/del/{unitCode}", method = RequestMethod.DELETE)
	@ResponseBody
	public String ManagementInformation_del(@PathVariable("unitCode") String unitCode) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		JSONObject object = unitInfoService.delProperty(paramMap);
		String json = object.toString();
		return json;
	}


	/**
	 * 跳转管理处信息更新页面
	 */
	@RequestMapping(value="/managementinformation/edit")
	public String ManagementInformation_editpage(ModelMap map,@RequestParam(value = "unitCode") String unitCode) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		JSONObject object = unitInfoService.findproperty(paramMap);
		JSONObject result = (JSONObject) JSONObject.fromObject(object).get("data");
		JSONObject UnitInfoDto = JSONObject.fromObject(result.get("UnitInfoDto"));
		JSONObject propertyManagementOfficeDto = JSONObject.fromObject(result.get("propertyManagementOfficeDto"));
		JSONObject propertyServeDto = JSONObject.fromObject(result.get("propertyServeDto"));
		map.addAttribute("UnitInfoDto", UnitInfoDto);
		map.addAttribute("propertyManagementOfficeDto", propertyManagementOfficeDto);
		map.addAttribute("propertyServeDto", propertyServeDto);
		map.addAttribute("object", unitBuildService.set(paramMap));
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		return "ManagementInformations/ManagementInformation_edit";
	}

	/**
	 * 管理处信息更新
	 */
	@RequestMapping(value="/managementinformation/edit/{unitCode}",method=RequestMethod.PUT)
	@ResponseBody
	public String ManagementInformation_edit(@RequestBody String requestbody,@PathVariable("unitCode") String unitCode) {
		try {
			JSONObject paramMap = JSONObject.fromObject(requestbody);
			paramMap.put("unitCode", unitCode);
			JSONObject object = unitInfoService.updateProperty(HttpClientUtil.toMap(paramMap.toString()));		
			return object.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




	/**
	 * 管理处信息详情
	 */
	@RequestMapping(value="/managementinformation/details")
	public String ManagementInformation_details(ModelMap map,@RequestParam(value = "unitCode") String unitCode) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		JSONObject object = unitInfoService.findproperty(paramMap);
		JSONObject result = (JSONObject) JSONObject.fromObject(object).get("data");
		JSONObject UnitInfoDto = JSONObject.fromObject(result.get("UnitInfoDto"));
		JSONObject propertyManagementOfficeDto = JSONObject.fromObject(result.get("propertyManagementOfficeDto"));
		JSONObject propertyServeDto = JSONObject.fromObject(result.get("propertyServeDto"));
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("UnitInfoDto", UnitInfoDto);
		map.addAttribute("propertyManagementOfficeDto", propertyManagementOfficeDto);
		map.addAttribute("propertyServeDto", propertyServeDto);
		return "ManagementInformations/ManagementInformation_details";
	}

}