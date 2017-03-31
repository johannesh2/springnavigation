package com.vaadin.designer.springnavigation;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.DependsOn;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class MainLayout extends MainLayoutDesign {

	public MainLayout() {

	}

	@PostConstruct
	public void init() {
		userButton.addClickListener(event -> getUI().getNavigator().navigateTo(UserView.VIEW_NAME));
		statusButton.addClickListener(event -> getUI().getNavigator().navigateTo(StatusView.VIEW_NAME));
	}
}
