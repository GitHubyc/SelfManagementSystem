package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
public interface UploadFileService {

	/**
	 * 单文件上传
	 */
	public JSONObject upload(HashMap<String, Object> paramMap);
	
	/**
	 * 多文件shangc
	 */
	public JSONObject batchUpload(HashMap<String, Object> paramMap);
}
