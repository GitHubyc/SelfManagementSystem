package com.xakj.controller;

import java.util.HashMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xakj.constant.Constant;
import com.xakj.model.dto.User;
import com.xakj.service.BuildInfoService;
import com.xakj.service.FireControlInstrumentationService;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class FireControlInstrumentationController {

	@Autowired
	private FireControlInstrumentationService fireControlInstrumentationService;
	@Autowired
	private BuildInfoService buildInfoService;

	/**
	 * 消防物联列表
	 */
	@RequestMapping(value = "/firecontrolinstrumentation/list")
	public String FireControlInstrumentation_list(ModelMap map, String buildId,
			Integer floor, String address, Integer type) {
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			// 管理处下面的所有的就建筑
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("currentPage", 1);
			paramMap.put("pageSize", Integer.MAX_VALUE);
			JSONObject buildList = buildInfoService.list(paramMap);
			// 传感器类型
			paramMap.clear();
			paramMap.put("currentPage", 1);
			paramMap.put("pageSize", Integer.MAX_VALUE);
			JSONObject sensorTypeList = fireControlInstrumentationService
					.sensorTypeList(paramMap);
			// 获取所有的传感器
			paramMap.clear();
			paramMap.put("currentPage", 1);
			paramMap.put("pageSize", Integer.MAX_VALUE);
			paramMap.put("floor", floor);
			paramMap.put("address", address);
			paramMap.put("type", type);
			paramMap.put("unitCode", user.getUnitCode());
			paramMap.put("buildId", buildId);
			JSONObject sensorInfoList = new JSONObject();
			if (StringUtils.isEmpty(buildId)) {
				sensorInfoList = fireControlInstrumentationService
						.sensorInfoListByUnitCode(paramMap);
			} else {
				sensorInfoList = fireControlInstrumentationService
						.sensorInfoList(paramMap);
			}
			// 正常的传感器
			JSONArray normalList = new JSONArray();
			// 异常的传感器
			JSONArray warningList = new JSONArray();
			JSONArray array = new JSONArray();
			if (!StringUtils.isEmpty(sensorInfoList.get("data"))
					&& !"null".equals(sensorInfoList.get("data"))) {
				array = (JSONArray) sensorInfoList.get("data");
			}
			for (int i = 0; i < array.size(); i++) {
				JSONObject object = (JSONObject) array.get(i);
				String status = object.getString("reportStatus");
				if (StringUtils.isEmpty(status) || "null".equals(status)
						|| status.contains("1")) {
					warningList.add(object);
				} else {
					normalList.add(object);
				}
			}
			map.addAttribute("sensorTypeList", sensorTypeList);
			map.addAttribute("warningList", warningList);
			map.addAttribute("normalList", normalList);
			map.addAttribute("buildList", buildList);
			map.addAttribute("paramMap", paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FireControlInstrumentation/FireControlInstrumentation_list";
	}

	/**
	 * 根据传感器ID获取传感器历史记录
	 */
	@RequestMapping(value = "/sensorHistoryById")
	public String sensorHistoryById(String id) {
		return "FireControlInstrumentation/FireControlInstrumentation_details";
	}

	/**
	 * 根据单位ID获取传感器列表
	 */
	@RequestMapping(value = "/sensorInfoListByUnitCode")
	public JSONObject sensorInfoListByUnitCode(Integer floor, String address,
			Integer type) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("floor", floor);
		paramMap.put("address", address);
		paramMap.put("type", type);
		paramMap.put("unitCode", user.getUnitCode());
		return fireControlInstrumentationService
				.sensorInfoListByUnitCode(paramMap);
	}

	/**
	 * 消防物联新增
	 */
	@RequestMapping(value = "/firecontrolinstrumentation/add")
	public String FireControlInstrumentation_add() {
		return "FireControlInstrumentation/FireControlInstrumentation_add";
	}

	/**
	 * 进入传感器列表
	 */
	@RequestMapping(value = "/sensor/list")
	public String Sensor_list(
			ModelMap map,
			Integer floor,
			@RequestParam(value = "address", required = false) String address,
			Integer type,
			@RequestParam(value = "sensorSpotId", required = false) String sensorSpotId,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			// 传感器类型
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			// 获取所有的传感器
			paramMap.clear();
			paramMap.put("currentPage", currentPage);
			paramMap.put("pageSize", pageSize);
			paramMap.put("floor", floor);
			paramMap.put("address", address);
			paramMap.put("sensorSpotId", sensorSpotId);
			paramMap.put("type", type);
			paramMap.put("unitCode", user.getUnitCode());
			JSONObject object = fireControlInstrumentationService
					.sensorInfoListByUnitCode(paramMap);
			map.addAttribute("paramMap", paramMap);
			map.addAttribute("object", object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FireControlInstrumentation/Sensor_list";
	}

	/**
	 * 传感器新增
	 */
	@RequestMapping(value = "/sensor/add")
	public String Sensor_add(ModelMap map) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("currentPage", 1);
		paramMap.put("pageSize", Integer.MAX_VALUE);
		// 管理处下面的所有的就建筑
		JSONObject buildList = buildInfoService.list(paramMap);
		// 传感器类型
		JSONObject sensorTypeList = fireControlInstrumentationService
				.sensorTypeList(null);
		// 前置机列表
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		paramMap.clear();
		paramMap.put("currentPage", 1);
		paramMap.put("pageSize", Integer.MAX_VALUE);
		paramMap.put("unitId", user.getUnitCode());
		JSONObject frontEndComputerList = fireControlInstrumentationService
				.getFrontEndComputerByUnitId(paramMap);
		map.addAttribute("buildList", buildList);
		map.addAttribute("sensorTypeList", sensorTypeList);
		map.addAttribute("frontEndComputerList", frontEndComputerList);
		return "FireControlInstrumentation/Sensor_add";
	}

	/**
	 * 传感器新增
	 */
	@RequestMapping(value = "/sensor", method = RequestMethod.POST)
	@ResponseBody
	public String Sensor_add(@RequestBody String requestbody) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			HashMap<String, Object> paramMap = mapper.readValue(requestbody,
					HashMap.class);
			String json = fireControlInstrumentationService
					.saveSensor(paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 传感器删除
	 */
	@RequestMapping(value = "/sensor", method = RequestMethod.DELETE)
	@ResponseBody
	public String Sensor_delete(
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", id);
			String json = fireControlInstrumentationService.deleteSensor(
					paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 传感器更新
	 */
	@RequestMapping(value = "/sensor", method = RequestMethod.PUT)
	@ResponseBody
	public String Sensor_update(@RequestBody String requestbody) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			HashMap<String, Object> paramMap = mapper.readValue(requestbody,
					HashMap.class);
			String json = fireControlInstrumentationService.updateSensor(
					paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 传感器详情
	 */
	@RequestMapping(value = "/sensor/details")
	public String Sensor_details(
			ModelMap map,
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", id);
			JSONObject object = fireControlInstrumentationService
					.getSensor(paramMap);
			paramMap.clear();
			paramMap.put("currentPage", 1);
			paramMap.put("pageSize", Integer.MAX_VALUE);
			// 管理处下面的所有的就建筑
			JSONObject buildList = buildInfoService.list(paramMap);
			// 传感器类型
			JSONObject sensorTypeList = fireControlInstrumentationService
					.sensorTypeList(null);
			// 前置机列表
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			paramMap.clear();
			paramMap.put("currentPage", 1);
			paramMap.put("pageSize", Integer.MAX_VALUE);
			paramMap.put("unitId", user.getUnitCode());
			JSONObject frontEndComputerList = fireControlInstrumentationService
					.getFrontEndComputerByUnitId(paramMap);
			map.addAttribute("buildList", buildList);
			map.addAttribute("sensorTypeList", sensorTypeList);
			map.addAttribute("frontEndComputerList", frontEndComputerList);
			map.addAttribute("object", object.get("data"));
			return "FireControlInstrumentation/Sensor_details";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 传感器编辑页面
	 */
	@RequestMapping(value = "/sensor/edit")
	public String Sensor_edit(
			ModelMap map,
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", id);
			JSONObject object = fireControlInstrumentationService
					.getSensor(paramMap);
			paramMap.clear();
			paramMap.put("currentPage", 1);
			paramMap.put("pageSize", Integer.MAX_VALUE);
			// 管理处下面的所有的就建筑
			JSONObject buildList = buildInfoService.list(paramMap);
			// 传感器类型
			JSONObject sensorTypeList = fireControlInstrumentationService
					.sensorTypeList(null);
			// 前置机列表
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			paramMap.clear();
			paramMap.put("currentPage", 1);
			paramMap.put("pageSize", Integer.MAX_VALUE);
			paramMap.put("unitId", user.getUnitCode());
			JSONObject frontEndComputerList = fireControlInstrumentationService
					.getFrontEndComputerByUnitId(paramMap);
			map.addAttribute("buildList", buildList);
			map.addAttribute("sensorTypeList", sensorTypeList);
			map.addAttribute("frontEndComputerList", frontEndComputerList);
			map.addAttribute("object", object.get("data"));
			return "FireControlInstrumentation/Sensor_edit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 前置机新增
	 */
	@RequestMapping(value = "/front_end_computer/add")
	public String Front_end_computer_add() {
		return "FireControlInstrumentation/Front_end_computer_add";
	}

	/**
	 * 前置机新增
	 */
	@RequestMapping(value = "/front_end_computer", method = RequestMethod.POST)
	@ResponseBody
	public String Front_end_computer_add(@RequestBody String requestbody) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			HashMap<String, Object> paramMap = mapper.readValue(requestbody,
					HashMap.class);
			paramMap.put("unitId", user.getUnitCode());
			String json = fireControlInstrumentationService
					.saveFrontEndComputer(paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 前置机删除
	 */
	@RequestMapping(value = "/front_end_computer", method = RequestMethod.DELETE)
	@ResponseBody
	public String Front_end_computer_delete(
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", id);
			String json = fireControlInstrumentationService
					.deleteFrontEndComputer(paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 前置机更新
	 */
	@RequestMapping(value = "/front_end_computer", method = RequestMethod.PUT)
	@ResponseBody
	public String Front_end_computer_update(@RequestBody String requestbody) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			HashMap<String, Object> paramMap = mapper.readValue(requestbody,
					HashMap.class);
			paramMap.put("unitId", user.getUnitCode());
			String json = fireControlInstrumentationService
					.updateFrontEndComputer(paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 前置机详情
	 */
	@RequestMapping(value = "/front_end_computer/details")
	public String Front_end_computer_details(
			ModelMap map,
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", id);
			JSONObject object = fireControlInstrumentationService
					.getFrontEndComputer(paramMap);
			map.put("object", object.get("data"));
			return "FireControlInstrumentation/Front_end_computer_details";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 前置机编辑页面
	 */
	@RequestMapping(value = "/front_end_computer/edit")
	public String Front_end_computer_edit(
			ModelMap map,
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", id);
			JSONObject object = fireControlInstrumentationService
					.getFrontEndComputer(paramMap);
			map.put("object", object.get("data"));
			return "FireControlInstrumentation/Front_end_computer_edit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 进入前置机列表
	 */
	@RequestMapping(value = "/front_end_computer/list")
	public String Front_end_computer_list(
			ModelMap map,
			@RequestParam(value = "name", defaultValue = "", required = false) String name,
			@RequestParam(value = "address", defaultValue = "", required = false) String address,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", name);
		paramMap.put("address", address);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		paramMap.put("unitId", user.getUnitCode());
		JSONObject object = fireControlInstrumentationService
				.getFrontEndComputerByUnitId(paramMap);
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);
		return "FireControlInstrumentation/Front_end_computer_list";
	}

	/**
	 * 消防主机列表
	 */
	@RequestMapping(value = "/fire_engine/list")
	public String Fire_engine_list(
			ModelMap map,
			@RequestParam(value = "name", defaultValue = "", required = false) String name,
			@RequestParam(value = "address", defaultValue = "", required = false) String address,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", name);
		paramMap.put("address", address);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		paramMap.put("unitId", user.getUnitCode());
		JSONObject object = fireControlInstrumentationService
				.listFireengine(paramMap);
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);
		return "FireControlInstrumentation/Fire_engine_list";
	}

	/**
	 * 消防主机新增
	 */
	@RequestMapping(value = "/fire_engine/add")
	public String Fire_engine_add(ModelMap map) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		// 管理处下面的所有的建筑
		JSONObject buildList = buildInfoService.list(paramMap);
		// 前置机列表
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		paramMap.clear();
		paramMap.put("currentPage", 1);
		paramMap.put("pageSize", Integer.MAX_VALUE);
		paramMap.put("unitId", user.getUnitCode());
		JSONObject frontEndComputerList = fireControlInstrumentationService
				.getFrontEndComputerByUnitId(paramMap);
		map.addAttribute("buildList", buildList);
		map.addAttribute("frontEndComputerList", frontEndComputerList);
		return "FireControlInstrumentation/Fire_engine_add";
	}

	/**
	 * 消防主机新增
	 */
	@RequestMapping(value = "/fire_engine", method = RequestMethod.POST)
	@ResponseBody
	public String Fire_engine_add(@RequestBody String requestbody) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			HashMap<String, Object> paramMap = mapper.readValue(requestbody,
					HashMap.class);
			paramMap.put("unitId", user.getUnitCode());
			String json = fireControlInstrumentationService.saveFireengine(
					paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 消防主机删除
	 */
	@RequestMapping(value = "/fire_engine", method = RequestMethod.DELETE)
	@ResponseBody
	public String Fire_engine_delete(
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", id);
			String json = fireControlInstrumentationService.deleteFireengine(
					paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 消防主机更新
	 */
	@RequestMapping(value = "/fire_engine", method = RequestMethod.PUT)
	@ResponseBody
	public String Fire_engine_update(@RequestBody String requestbody) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			HashMap<String, Object> paramMap = mapper.readValue(requestbody,
					HashMap.class);
			paramMap.put("unitId", user.getUnitCode());
			String json = fireControlInstrumentationService.updateFireengine(
					paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 消防主机详情
	 */
	@RequestMapping(value = "/fire_engine/details")
	public String Fire_engine_details(
			ModelMap map,
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			// 管理处下面的所有的建筑
			JSONObject buildList = buildInfoService.list(paramMap);
			// 前置机列表
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			paramMap.clear();
			paramMap.put("currentPage", 1);
			paramMap.put("pageSize", Integer.MAX_VALUE);
			paramMap.put("unitId", user.getUnitCode());
			JSONObject frontEndComputerList = fireControlInstrumentationService
					.getFrontEndComputerByUnitId(paramMap);
			paramMap.clear();
			// 详情
			paramMap.put("id", id);
			JSONObject object = fireControlInstrumentationService
					.getFireengine(paramMap);
			map.addAttribute("buildList", buildList);
			map.addAttribute("frontEndComputerList", frontEndComputerList);
			map.addAttribute("object", object.get("data"));
			return "FireControlInstrumentation/Fire_engine_details";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 消防主机编辑页面
	 */
	@RequestMapping(value = "/fire_engine/edit")
	public String Fire_engine_edit(
			ModelMap map,
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			// 管理处下面的所有的建筑
			JSONObject buildList = buildInfoService.list(paramMap);
			// 前置机列表
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			paramMap.clear();
			paramMap.put("currentPage", 1);
			paramMap.put("pageSize", Integer.MAX_VALUE);
			paramMap.put("unitId", user.getUnitCode());
			JSONObject frontEndComputerList = fireControlInstrumentationService
					.getFrontEndComputerByUnitId(paramMap);
			paramMap.clear();
			paramMap.put("id", id);
			JSONObject object = fireControlInstrumentationService
					.getFireengine(paramMap);
			map.addAttribute("buildList", buildList);
			map.addAttribute("frontEndComputerList", frontEndComputerList);
			map.addAttribute("object", object.get("data"));
			return "FireControlInstrumentation/Fire_engine_edit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 探点新增
	 */
	@RequestMapping(value = "/spot_point/add")
	public String Spot_point_add(ModelMap map) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		// 管理所有的消防主机
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		paramMap.clear();
		paramMap.put("currentPage", 1);
		paramMap.put("pageSize", Integer.MAX_VALUE);
		paramMap.put("unitId", user.getUnitCode());
		JSONObject fireengineList = fireControlInstrumentationService
				.listFireengine(paramMap);
		// 探点类型
		JSONObject spotTypeList = fireControlInstrumentationService
				.spotTypeList(paramMap);
		map.addAttribute("fireengineList", fireengineList);
		map.addAttribute("spotTypeList", spotTypeList);
		return "FireControlInstrumentation/Spot_point_add";
	}

	/**
	 * 探点列表
	 */
	@RequestMapping(value = "/spot_point/list")
	public String Spot_point_list(
			ModelMap map,
			@RequestParam(value = "address", defaultValue = "", required = false) String address,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("address", address);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		paramMap.put("unitCode", user.getUnitCode());
		JSONObject object = fireControlInstrumentationService
				.spotpointListByUnitCode(paramMap);
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);
		return "FireControlInstrumentation/Spot_point_list";
	}

	/**
	 * 探点新增
	 */
	@RequestMapping(value = "/spot_point", method = RequestMethod.POST)
	@ResponseBody
	public String Spot_point_add(@RequestBody String requestbody) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			HashMap<String, Object> paramMap = mapper.readValue(requestbody,
					HashMap.class);
			paramMap.put("unitId", user.getUnitCode());
			String json = fireControlInstrumentationService.saveSpotpoint(
					paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 探点删除
	 */
	@RequestMapping(value = "/spot_point", method = RequestMethod.DELETE)
	@ResponseBody
	public String Spot_point_delete(
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", id);
			String json = fireControlInstrumentationService.deleteSpotpoint(
					paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 探点更新
	 */
	@RequestMapping(value = "/spot_point", method = RequestMethod.PUT)
	@ResponseBody
	public String Spot_point_update(@RequestBody String requestbody) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			HashMap<String, Object> paramMap = mapper.readValue(requestbody,
					HashMap.class);
			paramMap.put("unitId", user.getUnitCode());
			String json = fireControlInstrumentationService.updateSpotpoint(
					paramMap).toString();
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 探点详情
	 */
	@RequestMapping(value = "/spot_point/details")
	public String Spot_point_details(
			ModelMap map,
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", id);
			JSONObject object = fireControlInstrumentationService
					.getSpotpoint(paramMap);
			// 管理所有的消防主机
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			paramMap.clear();
			paramMap.put("currentPage", 1);
			paramMap.put("pageSize", Integer.MAX_VALUE);
			paramMap.put("unitId", user.getUnitCode());
			JSONObject fireengineList = fireControlInstrumentationService
					.listFireengine(paramMap);
			// 探点类型
			JSONObject spotTypeList = fireControlInstrumentationService
					.spotTypeList(paramMap);
			map.addAttribute("fireengineList", fireengineList);
			map.addAttribute("spotTypeList", spotTypeList);
			map.put("object", object.get("data"));
			return "FireControlInstrumentation/Spot_point_details";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 探点编辑页面
	 */
	@RequestMapping(value = "/spot_point/edit")
	public String Spot_point_edit(
			ModelMap map,
			@RequestParam(value = "id", defaultValue = "", required = false) String id) {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", id);
			JSONObject object = fireControlInstrumentationService
					.getSpotpoint(paramMap);
			// 管理所有的消防主机
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User) session.getAttribute(Constant.USER);
			paramMap.clear();
			paramMap.put("currentPage", 1);
			paramMap.put("pageSize", Integer.MAX_VALUE);
			paramMap.put("unitId", user.getUnitCode());
			JSONObject fireengineList = fireControlInstrumentationService
					.listFireengine(paramMap);
			// 探点类型
			JSONObject spotTypeList = fireControlInstrumentationService
					.spotTypeList(paramMap);
			map.addAttribute("fireengineList", fireengineList);
			map.addAttribute("spotTypeList", spotTypeList);
			map.put("object", object.get("data"));
			return "FireControlInstrumentation/Spot_point_edit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}