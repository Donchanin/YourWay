package com.inetex.yourway.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inetex.yourway.dao.Person;
import com.inetex.yourway.dao.PersonData;
import com.inetex.yourway.interfaces.PersonCRUD;

public class PersonRepository implements PersonCRUD {
	
	@PersistenceContext(unitName="springHibernate")
	EntityManager em;
	
	
	@Transactional(readOnly=false)
	@Override
	public void createPerson(String email, String password,
			Date registrationDate, Date lastLogin, String firstName,
			Date birthDate, char gender) {
		PersonData personData = new PersonData();
			personData.setBirthDate(birthDate);
			personData.setFirstName(firstName);
			personData.setGender(gender);
		if(em.find(PersonData.class, personData.getId())==null)
			em.persist(personData);
	
		Person person=new Person();
			person.setEmail(email);
			person.setPassword(password);
			person.setRegistrationDate(registrationDate);
			person.setLastLogin(lastLogin);
			person.setPersonData(personData);//it is very important! Creating field defining relation OneToOne!
		if(em.find(Person.class, person.getId())==null)
			em.persist(person);	
	}


	@Override
	@Transactional(readOnly=false)
	public void clearPersonAndPersonDataTable(){
		Query q = em.createQuery("SELECT p FROM Person p");
		List<Person> res = q.getResultList();
		for( Person person: res){
			em.remove(person);
		}
	}
}
