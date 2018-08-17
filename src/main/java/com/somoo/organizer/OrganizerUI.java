package com.somoo.organizer;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import login.LoginUI;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("organizertheme")
public class OrganizerUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final LoginUI loginUi  = new LoginUI();
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	


    	setContent(loginUi);
        
    }

    @WebServlet(urlPatterns = "/*", name = "OrganizerUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = OrganizerUI.class, productionMode = false)
    public static class OrganizerUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    }
}
