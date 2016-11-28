package com.vaadin.designer.springnavigation;

import java.lang.annotation.Annotation;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.declarative.Design.ComponentFactory;
import com.vaadin.ui.declarative.Design.DefaultComponentFactory;
import com.vaadin.ui.declarative.DesignContext;

@SpringComponent("MyComponentFactory")
public class MyComponentFactory implements ComponentFactory {

	private ComponentFactory componentFactory = new DefaultComponentFactory();

	private final ApplicationContext applicationContext;

	@Autowired
	public MyComponentFactory(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public Component createComponent(String fullyQualifiedClassName, DesignContext context) {
		try {
			Class<?> componentClass = Class.forName(fullyQualifiedClassName);
			Annotation[] annotations = componentClass.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation.annotationType().equals(SpringComponent.class)
						|| annotation.annotationType().equals(org.springframework.stereotype.Component.class)
						|| annotation.annotationType().equals(SpringViewDisplay.class)) {
					return (Component) applicationContext.getBean(componentClass);
				}
			}
			return componentFactory.createComponent(fullyQualifiedClassName, context);
		} catch (ClassNotFoundException | NoSuchBeanDefinitionException e) {
			return componentFactory.createComponent(fullyQualifiedClassName, context);
		}
	}
}
