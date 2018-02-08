package com.xakj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:28:11
 */
@SpringBootApplication
// 快速启动
@ServletComponentScan
// 自动扫描
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("以jar包方式启动...");
		SpringApplication.run(Application.class, args);
	}
}
