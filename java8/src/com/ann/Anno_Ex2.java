package com.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface RequestMapping{
	String url();
}

class Container{
	public void processRequest(String url) {
		try {
			Class<?> clazz1 = Class.forName("com.ann.UserController");
			Object instance1 = clazz1.newInstance();
			
			Class<?> clazz2 = Class.forName("com.ann.Txr");
			Object instance2 = clazz2.newInstance();
			
			Method[] methods = clazz1.getMethods();
			for(Method method : methods) {
				RequestMapping rm = method.getAnnotation(RequestMapping.class);
				if(rm!=null) {
					String givenUrl = rm.url();
					if(url.equals(givenUrl)) {
						method.invoke(instance1,new Object[] {});
					}
				}
			}
			Method[] methods1 = clazz2.getMethods();
			for(Method method : methods1) {
				RequestMapping rm = method.getAnnotation(RequestMapping.class);
				if(rm!=null) {
					String givenUrl = rm.url();
					if(url.equals(givenUrl)) {
						method.invoke(instance2,new Object[] {});
					}
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}


class UserController{
	@RequestMapping(url = "/users/register")
	public void doRegister() {
		System.out.println("UserController :: doRegister()");
	}
	@RequestMapping(url = "/users/login")
	public void doLogin() {
		System.out.println("UserController :: doLogin() ");
	}
}


class Txr{
	@RequestMapping(url = "/users/txr")
	public void doTxr(){
		System.out.println("TxrController :: doTxr()");
	}
	
}



public class Anno_Ex2 {

	public static void main(String[] args) throws InterruptedException {
		Container container = new Container();

		TimeUnit.SECONDS.sleep(2);
		container.processRequest("/users/register");

		TimeUnit.SECONDS.sleep(2);
		container.processRequest("/users/login");
		
		TimeUnit.SECONDS.sleep(2);
		container.processRequest("/users/txr");

	}
	
}
