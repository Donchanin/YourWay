package com.inetex.yourway.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "PersonData")
public class PersonData {
	
	/*---------------FIELDS---------------*/
	
	//owner fields from number 1 to number 12
	
	//1
	@Id  @GeneratedValue
	@Column(name = "PersonData_ID")
	int id;
	
	//2
	@Column(name = "Identity")
	String identity;//document
	
	//3
	@Column(name = "Birth_Date")
	@Temporal(value = TemporalType.DATE)
	Date birthDate;
	
	//4
	@Column(name = "First_Name")
	String firstName;
	
	//5
	@Column(name = "Last_Name")
	String lastName;
	
	//6
	@Column(name = "Gender")
	char gender;
	
	//7
	@Column(name = "Family_Status")
	String familyStatus;
	
	//8
	@Column(name = "Work_Phone")
	String workPhone;
	
	//9
	@Column(name = "mobile_Phone")
	String mobilePhone;
	
	//10
	@Column(name = "Home_Phone")
	String homePhone;
	
	//11
	@Column(name = "Occupation")
	String occupation;
	
	//12
	@Column(name = "Education")
	String education;
	
	//13 Injected to one-to-many relation define with Address Entity
//	@OneToMany
//	List<Address> addresses;
	
	//14 Injected to one-to-one relation define with Country Entity
//	@OneToOne
//	private Country birthPlace;
	
	//15 Injected to one-to-many relation define with Country Entity
//	@OneToMany
//	private Set<Country> citizenship;
	
	//16 Injected to one-to-many relation define with PersonCustomData Entity
//	@OneToMany
//	private List<PersonCustomData> personCustomData;
	
	
	/*---------------CONSTRUCTORS---------------*/
	
	public PersonData() {}

	/*---------------GETTERS---------------*/
	
	public int getId() {
		return id;
	}


	public String getIdentity() {
		return identity;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public char getGender() {
		return gender;
	}


	public String getFamilyStatus() {
		return familyStatus;
	}


	public String getWorkPhone() {
		return workPhone;
	}


	public String getMobilePhone() {
		return mobilePhone;
	}


	public String getHomePhone() {
		return homePhone;
	}


	public String getOccupation() {
		return occupation;
	}


	public String getEducation() {
		return education;
	}


//	public List<Address> getAddresses() {
//		return addresses;
//	}


//	public Country getBirthPlace() {
//		return birthPlace;
//	}

	/*---------------SETTERS---------------*/
	
//	public Set<Country> getCitizenship() {
//		return citizenship;
//	}


//	public List<PersonCustomData> getPersonCustomData() {
//		return personCustomData;
//	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setFamilyStatus(String familyStatus) {
		this.familyStatus = familyStatus;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setEducation(String education) {
		this.education = education;
	}

//	public void setAddresses(List<Address> addresses) {
//		this.addresses = addresses;
//	}
//
//	public void setBirthPlace(Country birthPlace) {
//		this.birthPlace = birthPlace;
//	}
//
//	public void setCitizenship(Set<Country> citizenship) {
//		this.citizenship = citizenship;
//	}
//
//	public void setPersonCustomData(List<PersonCustomData> personCustomData) {
//		this.personCustomData = personCustomData;
//	}
	
	
	/*---------------METHODS---------------*/
	@Override
	public String toString() {
		return "PersonData [id=" + id + ", identity=" + identity
				+ ", birthDate=" + birthDate + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender
				+ ", familyStatus=" + familyStatus + ", workPhone=" + workPhone
				+ ", mobilePhone=" + mobilePhone + ", homePhone=" + homePhone
				+ ", occupation=" + occupation + ", education=" + education
				+ "]";
	}
}
