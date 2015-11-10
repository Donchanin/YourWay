package com.inetex.yourway.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.inetex.yourway.interfaces.OrmConsole;
import java.io.*;

public class OrmConsoleAppl {

	public static void main(String[] args) throws ClassNotFoundException {
		AbstractApplicationContext ctx=new FileSystemXmlApplicationContext("beans.xml");
		OrmConsole ormConsole=(OrmConsole) ctx.getBean("database");
		
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("please enter any jpql request ");
			try { 
				String line=console.readLine();
				if(line==null || line.equalsIgnoreCase("exit"))
					break;
				Iterable<String> strings=ormConsole.getAnyJpqlRequest(line);
				
				displayStrings(strings);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		ctx.close();
	}

	private static void displayStrings(Iterable<String> strings) {
		for(String str:strings)
			System.out.println(str);
		System.out.println('\n');
	}
}
