package com.xakj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class ArchivesOtherInfoController {

	/**
	 * 其他信息
	 */
	@RequestMapping(value="/otherInfo/list")
	public String OtherInfo_list() {
		return "Archives/OtherInfo/OtherInfo_list";
	}
}