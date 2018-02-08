package com.xakj.controller;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xakj.service.UploadFileService;
import com.xakj.util.DeleteDirUtil;
import com.xakj.util.FilesUtil;
import com.xiaoleilu.hutool.io.FileUtil;

import net.sf.json.JSONObject;

@RestController
public class UploadFileController {
	@Autowired
	private UploadFileService uploadFileService;


	/**
	 * 上传单个文件
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)

	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		fileName = UUID.randomUUID() + suffixName;
		String filePath = request.getSession().getServletContext().getRealPath("upload/");
		try {
			FilesUtil.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
		}
		String url =filePath+fileName;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("file", FileUtil.file(url));
		JSONObject object = uploadFileService.upload(paramMap);
		if (DeleteDirUtil.deleteDir(new File(filePath))) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}

		String json = object.toString();
		return json;
	}

	
	/**
	 * 多文件上传 主要是使用了MultipartHttpServletRequest和MultipartFile
	 */
	@RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
	public String batchUpload(HttpServletRequest request) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("file", request);
		JSONObject object = uploadFileService.batchUpload(paramMap);
		String json = object.toString();
		return json;

	}

}
