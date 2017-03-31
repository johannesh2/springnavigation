package com.vaadin.designer.springnavigation;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

@SpringComponent
@UIScope
@SpringViewDisplay
public class MainLayout extends MainLayoutDesign implements ViewDisplay {

	public MainLayout() {

	}

	@PostConstruct
	public void init() {
		userButton.addClickListener(event -> getUI().getNavigator().navigateTo(UserView.VIEW_NAME));
		statusButton.addClickListener(event -> getUI().getNavigator().navigateTo(StatusView.VIEW_NAME));
	}

	@Override
	public void showView(View view) {
		content.setContent((Component) view);
	}
}
