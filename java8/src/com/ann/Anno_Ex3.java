package com.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface SomeInt{
	int i();
}

class Container1{
	public void processReq(int i) {
		try {
			Class<?> class1= Class.forName("com.ann.UserController1");
			Object instance1 = class1.newInstance();
			Method[] methods = class1.getMethods();
			for(Method method:methods) {
				SomeInt si = method.getAnnotation(SomeInt.class);
				if(si!=null) {
					int givenInt = si.i();
					if(i==givenInt) {
						method.invoke(instance1,new Object[] {});
					}
				}
			}
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}

class UserController1{
	@SomeInt(i = 1)
	public void method1(){
	System.out.println("UserController :: method1");
	}
}


public class Anno_Ex3 {
	public static void main(String[] args) throws Exception {
		Container1 conn = new Container1();
		TimeUnit.SECONDS.sleep(2);
		conn.processReq(1);
		
	}
}
