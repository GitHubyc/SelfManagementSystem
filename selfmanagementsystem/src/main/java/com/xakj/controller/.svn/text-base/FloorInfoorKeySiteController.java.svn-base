package com.xakj.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xakj.service.BuildInfoService;
import com.xakj.service.FloorInfoService;
import com.xakj.service.TwoDimensionalDrawingService;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class FloorInfoorKeySiteController{
	@Autowired
	private FloorInfoService floorInfoService;
	@Autowired
	private BuildInfoService buildInfoService;
	@Autowired
	private TwoDimensionalDrawingService twoDimensionalDrawingService;
	

	/**
	 * 楼层信息
	 */
	@RequestMapping(value="/floorinfoorkeysite/list")
	public String FloorInfo_list( 
			ModelMap map,
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode,			
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "600", required = false) Integer pageSize) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject floor = floorInfoService.list(buildCode,paramMap);
		JSONObject build = buildInfoService.findOne(buildCode);
		map.addAttribute("object", floor);
		map.addAttribute("obj", build);
		return "BuildInfos/FloorInfoorKeySite/FloorInfoorKeySite_list";
	}
	/**
	 * 图纸信息
	 */
	@RequestMapping(value="/floorinfoorkeysite/info")
	public String FloorInfo_info( 
			ModelMap map,
			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode,
			@RequestParam(value = "floorCode", defaultValue = "", required = false) String floorCode
			) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		JSONObject floor = floorInfoService.list(buildCode,paramMap);
		
		//总平面图
		paramMap.put("drawingType", 1);
		JSONObject totalPlan = twoDimensionalDrawingService.list(buildCode,floorCode,paramMap);
		//建筑立面图
		paramMap.put("drawingType", 2);
		JSONObject ElevationMap = twoDimensionalDrawingService.list(buildCode,floorCode,paramMap);
		//标准层建筑平面图
		paramMap.put("drawingType", 3);
		JSONObject plan = twoDimensionalDrawingService.list(buildCode,floorCode,paramMap);
		//非标准层建筑平面图
		paramMap.put("drawingType", 4);
		JSONObject noPlan = twoDimensionalDrawingService.list(buildCode,floorCode,paramMap);
		//其他
		paramMap.put("drawingType", 5);
		JSONObject rest = twoDimensionalDrawingService.list(buildCode,floorCode,paramMap);	
	
		map.addAttribute("object", floor);
		map.addAttribute("buildCode", buildCode);
		map.addAttribute("floorCode", floorCode);
		map.addAttribute("totalPlan", totalPlan);
		map.addAttribute("ElevationMap", ElevationMap);
		map.addAttribute("plan", plan);
		map.addAttribute("noPlan", noPlan);
		map.addAttribute("rest", rest);
		return "BuildInfos/FloorInfoorKeySite/FloorInfoorKeySite_info";
	}
	
	
//	/**
//	 * 楼层信息
//	 */
//	@RequestMapping(value="/floorinfoorkeysite/details")
//	public String FloorInfo_edit(	ModelMap map,
//			@RequestParam(value = "buildCode", defaultValue = "", required = false) String buildCode,			
//			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
//			@RequestParam(value = "pageSize", defaultValue = "600", required = false) Integer pageSize) {
//		HashMap<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("currentPage", currentPage);
//		paramMap.put("pageSize", pageSize);
//		JSONObject floor = floorInfoService.list(buildCode,paramMap);
//		JSONObject build = buildInfoService.findOne(buildCode);
//		map.addAttribute("object", floor);
//		map.addAttribute("obj", build);
//		return "BuildInfos/FloorInfoorKeySite/FloorInfoorKeySite_details";
//	}
}