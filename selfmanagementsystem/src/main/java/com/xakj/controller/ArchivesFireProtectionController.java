package com.xakj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 * 消防监督信息
 */
@Controller
public class ArchivesFireProtectionController {

	/**
	 * 消防监督信息
	 */
	@RequestMapping(value="/fireProtection/list")
	public String FireProtection_list() {
		return "Archives/FireProtection/FireProtection_list";
	}
}