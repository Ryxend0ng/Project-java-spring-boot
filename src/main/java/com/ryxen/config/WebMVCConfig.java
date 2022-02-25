package com.ryxen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.google.common.base.Objects;
import com.ryxen.constant.Constant;





@Configuration
public class WebMVCConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/template/**").addResourceLocations("classpath:/template/");
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:"  + Constant.UPLOAD_FOLDER_ROOT);
		
	}
	@Bean
	public ViewResolver configView() {
		InternalResourceViewResolver bean=new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		return bean;
		
	}
	@Bean
	public CommonsMultipartResolver multipartResovler() {
		CommonsMultipartResolver common=new CommonsMultipartResolver();
		common.setDefaultEncoding("UTF-8");
		return common;
		
	}
	@Bean
	public Cloudinary cloudinary() {
		Cloudinary cloud=new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "degm8f4tp",
				"api_key", "397126934174246",
				"api_secret","-7KSPDiYnTfaoehAc39fjqY31tQ",
				"secure", true
				
				));
		return cloud;
	}
	private final long MAX_AGE_SECS = 3600;
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
        .allowedHeaders("*")
        .allowCredentials(true)
        .maxAge(MAX_AGE_SECS);
	}
}
