package com.sims.utils;
import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;



public class SIMSServletContextListener implements ServletContextListener {

	private static Log logger = LogFactory.getLog(SIMSServletContextListener.class);

	private String log4jLocation = null;

	private String log4jProp = null;

	private String errorMessagesProp = null;

	private String errorMessagesLocation = null;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {

			ServletContext servletContext = servletContextEvent.getServletContext();

			System.out.println("MAUI ServletContextEvent is initializing log4j");

			log4jLocation = servletContextEvent.getServletContext().getInitParameter("log4j-properties-location");
			System.out.println("log4jLocation : " + log4jLocation);

			
			if (log4jLocation == null) {
				System.err.println(
						"*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");
				BasicConfigurator.configure();
			} else {
				String webAppPath = servletContext.getRealPath("/");
				log4jProp = webAppPath + log4jLocation;
				File file = new File(log4jProp);
				if (file.exists()) {
					System.out.println("Initializing log4j with: " + log4jProp);
					PropertyConfigurator.configure(log4jProp);
				} else {
					logger.error(
							"*** " + log4jProp + " file not found, so initializing log4j with BasicConfigurator");
					BasicConfigurator.configure();
				}
			}

			logger.info(" ****** Context Initialized for MAUI **** ");
		} catch (Exception e) {

			logger.error("*** Unable to initialize the context : " + e + e.getMessage());

			logger.error("exception in contextInitialized : " + e + e.getMessage());
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub

	}

}

