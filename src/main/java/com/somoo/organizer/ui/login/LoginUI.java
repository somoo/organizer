package com.somoo.organizer.ui.login;




import com.google.inject.Inject;
import com.somoo.organizer.service.impl.UserRepositoryServiceImpl;
import com.somoo.organizer.ui.login.controller.LoginController;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class LoginUI extends HorizontalLayout {
	

	private static final long serialVersionUID = 1L;
	private FormLayout loginForm;
	private TextField tfUsername;
	private PasswordField tfPassword;
	private Button btnLogin;

	private LoginController loginController;

	@Inject
	public LoginUI(UserRepositoryServiceImpl userRepositoryServiceImpl) {
		this.loginController = new LoginController(userRepositoryServiceImpl);
		initComponent();
		initLayout();
		initComponentTree();
		initListener();

	}
	private void initListener() {
		
		btnLogin.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {

				if (loginController.authenticate(tfUsername.getValue(), tfPassword.getValue())) {
					letUserIn();
				} else {
					keepUserOut();
				}

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

	private void letUserIn(){
		Notification.show("Yeah you are in!", Notification.Type.HUMANIZED_MESSAGE);
	};

	private void keepUserOut(){
		Notification.show("Nope you are out!", Notification.Type.ERROR_MESSAGE);
	};


}
