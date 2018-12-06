package com.somoo.organizer.login.loginServices;

public class AuthentificationServiceFactory {

	public AuthentificationService createAuthentificationService(){
		return new AuthentificationServiceImpl();	
	}
	
}
