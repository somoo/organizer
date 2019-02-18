package com.somoo.organizer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.somoo.organizer.injection.InjectionModule;
import com.somoo.organizer.ui.login.LoginUI;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("organizertheme")
public class OrganizerApp extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
		Injector injector = Guice.createInjector(new InjectionModule());
		LoginUI loginUi = injector.getInstance(LoginUI.class);


    	setContent(loginUi);
        
    }

    @WebServlet(urlPatterns = "/*", name = "OrganizerUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = OrganizerApp.class, productionMode = false)
    public static class OrganizerUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    }
}

