package com.somoo.organizer.login.loginUi;


import com.somoo.organizer.login.loginController.AbstractLoginController;
import com.somoo.organizer.login.loginController.LoginControllerImpl;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class LoginUI extends HorizontalLayout {
	

	private FormLayout loginForm;
	private TextField tfUsername;
	private PasswordField tfPassword;
	private Button btnLogin;
	
	private AbstractLoginController loginController;; 
	

	public LoginUI() {
		
		initComponent();
		initLayout();
		initListener();
		initComponentTree();

	}
	private void initListener() {
		
		btnLogin.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				loginController = new LoginControllerImpl();
				if(loginController.authenticate(tfUsername.getValue(),tfPassword.getValue())){
					
					Notification.show("Correct","welcome",Type.HUMANIZED_MESSAGE);
				};
				
			}
		});
		
	}
	private void initComponent() {

		loginForm = new FormLayout();
		tfUsername = new TextField();
		tfUsername.setCursorPosition(0);
		tfUsername.setPlaceholder("username");
		tfPassword = new PasswordField();
		tfPassword.setPlaceholder("password");
		btnLogin = new Button("login");
		btnLogin.setClickShortcut(KeyCode.ENTER);
		
	};
	private void initLayout() {
		this.setWidth(100, Unit.PERCENTAGE);
    	this.setSpacing(true);
    	this.setMargin(true);
    	this.setHeight(100, Unit.PERCENTAGE);
    	
    	loginForm.setWidth(20, Unit.PERCENTAGE);
    	
    	tfUsername.setWidth("300px");
    	
    	tfPassword.setWidth("300px");
    	
    	btnLogin.setWidth("300px");
    	
	}
	private void initComponentTree() {
		
		loginForm.addComponents(tfUsername,tfPassword,btnLogin);
		
		this.addComponent(loginForm);
		
    	this.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
    	

	}




}
