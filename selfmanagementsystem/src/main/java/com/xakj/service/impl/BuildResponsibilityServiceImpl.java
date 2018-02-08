package com.xakj.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.BuildResponsibilityService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

/**
 * @author 施先锋  深圳消安科技有限公司 2017-2-21下午6:36:57
 */
@Component
public class BuildResponsibilityServiceImpl implements BuildResponsibilityService{
	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		//获取操作路径
		String url = Constant.SERVERURL + "/build/{buildCode}/entityResponsibility/{responsibilityCode}";
		//存放令牌，备验证
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		//令牌的值
		List<String> value = new ArrayList<String>();
		value.add("1eyJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4sQVVUSF9XUklURSIsInN1YiI6ImFkbWluIiwiZXhwIjoxNTA3NjQ2MTI1fQ.ju41WdaBsd64qgXz8Ayd6PRbRTBvW96wz_M8J8WiDXN7jAH9smgQHoavkOZU2B2DEmMBzqUzOy1QrJBpQ-rHXQ");
		map.put("authorization", value);
		//查询参数
		paramMap.put("buildCode", "13456165310");
		paramMap.put("responsibilityCode", "13456165310");

		return HttpClientUtil.postByForm(url, map, paramMap);

	}
}
