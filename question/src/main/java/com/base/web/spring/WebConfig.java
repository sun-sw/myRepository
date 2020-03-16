package com.base.web.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.base.web.controller.BaseController;

@Configuration
//@EnableWebMvc
//@EnableAsync
@ComponentScan(basePackageClasses = { BaseController.class }, basePackages = { "web.base.com.online.controller.**" })
public class WebConfig extends WebMvcConfigurationSupport {

	@Bean
	public FreeMarkerConfig freeMarkerConfig() {
		FreeMarkerConfigurer freeMarkerConfig = new FreeMarkerConfigurer();
		freeMarkerConfig.setTemplateLoaderPath("/WEB-INF/views/");
		freeMarkerConfig.setDefaultEncoding("UTF-8");
		return freeMarkerConfig;
	}

	@Bean
	public ViewResolver viewResolver() {
		FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
		freeMarkerViewResolver.setSuffix(".html");
		freeMarkerViewResolver.setContentType("text/html;charset=utf-8");
		freeMarkerViewResolver.setRequestContextAttribute("rc");
		freeMarkerViewResolver.setOrder(0);
		return freeMarkerViewResolver;
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/").setCachePeriod(Integer.MAX_VALUE);
	}

}
