package com.inetex.yourway.interfaces;

import java.util.Date;

public interface PersonCRUD {
	
	void createPerson (String email, String password, Date registrationDate, Date lastLogin,
			 String firstName, Date birthDate, char gender);
	
	void clearPersonAndPersonDataTable();

}
