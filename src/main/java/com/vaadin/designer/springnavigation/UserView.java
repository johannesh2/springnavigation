package com.vaadin.designer.springnavigation;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;

@SpringView(name = UserView.VIEW_NAME)
public class UserView extends UserViewDesign implements View {

	public static final String VIEW_NAME = "user";

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
