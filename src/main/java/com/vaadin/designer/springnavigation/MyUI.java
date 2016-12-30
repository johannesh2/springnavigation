package com.vaadin.designer.springnavigation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.UI;
import com.vaadin.ui.declarative.Design;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
@SpringUI
public class MyUI extends UI {

	private final MyComponentFactory componentFactory;
	private final ApplicationContext appContext;

	@Autowired
	public MyUI(MyComponentFactory componentFactory, ApplicationContext appContext) {
		this.appContext = appContext;
		this.componentFactory = componentFactory;
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		Design.setComponentFactory(componentFactory);
		setContent(appContext.getBean(MainLayout.class));

		if (getNavigator().getState().isEmpty()) {
			getNavigator().navigateTo(UserView.VIEW_NAME);
		}
	}
}
