package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.UploadFileService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
@Component
public class UploadFileServiceImpl implements UploadFileService{

	@Override
	public JSONObject upload(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/upload";
		return HttpClientUtil.postByForm(url, HttpClientUtil.getTokenUpload(), paramMap);
	}

	@Override
	public JSONObject batchUpload(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/upload/batch";	
		return HttpClientUtil.postByForm(url, HttpClientUtil.getToken(), paramMap);
	}


}
