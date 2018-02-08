package com.xakj.controller;

import java.util.HashMap;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.constant.Constant;
import com.xakj.model.dto.User;
import com.xakj.service.LoginService;
import com.xakj.service.UnitBuildService;
import com.xakj.service.UnitInfoService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;
import com.xiaoleilu.hutool.http.HttpStatus;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class UnitInfoController {
	@Autowired
	private UnitInfoService unitInfoService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private UnitBuildService unitBuildService;

	/**
	 * 其他系统访问单位信息
	 */
	@RequestMapping(value = "/unitDetailInfo")
	public String entityResponsibility(ModelMap map,
			@RequestParam(value = "authorization", required = true) String authorization,
			@RequestParam(value = "unitCode", required = true) String unitCode,
			@RequestParam(value = "unitNature", required = true) Integer unitNature) {
		if (!StringUtils.isEmpty(authorization)) {
			try {
				// 校验令牌可用性
				JSONObject authobject = loginService.checkToken(authorization);
				Integer status = authobject.getInt("status");
				if (status != 200) {
					return "login";// 暂未授权
				} else {
					if (unitNature == 1) {// 行政单位
						HashMap<String, Object> paramMap = new HashMap<String, Object>();
						paramMap.put("unitCode", unitCode);
						JSONObject object = unitInfoService.findadmin(paramMap);
						JSONObject result = (JSONObject) JSONObject.fromObject(object).get("data");
						JSONObject UnitInfoDto = JSONObject.fromObject(result.get("UnitInfoDto"));
						JSONObject AdministrativeJurisdictionDto = JSONObject
								.fromObject(result.get("AdministrativeJurisdictionDto"));
						JSONObject AdministrativeUnitDto = JSONObject.fromObject(result.get("AdministrativeUnitDto"));

						map.addAttribute("UnitInfoDto", UnitInfoDto);
						map.addAttribute("AdministrativeJurisdictionDto", AdministrativeJurisdictionDto);
						map.addAttribute("AdministrativeUnitDto", AdministrativeUnitDto);
						return "UnitInfos/Administrative/Administrative_details";
					} else if (unitNature == 2) {// 事业单位
						HashMap<String, Object> paramMap = new HashMap<String, Object>();
						paramMap.put("unitCode", unitCode);
						JSONObject object = unitInfoService.findcause(paramMap);
						JSONObject result = (JSONObject) JSONObject.fromObject(object).get("data");
						JSONObject CauseUnitDto = JSONObject.fromObject(result.get("CauseUnitDto"));
						JSONObject UnitInfoDto = JSONObject.fromObject(result.get("UnitInfoDto"));
						map.addAttribute("CauseUnitDto", CauseUnitDto);
						map.addAttribute("UnitInfoDto", UnitInfoDto);
						return "UnitInfos/Institution/Institution_details";
					} else if (unitNature == 3) {// 企业单位
						HashMap<String, Object> paramMap = new HashMap<String, Object>();
						paramMap.put("unitCode", unitCode);
						JSONObject object = unitInfoService.findenter(paramMap);
						JSONObject result = (JSONObject) JSONObject.fromObject(object).get("data");
						JSONObject UnitInfoDto = JSONObject.fromObject(result.get("UnitInfoDto"));
						JSONObject enterpriseSubjectDutyDto = JSONObject
								.fromObject(result.get("enterpriseSubjectDutyDto"));
						JSONObject enterpriseUnitDto = JSONObject.fromObject(result.get("enterpriseUnitDto"));

						map.addAttribute("UnitInfoDto", UnitInfoDto);
						map.addAttribute("enterpriseSubjectDutyDto", enterpriseSubjectDutyDto);
						map.addAttribute("enterpriseUnitDto", enterpriseUnitDto);
						return "UnitInfos/EnterpriseUnit/EnterpriseUnit_details";
					} else {// 物业管理处
						HashMap<String, Object> paramMap = new HashMap<String, Object>();
						paramMap.put("unitCode", unitCode);
						JSONObject object = unitInfoService.findproperty(paramMap);
						JSONObject result = (JSONObject) JSONObject.fromObject(object).get("data");
						JSONObject UnitInfoDto = JSONObject.fromObject(result.get("UnitInfoDto"));
						JSONObject propertyManagementOfficeDto = JSONObject
								.fromObject(result.get("propertyManagementOfficeDto"));
						JSONObject propertyServeDto = JSONObject.fromObject(result.get("propertyServeDto"));
						map.addAttribute("UnitInfoDto", UnitInfoDto);
						map.addAttribute("propertyManagementOfficeDto", propertyManagementOfficeDto);
						map.addAttribute("propertyServeDto", propertyServeDto);
						return "UnitInfos/PropertyManagementOffice/PropertyManagementOffice_details";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "login";
			}
		} else {
			return "login";
		}
	}

	/**
	 * 单位列表
	 */
	@RequestMapping(value = "/unit/list")
	public String UnitInfo_list(ModelMap map,
			@RequestParam(value = "unitNature", defaultValue = "", required = false) String unitNature,
			@RequestParam(value = "display", defaultValue = "1") String display,
			@RequestParam(value = "unitType", defaultValue = "", required = false) Integer unitType,
			@RequestParam(value = "subordinateUnit", defaultValue = "", required = false) String subordinateUnit,
			@RequestParam(value = "xzqhCode", defaultValue = "", required = false) String xzqhCode,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode",user.getUnitCode());
		JSONObject result = unitBuildService.set(paramMap);
		String buildCode=null;
		if(!(result.getString("data").equals("null"))){
			JSONArray array=JSONArray.fromObject(result.getString("data"));
			buildCode=array.getJSONObject(0).getString("buildCode");
		}
		paramMap.remove("unitCode");
		paramMap.put("unitNature", unitNature);
		paramMap.put("unitType", unitType);
		paramMap.put("subordinateUnit", subordinateUnit);
		paramMap.put("xzqhCode", xzqhCode);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		paramMap.put("buildCode", buildCode);
		JSONObject object = unitInfoService.list(paramMap);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);
		map.addAttribute("display", display);
		map.addAttribute("xzqhCode", xzqhCode);
		return "UnitInfos/Unit/UnitInfo_list";
	}

	
	/**
	 * 单位信息新增
	 */
	@RequestMapping(value = "/unit/add" , method = RequestMethod.GET)
	public String Unit_add(ModelMap map) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.put("unitCode", user.getUnitCode());
		return "UnitInfos/Unit/UnitInfo_add";
	}
	
	
	/**
	 * 新增单位
	 */
	@RequestMapping(value = "/unit/add", method = RequestMethod.POST)
	@ResponseBody
	public String Unit_add(@RequestBody String requestbody) {
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();// 用于传入单位建筑接口的Map
			JSONObject paramMap = JSONObject.fromObject(requestbody);
			JSONObject unitInfoDto = JSONObject.fromObject(paramMap.get("unitInfoDto").toString());
			JSONObject postdata = new JSONObject();
			postdata.put("unitInfoDto", unitInfoDto);
			String unitNature = unitInfoDto.getString("unitNature");// 单位性质
			param.put("buildCode", unitInfoDto.getString("buildCode"));// 建筑编号
			param.put("buildName", unitInfoDto.getString("buildName"));// 建筑名称
			if ("1".equals(unitNature)) {// 行政单位
				JSONObject object = unitInfoService.addadmin(HttpClientUtil.toMap(paramMap.toString()));			
				if (object.getInt("status") == HttpStatus.HTTP_OK){
					param.put("unitCode", object.getString("data"));
					unitBuildService.add(param);}
				return object.toString();
			} else if ("2".equals(unitNature)) {// 事业单位
				JSONObject object = unitInfoService.addCause(paramMap.toString());				
				if (object.getInt("status") == HttpStatus.HTTP_OK){
					param.put("unitCode", object.getString("data"));
					unitBuildService.add(param);}//关系表
				return object.toString();
			} else if ("3".equals(unitNature)) {// 企业单位
				JSONObject object = unitInfoService.addEnter(HttpClientUtil.toMap(paramMap.toString()));				
				if (object.getInt("status") == HttpStatus.HTTP_OK){
					param.put("unitCode", object.getString("data"));
					unitBuildService.add(param);}
				return object.toString();
			} else {// 物业管理处
				JSONObject object = unitInfoService.addProperty(HttpClientUtil.toMap(paramMap.toString()));			
				if (object.getInt("status") == HttpStatus.HTTP_OK){
					param.put("unitCode", object.getString("data"));
					unitBuildService.add(param);}
				return object.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 跳转单位信息更新
	 */
	@RequestMapping(value = "/unit/edit", method = RequestMethod.GET)
	public String UnitInfo_edit(ModelMap map, @RequestParam(value = "unitCode", required = false) String unitCode,
			@RequestParam(value = "unitNature", required = false) Integer unitNature) {
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("unitCode", unitCode);
		map.addAttribute("unitNature", unitNature);
		return "/UnitInfos/Unit/UnitInfo_edit";
	}

	/**
	 * 单位信息更新
	 */
	@RequestMapping(value = "/unit/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String UnitInfo_edit(@RequestBody String requestbody, @RequestParam("unitCode") String unitCode) {
		try {
			JSONObject paramMap = JSONObject.fromObject(requestbody);
			paramMap.put("unitCode", unitCode);
			JSONObject unitInfoDto = JSONObject.fromObject(paramMap.get("unitInfoDto").toString());
			/*
			 * JSONObject postdata = new JSONObject();
			 * postdata.put("unitInfoDto", unitInfoDto);
			 */ 
			String unitNature = unitInfoDto.getString("unitNature");// 单位性质	
			if ("1".equals(unitNature)) {// 行政单位
				JSONObject object = unitInfoService.updateadmin(HttpClientUtil.toMap(paramMap.toString()));			
				return object.toString();
			} else if ("2".equals(unitNature)) {// 事业单位
				JSONObject object = unitInfoService.updateCause(HttpClientUtil.toMap(paramMap.toString()));
				return object.toString();
			} else if ("3".equals(unitNature)) {// 企业单位
				JSONObject object = unitInfoService.updateEnter(HttpClientUtil.toMap(paramMap.toString()));			
				return object.toString();
			} else {// 物业管理处
				JSONObject object = unitInfoService.updateProperty(HttpClientUtil.toMap(paramMap.toString()));		
				return object.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 单位信息详情
	 */
	@RequestMapping(value = "/unit/details")
	public String UnitInfo_details(ModelMap map, 
			@RequestParam(value = "unitCode", required = false) String unitCode,
			@RequestParam(value = "unitNature", required = false) Integer unitNature
			) {
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("unitCode", unitCode);
		map.addAttribute("unitNature", unitNature);
		return "/UnitInfos/Unit/UnitInfo_details";
	}
	
	/**
	 * 单位信息页面
	 */
	@RequestMapping(value = "/unit/info")
	public String UnitInfo_editinfo(ModelMap map, 
			@RequestParam(value = "unitCode", required = false) String unitCode,
			@RequestParam(value = "unitNature", required = false) Integer unitNature) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		if (unitNature == 1) {
			JSONObject object = unitInfoService.findadmin(paramMap);
			JSONObject result = (JSONObject) JSONObject.fromObject(object).get("data");
			JSONObject UnitInfoDto = JSONObject.fromObject(result.get("UnitInfoDto"));
			JSONObject AdministrativeJurisdictionDto = JSONObject
					.fromObject(result.get("AdministrativeJurisdictionDto"));
			JSONObject AdministrativeUnitDto = JSONObject.fromObject(result.get("AdministrativeUnitDto"));

			map.addAttribute("UnitInfoDto", UnitInfoDto);
			map.addAttribute("AdministrativeJurisdictionDto", AdministrativeJurisdictionDto);
			map.addAttribute("AdministrativeUnitDto", AdministrativeUnitDto);
			map.addAttribute("object",unitBuildService.set(paramMap));
		}
		if (unitNature == 2) {
			JSONObject object = unitInfoService.findcause(paramMap);
			JSONObject result = (JSONObject) JSONObject.fromObject(object).get("data");
			JSONObject CauseUnitDto = JSONObject.fromObject(result.get("CauseUnitDto"));
			JSONObject UnitInfoDto = JSONObject.fromObject(result.get("UnitInfoDto"));
			map.addAttribute("CauseUnitDto", CauseUnitDto);
			map.addAttribute("UnitInfoDto", UnitInfoDto);
			map.addAttribute("object",unitBuildService.set(paramMap));
		}
		if (unitNature == 3) {
			JSONObject object = unitInfoService.findenter(paramMap);
			JSONObject result = (JSONObject) JSONObject.fromObject(object).get("data");
			JSONObject UnitInfoDto = JSONObject.fromObject(result.get("UnitInfoDto"));
			JSONObject enterpriseSubjectDutyDto = JSONObject.fromObject(result.get("enterpriseSubjectDutyDto"));
			JSONObject enterpriseUnitDto = JSONObject.fromObject(result.get("enterpriseUnitDto"));

			map.addAttribute("UnitInfoDto", UnitInfoDto);
			map.addAttribute("enterpriseSubjectDutyDto", enterpriseSubjectDutyDto);
			map.addAttribute("enterpriseUnitDto", enterpriseUnitDto);
			map.addAttribute("object",unitBuildService.set(paramMap));
		}
		if (unitNature == 4) {
			JSONObject object = unitInfoService.findproperty(paramMap);
			JSONObject result = (JSONObject) JSONObject.fromObject(object).get("data");
			JSONObject UnitInfoDto = JSONObject.fromObject(result.get("UnitInfoDto"));
			JSONObject propertyManagementOfficeDto = JSONObject.fromObject(result.get("propertyManagementOfficeDto"));
			JSONObject propertyServeDto = JSONObject.fromObject(result.get("propertyServeDto"));
			map.addAttribute("UnitInfoDto", UnitInfoDto);
			map.addAttribute("propertyManagementOfficeDto", propertyManagementOfficeDto);
			map.addAttribute("propertyServeDto", propertyServeDto);
			map.addAttribute("object","null");
		}
		map.addAttribute("unitCode", unitCode);
		map.addAttribute("unitNature", unitNature);		
		return "/UnitInfos/Unit/UnitInfo_info";
	}


	/**
	 * 删除单位
	 */
	@RequestMapping(value = "/unit/del", method = RequestMethod.DELETE)
	@ResponseBody
	public String Unit_del(@RequestParam(value = "unitCode") String unitCode,
			@RequestParam(value = "unitNature") String unitNature) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("unitCode", unitCode);
		//删除行政单位
		if("1".equals(unitNature)){
			JSONObject object = unitInfoService.deladmin(paramMap);
			String json = object.toString();
			return json;		
		}
		//删除事业单位
		if("2".equals(unitNature)){
			JSONObject object = unitInfoService.delCause(paramMap);
			String json = object.toString();
			return json;
		}
		//删除企业单位
		if("3".equals(unitNature)){
			JSONObject object = unitInfoService.delEnter(paramMap);
			String json = object.toString();
			return json;
		}
		//删除物业管理处
		if("4".equals(unitNature)){
			JSONObject object = unitInfoService.delProperty(paramMap);
			String json = object.toString();
			return json;
		}
		return null;
	}

	@RequestMapping(value = "/unit/build", method = RequestMethod.GET)
	public String Unit_build() {
		return "/UnitInfos/Unit/UnitInfo_build";
	}

}