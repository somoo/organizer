package com.somoo.organizer.login.service;

public class AuthentificationServiceFactory {

	public AuthentificationService createAuthentificationService(){
		return new AuthentificationServiceImpl();	
	}
	
}
