package com.tiagobalduino.springhibernate.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext) {
		XmlWebApplicationContext root = new XmlWebApplicationContext();
		root.setConfigLocation("/WEB-INF/applicationContext.xml");
		servletContext.addListener(new ContextLoaderListener(root));
		
		WebApplicationContext context = getContext();
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet",new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("*.xhtml");
        dispatcher.addMapping("/*");
	}
	
	private WebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.tiagobalduino.springhibernate.config");
        return context;
    }

	@Override
	protected Class[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}