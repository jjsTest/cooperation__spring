package com.proj;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	//CORS 에러 해결위한 코드(운영 시에는 주석처리 필요)
	@Override
	public void addCorsMappings(CorsRegistry reg) {
		reg.addMapping("/board/**").allowCredentials(true).allowedOrigins("http://localhost:3000");
		
	}
}
