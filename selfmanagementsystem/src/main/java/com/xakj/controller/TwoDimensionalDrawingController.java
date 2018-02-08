package com.xakj.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.service.TwoDimensionalDrawingService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class TwoDimensionalDrawingController {
	@Autowired
	TwoDimensionalDrawingService twoDimensionalDrawingService;

	/**
	 * 图纸列表
	 */
	@RequestMapping(value="/twodimensionaldrawing/list")
	public String TwoDimensionalDrawing_list() {
		
		return "TwoDimensionalDrawing_list";
	}
	
	/**
	 * 图纸新增
	 */
	@RequestMapping(value="/twodimensionaldrawing/add")
	public String TwoDimensionalDrawing_add() {		
		return "TwoDimensionalDrawing_add";
	}
	
	/**
	 * 图纸编辑
	 */
	@RequestMapping(value="/twodimensionaldrawing/edit",method = RequestMethod.POST)
	@ResponseBody
	public String TwoDimensionalDrawing_edit(@RequestBody String body
			
			) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject json=twoDimensionalDrawingService.save(paramMap.get("buildCode").toString(),paramMap.get("floorCode").toString(), paramMap);	
		return json.toString();
	}
	
	/**
	 * 图纸详情
	 */
	@RequestMapping(value="/twodimensionaldrawing/details")
	public String TwoDimensionalDrawing_details() {
		
		return "TwoDimensionalDrawing_details";
	}
	
}