package com.crescendocollective.config;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
@Singleton
public class ApplicationContextBean {
    private ServletContext servletContext;

    @Inject
    ApplicationContextBean(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    private ApplicationContext getApplicationContext() {
        return WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }
}
