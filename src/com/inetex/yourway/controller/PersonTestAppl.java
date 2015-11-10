package com.inetex.yourway.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.inetex.yourway.interfaces.PersonCRUD;

public class PersonTestAppl {

	private final static int MIN_ASCII_CHARACHTER_CODE = 65;//ASCII code of great English letter A
	private final static int MAX_ASCII_CHARACHTER_CODE = 90;//ASCII code of great English letter Z
	private final static int PASSWORD_LENGTH_TOTAL = 8;
	private final static int PASSWORD_CHAR_PART_LENGTH = 4;
	private final static int LAST_LOGIN_DELAY = 30;//days after registration date
	private final static int PERSON_NUMBER = 5;
	private final static String EMAIL_POSTFIX = "@gmail.com";
	private static final int MIN_DELAY = 30;//years ago from current date
	private static final int MAX_DELAY = 70;//years ago from current date
	
	public static void main(String[] args) {
		
		//uncomment follow line to update Person & PersonData tables:
		fillPersonAndPersonData();
		
		//uncomment follow line to delete records from Person & PersonData tables:
		//clearTables();
	}
	
private static void clearTables() {
		
	AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beansPerson.xml");
	PersonCRUD repository = (PersonCRUD) ctx.getBean("person");
	repository.clearPersonAndPersonDataTable();
}

	

	/**Fills Person And PersonData Tables with random values. Persons quantity defines by PERSON_NUMBER constant*/
	private static void fillPersonAndPersonData() {
		for (int i = 0; i < PERSON_NUMBER; i++){
			AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beansPerson.xml");
			PersonCRUD repository = (PersonCRUD) ctx.getBean("person");
			
			//getting PersonData entity fields:
			Date birthDate = getBirthDate();
			String firstName = getFirstName();
			char gender = getGenger();
			
			//getting Person entity fields:
			String email = getRandomEmail();
			String password = getRandomPassword(PASSWORD_LENGTH_TOTAL, PASSWORD_CHAR_PART_LENGTH);
			Date registrationDate = getRegistrationDate();
			Date lastLogin = getRandomLastLoginDate();
			
			repository.createPerson(email, password, registrationDate, lastLogin, firstName, birthDate, gender);
		}
	}
	
	private static char getGenger() {
		char[] genders = {'m', 'f'};
		char gender = 0;
		for(int i = 0; i  < genders.length; i++){
			Random gen = new Random();
			int indexInGenderArray = gen.nextInt(genders.length);
			gender = genders[indexInGenderArray];
			}
		return gender;
	}

	/**Returns random first name from specified array*/
	private static String getFirstName() {
		String[] names = {"Ivan", "David", "Sarah", "Dvora", "Josef", "Syao"};
		String randomFirstName = "";
		for(int i =0; i < PERSON_NUMBER; i++){
		Random gen = new Random();
		int indexInNamesArray = gen.nextInt(PERSON_NUMBER);
		randomFirstName = names[indexInNamesArray];
		}
		return randomFirstName;
	}

	/**Returns random email*/
	private static String getRandomEmail() {
		return getRandomPassword(PASSWORD_LENGTH_TOTAL, PASSWORD_CHAR_PART_LENGTH) + EMAIL_POSTFIX;
	}
	
	/**Returns random last login date, which defines as current date and random delay sum.
	 * Delay is expressed in calendar days have passed from the current date.
	 * */
	private static Date getRandomLastLoginDate() {
		Calendar calendar=new GregorianCalendar();
		Random gen = new Random();
		int delay = gen.nextInt(LAST_LOGIN_DELAY);
		calendar.add(Calendar.DATE, delay);
		Date lastLogin = calendar.getTime();
		return lastLogin;
	}
	
	/**Returns current date as a registration date*/
	private static Date getRegistrationDate() {
		Calendar calendar=new GregorianCalendar();
		return calendar.getTime();
	}
	
	/**Returns random password, which consist from number and char parts.
	 * Length of each those parts defines by PASSWORD_LENGTH_TOTAL 
	 * and PASSWORD_CHAR_PART_LENGTH constants
	 * */
	private static String getRandomPassword(int passwordLengthTotal, int passwordCharPartLength) {
		int passwordNumberPartLenght = PASSWORD_LENGTH_TOTAL - PASSWORD_CHAR_PART_LENGTH;
		String passwordNumberPart = getPasswordNumbersPart(passwordNumberPartLenght);
		String passwordCharPart = getPasswordCharPart(PASSWORD_CHAR_PART_LENGTH);
		String password = passwordNumberPart + passwordCharPart;
		return password;
	}
	
	/**Getting password char part
	 * A correspondence between the random integer within a specified range and an ASCII symbol table*/
	private static String getPasswordCharPart(int passwordCharPartLength) {
		String passwordCharPart = "";
		for(int i = 0; i < PASSWORD_CHAR_PART_LENGTH; i++){
			int rnd = MIN_ASCII_CHARACHTER_CODE + (int)(Math.random() 
				* ((MAX_ASCII_CHARACHTER_CODE - MIN_ASCII_CHARACHTER_CODE) + 1));
			char charSymbol = (char) rnd;
			passwordCharPart += charSymbol;
		}
		return passwordCharPart;
	}

	private static String getPasswordNumbersPart(int passwordNumberPartLenght) {
		String passwordNumberPart = "";
		for(int i = 0; i < passwordNumberPartLenght; i++){
			Random gen = new Random();
			String numberSymbol = Integer.toString(gen.nextInt(9));
			passwordNumberPart += numberSymbol;
		}
		return passwordNumberPart;
	}
	
	private static Date getBirthDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date date = null;
	      try {
	          date = sdf.parse( getRandomBirthDateString());
	        		 
	      } catch (ParseException ex) {}
		return date;
	}
	
	private static String getRandomBirthDateString() {
		Calendar calendar=new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Random gen = new Random();
		int delay = MIN_DELAY + (int)(Math.random()*((MAX_DELAY - MIN_DELAY)+1));
		calendar.add(Calendar.YEAR, - delay);
		Date date = calendar.getTime();
		String birthDay = sdf.format(date);
		return birthDay;
	}
	
}
