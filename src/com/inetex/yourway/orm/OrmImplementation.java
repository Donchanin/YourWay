package com.inetex.yourway.orm;

import java.util.*;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import com.inetex.yourway.dao.Person;
import com.inetex.yourway.dao.PersonData;
import com.inetex.yourway.interfaces.OrmConsole;

public class OrmImplementation implements OrmConsole {

	@PersistenceContext(unitName="springHibernate")
	EntityManager em;

	public Iterable<String> getAnyJpqlRequest(String jpql) {
		
		return hasSeveralAtributes(jpql)?
		runSeveralAtributeRequest(jpql):runOneAtributeRequest(jpql);
	}
	
	private static List<String> getListStringsFromObjects(List<Object> objects){
		List<String> result=new ArrayList<String>();
		for(Object obj:objects){
			result.add(obj.toString());
		}
		return result;
	}
	
	private static List<String> getListStringsFromObjectsArray(List<Object[]> objects){
		
		List<String> result=new ArrayList<String>();
		for(Object[] arObj:objects){
			result.add(getStringFromObjects(arObj));
		}
		
		
		return result;
	}

	private static String getStringFromObjects(Object[] arObj) {
		StringBuilder builder=new StringBuilder(arObj[0].toString());
		for(int i=1; i<arObj.length; i++){
			builder.append(" "+arObj[i].toString());
		}
		return builder.toString();
	}
	
	private static boolean hasSeveralAtributes(String jpql){
		jpql=jpql.toUpperCase();
		int ind=jpql.indexOf("FROM");
		if(ind<0)
			return false;
		return jpql.substring(0, ind).contains(",");
	}
	private  List<String> runOneAtributeRequest(String jpql){
		Query query=em.createQuery(jpql);
		List<Object> objects=query.getResultList();
		return getListStringsFromObjects(objects);
	}
	
	private List<String> runSeveralAtributeRequest(String jpql){
		Query query=em.createQuery(jpql);
		List<Object[]> objects=query.getResultList();
		return getListStringsFromObjectsArray(objects);
	}
	

	
//	@Override
//	@Transactional(readOnly=false)
//	public void clearEntity(){
//		Query q = em.createQuery("SELECT p FROM Person p");
//		List<Person> res = q.getResultList();
//		for( Person person: res){
//			em.remove(person);
//		}
//	}


	
	
	
	
}
