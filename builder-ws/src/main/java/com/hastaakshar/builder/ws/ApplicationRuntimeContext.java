package com.hastaakshar.builder.ws;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.hastaakshar.builder.manager.BuilderManager;

public class ApplicationRuntimeContext implements ApplicationContextAware {

	private static ApplicationContext context;

	public static BuilderManager getBuilderManager() {
		return context.getBean(BuilderManager.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

}
