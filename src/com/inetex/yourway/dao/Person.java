package com.inetex.yourway.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "PERSON")
public class Person {
	
		/*---------------FIELDS---------------*/
		
		//1
		@Id  @GeneratedValue
		@Column(name = "Person_ID")
		int id;
		
		//2
		@Column(name = "Email")
		String email; //unique username
		
		//3
		@Column(name = "Password")
		String password;
		
		//4
		@Column(name = "Registration_Date")
		@Temporal(value = TemporalType.DATE)
		Date registrationDate;
		
		//5
		@Column(name = "Last_Login_Date")
		@Temporal(value = TemporalType.DATE)
		Date lastLogin;
		
		//6 Injected to one-to-one relation define
		@OneToOne(cascade=CascadeType.ALL)
		private PersonData personData;
		
		//7 Injected to one-to-many relation define
//		@OneToMany(cascade=CascadeType.ALL)
//		//private List<FamilyMember> familyMembers; 
		
		
		/*---------------CONSTRUCTORS---------------*/


		public Person() {}
		
		
		/*---------------GETTERS---------------*/
		
		//1
		public int getId() {
			return id;
		}
		
		//2
		public String getEmail() {
			return email;
		}
		
		//3
		public String getPassword() {
			return password;
		}
		
		//4
		public Date getRegistrationDate() {
			return registrationDate;
		}
		
		//5
		public Date getLastLogin() {
			return lastLogin;
		}
		
		//6
		public PersonData getPersonData() {
			return personData;
		}
		
		//7
//		public List<FamilyMember> getFamilyMembers() {
//			return familyMembers;
//		}

		
		/*---------------SETTERS---------------*/
		
		//1
		public void setId(int id) {
			this.id = id;
		}

		//2
		public void setEmail(String email) {
			this.email = email;
		}

		//3
		public void setPassword(String password) {
			this.password = password;
		}

		//4
		public void setRegistrationDate(Date registrationDate) {
			this.registrationDate = registrationDate;
		}

		//5
		public void setLastLogin(Date lastLogin) {
			this.lastLogin = lastLogin;
		}
		
		//6
		public void setPersonData(PersonData personData) {
			this.personData = personData;
		}


		
		
		//7
//		public void setFamilyMembers(List<FamilyMember> familyMembers) {
//			this.familyMembers = familyMembers;
//		}
		
		/*---------------METHODS---------------*/
		
		@Override
		public String toString() {
			return "Person [id=" + id + ", email=" + email + ", password="
					+ password + ", registrationDate=" + registrationDate
					+ ", lastLogin=" + lastLogin + ", personData=" + personData
					+ "]";
		}
}
