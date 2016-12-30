package com.vaadin.designer.springnavigation;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;

@SpringView(name = StatusView.VIEW_NAME)
public class StatusView extends StatusViewDesign implements View {
	public static final String VIEW_NAME = "status";

	@Override
	public void enter(ViewChangeEvent event) {

	}

}
