package com.somoo.organizer.login.loginServices;

public class UserAuthentificationServiceImpl extends AbstractUserAuthentificationService{

	@Override
	public Boolean authenticate(String userName, String password) {
		
		return userName.equals(password);
	}

}
