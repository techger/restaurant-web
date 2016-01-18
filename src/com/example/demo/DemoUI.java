package com.example.demo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("demo")
@JavaScript({"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js",
		"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"})
@StyleSheet("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css")
public class DemoUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		CustomLayout custom = new CustomLayout("ZuuchHome");
		layout.addComponent(custom);
	}

}