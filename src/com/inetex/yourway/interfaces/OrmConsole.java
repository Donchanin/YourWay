package com.inetex.yourway.interfaces;

import java.util.Date;

import com.inetex.yourway.dao.Person;
import com.inetex.yourway.dao.PersonData;


public interface OrmConsole {

 Iterable<String> getAnyJpqlRequest(String jpql);
 
 
 
// public void clearEntity();
 
 
 
}
