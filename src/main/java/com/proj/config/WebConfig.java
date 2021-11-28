package com.proj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	//CORS 에러 해결위한 코드(운영 시에는 주석처리 필요)
	@Override
	public void addCorsMappings(CorsRegistry reg) {
		System.out.println("#################다른 페이지cors 처리");
		//reg.addMapping("/board/**").allowCredentials(true).allowedOrigins("http://localhost:3000");
		//reg.addMapping("/task/**").allowCredentials(true).allowedOrigins("http://localhost:3000");
		//reg.addMapping("/member/**").allowCredentials(true).allowedOrigins("http://localhost:3000");
		//reg.addMapping("/authenticate**").allowCredentials(true).allowedOrigins("http://localhost:3000");
		
		//reg.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("GET", "POST");;
	}
}
