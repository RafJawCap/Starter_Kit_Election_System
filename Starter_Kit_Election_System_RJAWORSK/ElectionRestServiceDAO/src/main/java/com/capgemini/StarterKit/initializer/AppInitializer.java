package com.capgemini.StarterKit.initializer;

import com.capgemini.StarterKit.configuration.AppConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class AppInitializer implements WebApplicationInitializer {

	
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
    	System.out.println("inappinitializer");
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(AppConfiguration.class);
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispacher2", new DispatcherServlet(annotationConfigWebApplicationContext));
      		dispatcher.setLoadOnStartup(1);
      		dispatcher.addMapping("/ElectionRest/*");
    }
}


//@Override
//public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
////      XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
////       applicationContext.setConfigLocation("/WEB-INF/ElectionRest-servlet.xml");
//    AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
//    annotationConfigWebApplicationContext.register(AppConfiguration.class);
////   ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispacher2", new DispatcherServlet(applicationContext));
//    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispacher2", new DispatcherServlet(annotationConfigWebApplicationContext));
//   dispatcher.setLoadOnStartup(1);
//   dispatcher.addMapping("/ElectionRest/*");
//}