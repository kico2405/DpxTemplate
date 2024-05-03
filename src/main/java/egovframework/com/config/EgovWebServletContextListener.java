package egovframework.com.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EgovWebServletContextListener implements ServletContextListener {
		
	@Value("${spring.profiles.active}")
	private String active;	
	
	
	public EgovWebServletContextListener() {
		setEgovProfileSetting();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		if (active == null) {
			setEgovProfileSetting();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		if (active != null) {
			System.clearProperty(active);
		}
	}

	public void setEgovProfileSetting() {
		try {
			log.debug("===========================Start EgovServletContextLoad START ===========");
			log.debug("Setting spring.profiles.active>" + System.getProperty("spring.profiles.active"));
			log.debug("===========================END   EgovServletContextLoad END ===========");
		} catch (IllegalArgumentException e) {
			log.error("[IllegalArgumentException] Try/Catch...usingParameters Runing : " + e.getMessage());
		}
	}
}
