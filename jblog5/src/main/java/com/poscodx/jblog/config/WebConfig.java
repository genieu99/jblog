package com.poscodx.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poscodx.jblog.config.app.SecurityConfig;
import com.poscodx.jblog.config.web.FileUploadConfig;
import com.poscodx.jblog.config.web.LocaleConfig;
import com.poscodx.jblog.config.web.MvcConfig;

@Configuration
@EnableAspectJAutoProxy
@Import({MvcConfig.class, LocaleConfig.class, FileUploadConfig.class})
@ComponentScan({"com.poscodx.jblog.controller"})
public class WebConfig implements WebMvcConfigurer {
}
