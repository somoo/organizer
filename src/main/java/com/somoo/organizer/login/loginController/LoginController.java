package com.somoo.organizer.login.loginController;

import com.somoo.organizer.login.loginServices.AuthentificationService;
import com.somoo.organizer.login.loginServices.AuthentificationServiceFactory;

public class LoginController {
	
	AuthentificationService authentificationService;


	public Boolean authenticate(String userName, String password) {
		AuthentificationServiceFactory authentificationServiceFactory = new AuthentificationServiceFactory();
		authentificationService = authentificationServiceFactory.createAuthentificationService();
		return authentificationService.authenticate(userName, password);
	}

}
