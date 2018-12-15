package com.somoo.organizer.login.controller;

import com.somoo.organizer.login.service.AuthentificationService;
import com.somoo.organizer.login.service.AuthentificationServiceFactory;

public class LoginController {
	
	AuthentificationService authentificationService;


	public Boolean authenticate(String userName, String password) {
		AuthentificationServiceFactory authentificationServiceFactory = new AuthentificationServiceFactory();
		authentificationService = authentificationServiceFactory.createAuthentificationService();
		return authentificationService.authenticate(userName, password);
	}

}
