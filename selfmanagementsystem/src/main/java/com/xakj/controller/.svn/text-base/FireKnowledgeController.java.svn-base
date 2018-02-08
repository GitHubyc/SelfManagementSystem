package com.xakj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class FireKnowledgeController {

	/**
	 * 宣传培训列表
	 */
	@RequestMapping(value="/propagandatraining/list")
	public String PropagandaTraining_list(ModelMap map) {
		map.addAttribute("menu", "fireknow");
		return "FireKnowledges/PropagandaTraining/PropagandaTraining_list";
	}

	/**
	 * 宣传培训新增
	 */
	@RequestMapping(value="/propagandatraining/add")
	public String PropagandaTraining_add() {
		
		return "FireKnowledges/PropagandaTraining/PropagandaTraining_add";
	}
	
	/**
	 * 宣传培训更新
	 */
	@RequestMapping(value="/propagandatraining/edit")
	public String PropagandaTraining_edit() {
		
		return "FireKnowledges/PropagandaTraining/PropagandaTraining_edit";
	}
	
	/**
	 * 宣传培训详情
	 */
	@RequestMapping(value="/propagandatraining/details")
	public String PropagandaTraining_details() {
		
		return "FireKnowledges/PropagandaTraining/PropagandaTraining_details";
	}
	

	/**
	 * 法律法规列表
	 */
	@RequestMapping(value="/lawsregulations/list")
	public String list(ModelMap map) {
		map.addAttribute("menu", "fireknow");
		return "FireKnowledges/LawsRegulations/LawsRegulations_list";
	}

	/**
	 * 法律法规新增
	 */
	@RequestMapping(value="/lawsregulations/add")
	public String add() {
		
		return "FireKnowledges/LawsRegulations/LawsRegulations_add";
	}
	
	/**
	 * 法律法规更新
	 */
	@RequestMapping(value="/lawsregulations/edit")
	public String edit() {
		
		return "FireKnowledges/LawsRegulations/LawsRegulations_edit";
	}
	
	/**
	 * 法律法规详情
	 */
	@RequestMapping(value="/lawsregulations/details")
	public String LawsRegulations_details() {
		
		return "FireKnowledges/LawsRegulations/LawsRegulations_details";
	}
	
//	@RequestMapping(value = "/ueditor")
//	 @ResponseBody
//	 public String imgUpload3(HttpServletRequest request,HttpServletResponse response) {
//		
//			response.setHeader("Content-Type" , "text/html");
//			
//			String rootPath = request.getRealPath("/") + "static\\img";
//			
//	          
//	     return new ActionEnter( request, rootPath ).exec();
//	 }
}