package com.somoo.organizer.login.loginController;

import com.somoo.organizer.login.loginServices.AbstractUserAuthentificationService;
import com.somoo.organizer.login.loginServices.UserAuthentificationServiceImpl;

public class LoginControllerImpl extends AbstractLoginController{
	
	AbstractUserAuthentificationService userAuthentificationService;

	@Override
	public Boolean authenticate(String userName, String password) {
		userAuthentificationService = new UserAuthentificationServiceImpl();
		return userAuthentificationService.authenticate(userName, password);
	}

}
