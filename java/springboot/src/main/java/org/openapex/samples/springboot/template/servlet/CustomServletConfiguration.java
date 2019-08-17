package org.openapex.samples.springboot.template.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.MultipartConfigElement;

@Configuration
public class CustomServletConfiguration {
    @Bean
    public ServletRegistrationBean registerFileUploadServlet() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(new MyFileUploadServelt(), "/servlet-upload");
        servlet.setMultipartConfig(new MultipartConfigElement(""));
        return servlet;
    }
}
