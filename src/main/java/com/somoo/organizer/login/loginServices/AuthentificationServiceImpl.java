package com.somoo.organizer.login.loginServices;

public class AuthentificationServiceImpl implements AuthentificationService{

	@Override
	public Boolean authenticate(String userName, String password) {
		
		return userName.equals(password);
	}

}
