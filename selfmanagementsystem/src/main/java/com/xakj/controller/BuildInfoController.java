package com.xakj.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.constant.Constant;
import com.xakj.model.dto.Role;
import com.xakj.model.dto.User;
import com.xakj.service.BuildInfoService;
import com.xakj.service.LoginService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class BuildInfoController {
	@Autowired
	private BuildInfoService buildInfoService;
	
	@Autowired
	private LoginService loginService;
	


	/**
	 * 其他系统访问建筑档案盒
	 */
	@RequestMapping(value = "/entityResponsibility")
	public String entityResponsibility(
			ModelMap map,
			@RequestParam(value = "authorization", required = true) String authorization,
			@RequestParam(value = "buildCode", required = true) String buildCode) {
		if (!StringUtils.isEmpty(authorization)) {
			try {
				// 校验令牌可用性
				JSONObject object = loginService.checkToken(authorization);
				Integer status = object.getInt("status");
				if (status != 200) {
					return "login";// 暂未授权
				} else {
					map.addAttribute("buildCode", buildCode);
					return "/Archives/EntityResponsibility/EntityResponsibility_list";
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
	 * 获取建筑信息列表
	 */
	@RequestMapping(value = "/build/list")
	public String BuildInfo_list(
			ModelMap map,
			@RequestParam(value = "xzqhCode", defaultValue = "", required = false) String xzqhCode,
			@RequestParam(value = "display",defaultValue ="1") String display,
			@RequestParam(value = "fireResistanceRating", defaultValue = "", required = false) String fireResistanceRating,
			@RequestParam(value = "buildClassify", defaultValue = "", required = false) String buildClassify,
			@RequestParam(value = "buildName", defaultValue = "", required = false) String buildName,
			@RequestParam(value = "plcBuildCode", defaultValue = "", required = false) String plcBuildCode,
			@RequestParam(value = "completedDate", defaultValue = "", required = false) String completedDate,
			@RequestParam(value = "buildAddress", defaultValue = "", required = false) String buildAddress,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		List<Role> role=user.getRole();		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("xzqhCode", xzqhCode);
		paramMap.put("fireResistanceRating", fireResistanceRating);
		paramMap.put("buildClassify", buildClassify);
		paramMap.put("buildName", buildName);
		paramMap.put("plcBuildCode", plcBuildCode);
		paramMap.put("completedDate", completedDate);
		paramMap.put("buildAddress", buildAddress);
		paramMap.put("unitCode", user.getUnitCode()==null?"":user.getUnitCode());
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject object = buildInfoService.unitAndBuildList(paramMap);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);	
		map.addAttribute("display", display);	
		for (Role role2 : role) {
			if(role2.getRoleName().equals("管理处")){
				map.addAttribute("url", "/build/details");	
			}else if(role2.getRoleName().equals("民警")){
				map.addAttribute("url", "/entityResponsibility/details");	
			}
		}
		return "BuildInfos/Build/BuildInfo_list";
	}
	
	@RequestMapping(value = "/build/unitinfo", method = RequestMethod.POST)
	@ResponseBody
	public String BuildInfo_listInfo(
			ModelMap map,
			@RequestBody String body) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		paramMap.put("unitCode", user.getUnitCode());
		JSONObject object = buildInfoService.getBuildname(paramMap);
		map.addAttribute("object", object);
		return object.toString();
	}

	/**
	 * 新增建筑信息
	 */
	@RequestMapping(value = "/build/add", method = RequestMethod.GET)
	public String BuildInfoGet_add(ModelMap map) {
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		return "BuildInfos/Build/BuildInfo_add";
	}

	
	@RequestMapping(value = "/build/add", method = RequestMethod.POST)
	@ResponseBody
	public String BuildInfo_add(@RequestBody String body) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		paramMap.put("unitCode", user.getUnitCode());
		JSONObject object = buildInfoService.add(paramMap);
			String json = object.toString();
			return json;		
	}


	/**
	 * 删除建筑信息
	 */
	@RequestMapping(value = "/build/del", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam(name = "buildCode") String buildCode) {
		JSONObject object = buildInfoService.del(buildCode);
		String json = object.toString();
		return json;
	}
	

	/**
	 * 建筑信息更新
	 */
	@RequestMapping(value = "/build/edit", method = RequestMethod.GET)
	public String BuildInfo_edit(
			ModelMap map,
			@RequestParam(value = "buildCode") String buildCode) {
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("buildCode", buildCode);
		return "BuildInfos/Build/BuildInfo_edit";
	}

	@RequestMapping(value = "/build/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String BuildInfo_edit(
			@RequestParam(name = "buildCode") String buildCode,
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		buildInfoService.set(buildCode,paramMap.get("plcBuildCode").toString());
		paramMap.remove("plcBuildCode");
		JSONObject object = buildInfoService.edit(buildCode, paramMap);
		String json = object.toString();
		return json;
	}



	/**
	 * 获取建筑信息
	 */
	@RequestMapping(value = "/build/details")
	public String BuildInfo_details(ModelMap map,@RequestParam(value = "buildCode") String buildCode) {
		JSONObject object = buildInfoService.findOne(buildCode);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("object", object);
		map.addAttribute("buildCode", buildCode);
		return "BuildInfos/Build/BuildInfo_details";
	}
	
	/**
	 * 建筑信息
	 */
	@RequestMapping(value = "/build/info", method = RequestMethod.GET)
	public String BuildInfo_info(
			ModelMap map,
			@RequestParam(value = "buildCode") String buildCode) {
		JSONObject object = buildInfoService.findOne(buildCode);
		map.addAttribute("object", object);
		map.addAttribute("buildCode", buildCode);
		return "BuildInfos/Build/BuildInfo_info";
	}
	
}